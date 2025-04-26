package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.impl.RatingServiceImpl;
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

class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingServiceImpl ratingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        Rating rating1 = new Rating();
        rating1.setId(1);
        rating1.setMoodysRating("Aaa");
        rating1.setOrderNumber(1);

        Rating rating2 = new Rating();
        rating2.setId(2);
        rating2.setMoodysRating("Baa");
        rating2.setOrderNumber(2);

        when(ratingRepository.findAll()).thenReturn(Arrays.asList(rating1, rating2));

        // Act
        List<Rating> result = ratingService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(ratingRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Aaa");
        rating.setOrderNumber(1);

        when(ratingRepository.findById(1)).thenReturn(Optional.of(rating));

        // Act
        Rating result = ratingService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Aaa", result.getMoodysRating());
        verify(ratingRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        Rating rating = new Rating();
        rating.setMoodysRating("Aaa");
        rating.setOrderNumber(1);

        when(ratingRepository.save(rating)).thenReturn(rating);

        // Act
        Rating result = ratingService.save(rating);

        // Assert
        assertNotNull(result);
        verify(ratingRepository, times(1)).save(rating);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        ratingService.delete(id);

        // Assert
        verify(ratingRepository, times(1)).deleteById(id);
    }
}
