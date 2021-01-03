# Learnings

## Implementing `WebMvcConfigurer`

By implementing `WebMvcConfigurer` on a `Configuration` class, we can configure static mappings. In the 
below snippet, we are configuring that if a requests comes on `/` path, that should be handled with
`home` template stored in `src/main/resources/templates`.

This comes handy when a controller only needs to respond with view without any data requirement.

```java
@Configuration
public class StaticContentControllerConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {

        /*
         * This configures that all requests on / should be handled via "home.html" layout.
         */
        registry.addViewController( "/" ).setViewName( "home" );
    }
}
```

## Testing MVC Controller

Spring comes with its own set of magic tricks for testing. Here is how we test for a traditional 
controller annotated with `@Controller`.

```java
@WebMvcTest
public class HomePageControllerTest {

    @Autowired
    private MockMvc mockedMvc;

    @Test
    public void testHomePage() throws  Exception {

        mockedMvc.perform( get( "/" ))
                .andExpect( status().isOk() )
                .andExpect( view().name( "home" ))
                .andExpect( content().string(
                        containsString( "Welcome to ...")
                ));
    }


}
```

## Redirecting to another Page

With this return in a controller with String value, we can instruct spring to take user to new page 
`/orders/current`. `redirect:` prefix asks spring to redirect.

```java
return "redirect:/orders/current";
``````

## Performing Validation

We can use JSR 303 to do validation. Here is how, we can validate an address:
```java
public class Order {

    @NotBlank( message = "Name is required." )
    private String name;

    @NotBlank( message = "Street is required." )
    private String street;

    @NotBlank( message = "City is required." )
    private String city;

    @NotBlank( message = "State is required." )
    private String state;

    @NotBlank( message = "Zip code is required." )
    private String zip;

    @CreditCardNumber( message = "Not a valid credit card number." )
    private String ccNumber;

    @Pattern( regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted as MM/YY" )
    private String ccExpiry;

    @Digits( integer = 3, fraction = 0, message = "Invalid CVV" )
    private String ccCvv;

}
```

`@NotBlank` - Expects value to be not null and have at least one non-whitespace character.
`@CreditCardNumber` - Expects value to satisfy Luhn algorithm.
`@Pattern` - Expects value to satisfy the passed pattern.
`@Digits` - Expects value to have required number of digits.

However, this only takes care of the validation rules itself. We **still** have to ask Spring to validate
the form before calling the handler method. This is done via:

```java
class AController {
    @PostMapping
    public String processOrder(@Valid Order order, Errors allErrors) {

        if (allErrors.hasErrors()) {
            return "design";
        }

        log.info("Order submitted : " + order);
        return "redirect:/";

    }
}
```

However, we still need to show the error status on the form page as well. Thymeleaf offers access to the 
`Errors` object via `fields` property and with its `th:errors` attribute. 
For example, to display validation errors on the credit card number field, you can add a `<span>` element 
that uses these error references to the order form template, as follows.

```html
<span class="validationError"
    th:if="${#fields.hasErrors('ccNumber')}"
    th:errors="*{ccNumber}">CC Num Error</span>”
```

## `ModelAttribute`

With `ModelAttribute` annotation, we can bind a method parameter or method return value to a named
model attribute, which will be exposed to web view. Spring will call this method first before calling 
the handler to ensure that model exists before request handling kicks in. It would then be available to all requests.

It has two variants though:
- When this annotation is used as class member.
  ```java
    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }
    ```
- When this annotation is used as method argument. Here it is expected from Spring to populate this from
  the model (form values), if it is not present then instantiate.
    ```java
    @PostMapping
    public String processDesign(@Valid Taco design, @ModelAttribute Order order, Errors formErrors) {

        if (formErrors.hasErrors()) {
            return "design";
        }

        /*
         * Let's save the design.
         */
        Taco saved = this.tacos.save(design);
        order.addDesign(saved);

        log.info("Processing Design: " + design);
        return "redirect:/orders/current";

    }
    ```

## `SessionAttributes`
With `SessionAttributes`, we grant a controller the ability to store a model into session / multiple
requests. In this snippet, we allow `ModelAttribute` order to be saved across multiple requests as `order`
is mentioned in both, `ModelAttribute` and `SessionAttributes`.

```java
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredients;
    private final TacoRepository tacos;

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }
}
```

## Storing using `JdbcTemplate`

Here is how we can use `JdbcTemplate` to store and read values.
```java
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate template;

    @Autowired
    public JdbcIngredientRepository( JdbcTemplate template ) {
        this.template = template;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return this.template.query( "select id, name, type from ingredient ",
                this::mapRowToIngredient );
    }

    @Override
    public Ingredient findOne(String id) {
        return this.template.queryForObject( "select id, name, type from ingredient where id = ?",
                this::mapRowToIngredient, id );
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        this.template.update( "insert into ingredient( id, name, type ) values( ?, ?, ? )",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );

        return ingredient;
    }

    private Ingredient mapRowToIngredient( ResultSet resultSet, int rowNumber ) throws SQLException {
        return new Ingredient(
                resultSet.getString( "id" ),
                resultSet.getString( "name" ),
                Ingredient.Type.valueOf( resultSet.getString( "type" ))
        );
    }
}
```

## Using `SimpleJdbcInsert` to insert data into database

Here is an example that demonstrates how can we use `SimpleJdbcInsert` to insert values into database.
`SimpleJdbcInsert` also comes up with various options that we can configure at the instantiation. However,
one of the most basic forms require that we declare `generatedColumn` using `.usingGeneratedKeyColumns("id")` and
create a map of column names and values pass it to execute as demonstrated.

```java
@Repository
public class JdbcOrderRepository implements OrderRepository {

