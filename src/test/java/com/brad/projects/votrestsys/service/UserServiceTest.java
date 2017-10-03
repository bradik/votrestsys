package com.brad.projects.votrestsys.service;

import com.brad.projects.votrestsys.model.Role;
import com.brad.projects.votrestsys.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

import static com.brad.projects.votrestsys.UserTestData.ADMIN;
import static com.brad.projects.votrestsys.UserTestData.USER;

/**
 * Created by Brad on 29.08.2017.
 */
public class UserServiceTest extends AbstractServiceTest {
    @Autowired
    protected UserService service;

    @Before
    public void setUp() throws Exception {
        service.evictCache();
    }

    @Test
    public void testCreate() throws Exception {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", false, Collections.singleton(Role.ROLE_USER));
        User created = service.create(newUser);
        newUser.setId(created.getId());

        Assert.assertTrue(Arrays.asList(ADMIN, newUser, USER).toString().equals(service.getAll().toString()));
    }
}
