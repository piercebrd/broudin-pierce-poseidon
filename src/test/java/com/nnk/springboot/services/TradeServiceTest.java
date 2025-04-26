package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.impl.TradeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TradeServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeServiceImpl tradeService; // assuming you have TradeServiceImpl

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        Trade trade1 = new Trade();
        trade1.setTradeId(1);
        trade1.setAccount("Account 1");
        Trade trade2 = new Trade();
        trade2.setTradeId(2);
        trade2.setAccount("Account 2");

        when(tradeRepository.findAll()).thenReturn(Arrays.asList(trade1, trade2));

        // Act
        List<Trade> result = tradeService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(tradeRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        Trade trade = new Trade();
        trade.setTradeId(1);
        trade.setAccount("Account 1");

        when(tradeRepository.findById(1)).thenReturn(Optional.of(trade));

        // Act
        Trade result = tradeService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Account 1", result.getAccount());
        verify(tradeRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        Trade trade = new Trade();
        trade.setAccount("Account 1");

        when(tradeRepository.save(trade)).thenReturn(trade);

        // Act
        Trade result = tradeService.save(trade);

        // Assert
        assertNotNull(result);
        verify(tradeRepository, times(1)).save(trade);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        tradeService.delete(id);

        // Assert
        verify(tradeRepository, times(1)).deleteById(id);
    }
}
