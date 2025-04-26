package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService {

    @Autowired
    private CurvePointRepository curvePointRepository;

    @Override
    public List<CurvePoint> findAll() {
        return curvePointRepository.findAll();
    }

    @Override
    public CurvePoint findById(Integer id) {
        return curvePointRepository.findById(id).orElse(null);
    }

    @Override
    public CurvePoint save(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    @Override
    public void delete(Integer id) {
        curvePointRepository.deleteById(id);
    }
}
