package dev.inventio.security.spring.adapter.security.controller;

import dev.inventio.security.spring.adapter.security.configuration.ProjectSecurityConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import( ProjectSecurityConfiguration.class )
@AutoConfigureMockMvc
public class HeyControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName( "Test calling /hey end point without authentication should return UnAuthorized" )
    public void shouldReturnUnAuthorizedIfCalledWithoutAuthentication() throws Exception {

        mvc.perform(
                get( "/hey" )
        ).andExpect( status().isUnauthorized() );

    }

    @Test
    @WithUserDetails( "john" )
    @DisplayName( "Test calling /hey end point with authentication should return ok" )
    public void shouldReturnOkIfCalledWithAuthentication() throws Exception {

        mvc.perform(
                get( "/hey" )
        ).andExpect( status().isOk() );

    }

}
