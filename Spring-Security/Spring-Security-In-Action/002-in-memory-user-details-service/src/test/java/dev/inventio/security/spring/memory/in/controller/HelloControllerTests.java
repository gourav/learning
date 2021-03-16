package dev.inventio.security.spring.memory.in.controller;

import dev.inventio.security.spring.memory.in.configuration.SecurityBeansConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * If we don't import the security beans configuration, it conveniently skips configuration of beans that we require.
 * If not in this way, we will have to use following structure.
 *
 * @SpringBootTest
 * @AutoConfigureMockMvc
 *
 * then application would run properly.
 */
@WebMvcTest( HelloController.class )
@ExtendWith( SpringExtension.class )
@Import( SecurityBeansConfiguration.class )
public class HelloControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName( "Test calling /hey end points without authentication should return unAuthorized." )
    public void shouldReturnUnAuthorizedIfNoAuthenticationDetailsProvided() throws Exception {

        mvc.perform(
                get( "/hey" )
        ).andExpect( status().isUnauthorized() );

    }

    @Test
    @WithUserDetails( "john" )
    @DisplayName( "Test calling /hey end points with authentication should return OK." )
    public void shouldReturnOkayIfAuthenticationDetailsProvided() throws Exception {

        mvc.perform(
                get( "/hey" )
        ).andExpect( status().isOk() );

    }

}
