package com.brad.projects.votrestsys.service;

import com.brad.projects.votrestsys.model.User;
import com.brad.projects.votrestsys.to.UserTo;
import com.brad.projects.votrestsys.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void update(UserTo user);

    void evictCache();

    List<User> getAll();

    void enable(int id, boolean enable);


}