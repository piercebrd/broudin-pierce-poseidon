package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.impl.RuleNameServiceImpl;
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

class RuleNameServiceTest {

    @Mock
    private RuleNameRepository ruleNameRepository;

    @InjectMocks
    private RuleNameServiceImpl ruleNameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        RuleName rule1 = new RuleName();
        rule1.setId(1);
        rule1.setName("Rule 1");

        RuleName rule2 = new RuleName();
        rule2.setId(2);
        rule2.setName("Rule 2");

        when(ruleNameRepository.findAll()).thenReturn(Arrays.asList(rule1, rule2));

        // Act
        List<RuleName> result = ruleNameService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(ruleNameRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule 1");

        when(ruleNameRepository.findById(1)).thenReturn(Optional.of(rule));

        // Act
        RuleName result = ruleNameService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Rule 1", result.getName());
        verify(ruleNameRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        RuleName rule = new RuleName();
        rule.setName("Rule 1");

        when(ruleNameRepository.save(rule)).thenReturn(rule);

        // Act
        RuleName result = ruleNameService.save(rule);

        // Assert
        assertNotNull(result);
        verify(ruleNameRepository, times(1)).save(rule);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        ruleNameService.delete(id);

        // Assert
        verify(ruleNameRepository, times(1)).deleteById(id);
    }
}
