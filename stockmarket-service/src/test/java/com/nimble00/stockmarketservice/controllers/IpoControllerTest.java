package com.nimble00.stockmarketservice.controllers;

import com.nimble00.stockmarketservice.services.IPOService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IpoController.class)
public class IpoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private IPOService ipoService;

    @Test
    public void testTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/ipo/test").accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("ipo-service is working", result.getResponse().getContentAsString());
    }
    @Test
    public void getAllIPOsTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/ipo/all").accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isFound())
                .andReturn();

        assertEquals(List.class, result.getResponse().getContentType());
    }


}
