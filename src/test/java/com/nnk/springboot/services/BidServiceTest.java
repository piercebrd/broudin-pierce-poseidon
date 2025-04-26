package com.nnk.springboot.services;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repositories.BidRepository;
import com.nnk.springboot.services.impl.BidServiceImpl;
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

class BidServiceTest {

    @Mock
    private BidRepository bidRepository;

    @InjectMocks
    private BidServiceImpl bidService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        Bid bid1 = new Bid();
        bid1.setBidListId(1);
        bid1.setAccount("Account 1");

        Bid bid2 = new Bid();
        bid2.setBidListId(2);
        bid2.setAccount("Account 2");

        when(bidRepository.findAll()).thenReturn(Arrays.asList(bid1, bid2));

        // Act
        List<Bid> result = bidService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(bidRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        Bid bid = new Bid();
        bid.setBidListId(1);
        bid.setAccount("Account 1");

        when(bidRepository.findById(1)).thenReturn(Optional.of(bid));

        // Act
        Bid result = bidService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Account 1", result.getAccount());
        verify(bidRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        Bid bid = new Bid();
        bid.setAccount("Account 1");

        when(bidRepository.save(bid)).thenReturn(bid);

        // Act
        Bid result = bidService.save(bid);

        // Assert
        assertNotNull(result);
        verify(bidRepository, times(1)).save(bid);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        bidService.delete(id);

        // Assert
        verify(bidRepository, times(1)).deleteById(id);
    }
}
