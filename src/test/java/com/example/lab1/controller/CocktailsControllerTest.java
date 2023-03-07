package com.example.lab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class CocktailsControllerTest {
    @Autowired
    private MockMvc mockMvcController;
// String expectedValue = "cappuccino";
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/coffee").param("name",
//                                "cappuccino"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
//                        value(expectedValue));
//    }

    @Test
    void getCocktailWithParamTest() throws Exception {
        String expected = "milk cocktail";
        mockMvcController.perform(get("/cocktail")
                .param("name","milk cocktail"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(expected))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}