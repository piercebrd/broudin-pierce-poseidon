package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repositories.BidRepository;
import com.nnk.springboot.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public Bid findById(Integer id) {
        return bidRepository.findById(id).orElse(null);
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public void delete(Integer id) {
        bidRepository.deleteById(id);
    }
}
