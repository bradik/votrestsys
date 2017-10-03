package com.brad.projects.votrestsys.web;

import org.junit.Test;

import static com.brad.projects.votrestsys.TestUtil.userAuth;
import static com.brad.projects.votrestsys.UserTestData.ADMIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminRestControllerTest extends AbstractControllerTest {

    @Test
    public void testUsers() throws Exception {
        mockMvc.perform(get("/rest/admin/users")
                .with(userAuth(ADMIN)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
