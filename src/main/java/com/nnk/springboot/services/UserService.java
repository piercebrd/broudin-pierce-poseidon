package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    void delete(Integer id);
}
