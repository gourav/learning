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