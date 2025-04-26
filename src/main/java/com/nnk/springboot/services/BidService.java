package com.nnk.springboot.services;

import com.nnk.springboot.domain.Bid;
import java.util.List;

public interface BidService {
    List<Bid> findAll();
    Bid findById(Integer id);
    Bid save(Bid bid);
    void delete(Integer id);
}
