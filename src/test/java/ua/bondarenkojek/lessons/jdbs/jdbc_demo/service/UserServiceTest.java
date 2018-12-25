package ua.bondarenkojek.lessons.jdbs.jdbc_demo.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.dao.UserDao;
import ua.bondarenkojek.lessons.jdbs.jdbc_demo.model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceTest {
    private UserService userService;
    private List<User> userList;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl(Mockito.mock(UserDao.class));

        userList = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        userList.clear();
    }

    @Test
    public void testGetAllNamesUpperCaseOK() {
        //Test data
        String bob = "Bob";
        String bill = "Bill";

        User user1 = new User();
        User user2 = new User();
        user1.setName(bob);
        user2.setName(bill);

        userList.add(user1);
        userList.add(user2);

        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.findAll()).thenReturn(userList);

        userService = new UserServiceImpl(userDao);

        List<String> actualAllNamesUpperCase = userService.getAllNamesUpperCase();
        List<String> expectedNames = Arrays.asList(bob.toUpperCase(), bill.toUpperCase());

        Assert.assertEquals(expectedNames, actualAllNamesUpperCase);
    }

    @Test
    public void testGetAllNamesUpperCaseNullName() {
        //Test data
        String bob = null;

        User user1 = new User();
        user1.setName(bob);
        userList.add(user1);


        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.findAll()).thenReturn(userList);

        userService = new UserServiceImpl(userDao);

            List<String> actualAllNamesUpperCase = userService.getAllNamesUpperCase();

            Assert.assertNotEquals(userList, actualAllNamesUpperCase);
    }
}