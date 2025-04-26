package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import java.util.List;

public interface RuleNameService {
    List<RuleName> findAll();
    RuleName findById(Integer id);
    RuleName save(RuleName ruleName);
    void delete(Integer id);
}
