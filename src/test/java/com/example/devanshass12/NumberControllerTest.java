/*package com.example.lab12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDoubleNumberEndpoint() throws Exception {
        // Given
        int inputNumber = 5;

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/double")
                        .param("number", String.valueOf(inputNumber))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string("10")); // Expected doubled value
    }
}*/

package com.example.devanshass12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumberController.class)
class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDoubleNumberEndpoint() throws Exception {

        int inputNumber = 5;
        int expectedResult = 10;


        mockMvc.perform(get("/double").param("number", String.valueOf(inputNumber)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(expectedResult))));
    }
}

