package dev.inventio.security.spring.jdbc.controller;

import dev.inventio.security.spring.jdbc.configuration.JdbcSecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith( SpringExtension.class )
public class HeyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFailWithOutAuthentication() throws Exception {

        mockMvc.perform(
                get( "/hey" )
        ).andExpect( status().isUnauthorized() );

    }

    @Test
    @WithUserDetails( "john" )
    public void workWithAuthentication() throws Exception {

        mockMvc.perform(
                get( "/hey" )
        ).andExpect( status().isOk() );

    }

}
