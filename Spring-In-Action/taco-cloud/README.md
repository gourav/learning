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
