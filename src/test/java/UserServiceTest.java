import com.brad.projects.votrestsys.model.Role;
import com.brad.projects.votrestsys.model.User;
import com.brad.projects.votrestsys.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

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

        Assert.assertTrue(Arrays.asList(UserTestData.ADMIN, newUser, UserTestData.USER).toString().equals(service.getAll().toString()));
    }
}
