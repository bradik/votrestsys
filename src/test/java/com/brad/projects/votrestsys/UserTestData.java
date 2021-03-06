package com.brad.projects.votrestsys;

import com.brad.projects.votrestsys.model.Role;
import com.brad.projects.votrestsys.model.User;

import static com.brad.projects.votrestsys.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin",Role.ROLE_ADMIN);

}