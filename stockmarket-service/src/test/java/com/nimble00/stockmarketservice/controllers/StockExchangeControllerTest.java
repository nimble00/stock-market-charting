package com.nimble00.stockmarketservice.controllers;

import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.repository.StockExchangeRepo;
import com.nimble00.stockmarketservice.services.StockExchangeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StockExchangeController.class)
public class StockExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @InjectMocks
//    private StockExchangeService stockExchangeService;
//
//    @Mock
//    private StockExchangeRepo stockExchangeRepo;

    @Test
    public void testTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/stockExchange/test").accept(MediaType.ALL);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string("stock exchange service is working"));
//                .andReturn();

        assertEquals("stock exchange service is working", result.getResponse().getContentAsString());
    }

}