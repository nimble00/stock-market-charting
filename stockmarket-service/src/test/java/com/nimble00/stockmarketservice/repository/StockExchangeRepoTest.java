package com.nimble00.stockmarketservice.repository;

import com.nimble00.stockmarketservice.models.StockExchange;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StockExchangeRepoTest {

    @Autowired
    private StockExchangeRepo stockExchangeRepo;

    @Test
    public void testFindAll() {
        List<StockExchange> stockExchangeList = stockExchangeRepo.findAll();
        assertEquals(3,stockExchangeList.size());
    }

    @Test
    public void testFindOne() {
        StockExchange stockExchange = stockExchangeRepo.findById(10001).get();
        assertEquals("NYSE",stockExchange.getName());
    }
}
