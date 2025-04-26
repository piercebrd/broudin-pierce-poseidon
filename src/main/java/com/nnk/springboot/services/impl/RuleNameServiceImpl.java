package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameServiceImpl implements RuleNameService {

    @Autowired
    private RuleNameRepository ruleNameRepository;

    @Override
    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    @Override
    public RuleName findById(Integer id) {
        return ruleNameRepository.findById(id).orElse(null);
    }

    @Override
    public RuleName save(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    @Override
    public void delete(Integer id) {
        ruleNameRepository.deleteById(id);
    }
}
