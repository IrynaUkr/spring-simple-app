package com.example.lab1.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class CoffeeControllerTest {
    @Autowired
    private MockMvc mockMvcController;

    @Test
     void testGetCoffee() throws Exception {
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffeeLover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
    @Test
    void testGetCoffeeWithoutRequestParams() throws Exception {
        String expectedValue = "latte";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }
    @Test
    public void testGetCoffeeWithRequestParams() throws Exception {
        String expectedValue = "cappuccino";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee").param("name",
                                "cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }

}