  private final SimpleJdbcInsert orderInserter;
  private final SimpleJdbcInsert tacoInOrderInserter;

  @Autowired
  public JdbcOrderRepository(JdbcTemplate template) {

    orderInserter = new SimpleJdbcInsert(template)
            .withTableName("Taco_Order")
            .usingGeneratedKeyColumns("id");

    tacoInOrderInserter = new SimpleJdbcInsert(template)
            .withTableName("Taco_Order_Tacos");

  }

  private long saveOrderBasicDetails(Order order) {

    Map<String, Object> columnToValuesMap = new HashMap<>();

    columnToValuesMap.put("placedAt", order.getPlacedAt());
    columnToValuesMap.put("deliveryName", order.getName());
    columnToValuesMap.put("deliveryStreet", order.getStreet());
    columnToValuesMap.put("deliveryCity", order.getCity());

    columnToValuesMap.put("deliveryState", order.getState());
    columnToValuesMap.put("deliveryZip", order.getZip());
    columnToValuesMap.put("ccNumber", order.getCcNumber());
    columnToValuesMap.put("ccExpiration", order.getCcExpiry());

    columnToValuesMap.put("ccCvv", order.getCcCvv());

    return this.orderInserter.executeAndReturnKey(columnToValuesMap)
            .longValue();

  }
}
```

## Using `PreparedStatementCreator` to insert content into database

To use `PreparedStatementCreator` we make use of `PreparedStatementCreatorFactory` that demands query that we will be 
using to insert data as first argument and type of arguments as `List` in second.  Then using this factory instance,
we create `PreparedStatementCreator` by invoking `newPreparedStatementCreator` on it by passing actual arguments as `List`.

Once we have this `PreparedStatementCreator` instance, we can pass it directly to the `JdbcTemplate` to execute it.
However, if we want to get generated `id` for the row to be returned, it is important to invoke
`factory.setReturnGeneratedKeys( true )` otherwise it will return null.
`

```java
@Repository
public class JdbcTacoRepository implements TacoRepository {

    private static final String INSERT_INTO_TACO = "insert into Taco( name, createdAt ) values ( ?, ? ) ";
    private static final String INSERT_INTO_TACO_INGREDIENT = "insert into Taco_Ingredients( taco, ingredient ) values( ?, ? )";

    private final JdbcTemplate template;

    public JdbcTacoRepository( JdbcTemplate template ) {
        this.template = template;
    }

    private long saveTacoBasicDetails( Taco taco ) {

        taco.setCreatedAt( new Date() );
        PreparedStatementCreatorFactory insertForTacoFactory = new PreparedStatementCreatorFactory( INSERT_INTO_TACO, Types.VARCHAR, Types.TIMESTAMP );
        insertForTacoFactory.setReturnGeneratedKeys( true );

        PreparedStatementCreator insertForTaco = insertForTacoFactory.newPreparedStatementCreator(Arrays.asList( taco.getName(), new Timestamp( taco.getCreatedAt().getTime() )));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.template.update( insertForTaco, keyHolder );

        return keyHolder.getKey().longValue();

    }
}
```

## Magic of Spring JPA

With Spring JPA, Spring can write implementation of the interface methods itself if methods names are written properly.
Let's see an example:

```java
public interface OrderRepository
         extends CrudRepository<Order, Long> {

  List<Order> findByDeliveryZip(String deliveryZip);
    
}
```

By default, Spring JPA provides implementation of different methods written in the `CrudRepository`, however, we can 
also add new method definitions to allow Spring to generate code for us. In the given example, `findByDeliveryZip` asks
Spring to generate method that would return Orders that were placed in a zip. 

Spring Data repositories can use any of these operators:
- `IsAfter, After, IsGreaterThan, GreaterThan`
- `IsGreaterThanEqual, GreaterThanEqual`
- `IsBefore, Before, IsLessThan, LessThan`
- `IsLessThanEqual, LessThanEqual`
- `IsBetween, Between`
- `IsNull, Null`
- `IsNotNull, NotNull`
- `IsIn, In`
- `IsNotIn, NotIn`
- `IsStartingWith, StartingWith, StartsWith`
- `IsEndingWith, EndingWith, EndsWith`
- `IsContaining, Containing, Contains`
- `IsLike, Like`
- `IsNotLike, NotLike`
- `IsTrue, True`
- `IsFalse, False`
- `Is, Equals`
- `IsNot, Not`
- `IgnoringCase, IgnoresCase`

## JPA and Enum

We can control the how an enum is read and stored from database.

```java
@Converter( autoApply = true )
public class IngredientTypeConverter implements AttributeConverter<Ingredient.Type, String> {
    @Override
    public String convertToDatabaseColumn(Ingredient.Type attribute) {
        if( attribute == null ) {
            return null;
        }

        return attribute.toString();
    }

    @Override
    public Ingredient.Type convertToEntityAttribute(String dbData) {

        if( dbData == null ) {
            return null;
        }

        return Stream.of( Ingredient.Type.values() )
                .filter( type -> type.toString().equals( dbData ))
                .findFirst()
                .orElseThrow( IllegalAccessError::new );

    }
}
```

If this is not used, reading or storing problem may occur.

## JPA and schema.sql or data.sql

JPA by itself tries to create tables and it will try to convert camelcase column names into snake_case, which may be 
causing error. To handle this, you will have to chuck out schema.sql completely and let JPA do its work otherwise you
are anyway going to battle with insert queries error.
