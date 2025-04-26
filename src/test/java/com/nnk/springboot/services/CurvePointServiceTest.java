package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;
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

class CurvePointServiceTest {

    @Mock
    private CurvePointRepository curvePointRepository;

    @InjectMocks
    private CurvePointServiceImpl curvePointService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        CurvePoint cp1 = new CurvePoint();
        cp1.setId(1);
        cp1.setCurveId(101);
        cp1.setTerm(2.0);
        cp1.setValue(2.5);

        CurvePoint cp2 = new CurvePoint();
        cp2.setId(2);
        cp2.setCurveId(102);
        cp2.setTerm(3.0);
        cp2.setValue(3.5);

        when(curvePointRepository.findAll()).thenReturn(Arrays.asList(cp1, cp2));

        // Act
        List<CurvePoint> result = curvePointService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(curvePointRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        CurvePoint cp = new CurvePoint();
        cp.setId(1);
        cp.setCurveId(101);
        cp.setTerm(2.0);
        cp.setValue(2.5);

        when(curvePointRepository.findById(1)).thenReturn(Optional.of(cp));

        // Act
        CurvePoint result = curvePointService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals(101, result.getCurveId());
        verify(curvePointRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        CurvePoint cp = new CurvePoint();
        cp.setCurveId(101);
        cp.setTerm(2.0);
        cp.setValue(2.5);

        when(curvePointRepository.save(cp)).thenReturn(cp);

        // Act
        CurvePoint result = curvePointService.save(cp);

        // Assert
        assertNotNull(result);
        verify(curvePointRepository, times(1)).save(cp);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        curvePointService.delete(id);

        // Assert
        verify(curvePointRepository, times(1)).deleteById(id);
    }
}
