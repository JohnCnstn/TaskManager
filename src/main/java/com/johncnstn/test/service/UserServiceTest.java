//package com.johncnstn.test.service;
//
//import com.johncnstn.data.entity.Task;
//import com.johncnstn.data.entity.User;
//import com.johncnstn.data.repository.TaskRepository;
//import com.johncnstn.data.repository.UserRepository;
//import com.johncnstn.data.service.TaskService;
//import com.johncnstn.data.service.UserService;
//import com.johncnstn.data.service.impl.TaskServiceImpl;
//import com.johncnstn.data.service.impl.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserServiceTest {
//    @TestConfiguration
//    static class ProjectServiceImplTestContextConfiguration {
//        @Bean
//        public UserService employeeService() {
//            return new UserServiceImpl();
//        }
//    }
//
//    @Autowired
//    private UserService userService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Before
//    public void setUp() {
//        User user = new User();
//        user.setFirstName("alex1");
//        user.setLastName("alex2");
//        user.setUserName("alex3");
//        user.setEmail("alex4");
//
//        Mockito.when(userRepository.findByFirstName(user.getFirstName()))
//                .thenReturn(user);
//
//        Mockito.when(userRepository.findByLastName(user.getLastName()))
//                .thenReturn(user);
//
//        Mockito.when(userRepository.findByUserName(user.getUserName()))
//                .thenReturn(user);
//
//        Mockito.when(userRepository.findByEmail(user.getEmail()))
//                .thenReturn(user);
//    }
//
//    @Test
//    public void whenValidName_thenUserShouldBeFound() {
//        String firstName = "alex1";
//        User found = userService.findByFirstName(firstName);
//
//        assert (found.getFirstName())
//                .equals(firstName);
//    }
//
//    @Test
//    public void whenNotValidName_thenUserShouldNotBeFound() {
//        String firstName = "ddd";
//        User found = userService.findByFirstName(firstName);
//
//        assert (found == null);
//    }
//
//    @Test
//    public void whenValidLastName_thenUserShouldBeFound() {
//        String lastName = "alex2";
//        User found = userService.findByLastName(lastName);
//
//        assert (found.getLastName())
//                .equals(lastName);
//    }
//
//    @Test
//    public void whenNotValidLastName_thenUserShouldNotBeFound() {
//        String firstName = "ddd";
//        User found = userService.findByLastName(firstName);
//
//        assert (found == null);
//    }
//
//    @Test
//    public void whenValidUserName_thenUserShouldBeFound() {
//        String userName = "alex3";
//        User found = userService.findByUserName(userName);
//
//        assert (found.getUserName())
//                .equals(userName);
//    }
//
//    @Test
//    public void whenNotValidUserName_thenUserShouldNotBeFound() {
//        String userName = "ddd";
//        User found = userService.findByUserName(userName);
//
//        assert (found == null);
//    }
//
//    @Test
//    public void whenValidEmail_thenUserShouldBeFound() {
//        String email = "alex4";
//        User found = userService.findByEmail(email);
//
//        assert (found.getEmail())
//                .equals(email);
//    }
//
//    @Test
//    public void whenNotValidEmail_thenUserShouldNotBeFound() {
//        String email = "ddd";
//        User found = userService.findByEmail(email);
//
//        assert (found == null);
//    }
//}

import com.johncnstn.data.entity.Task;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.repository.TaskRepository;
import com.johncnstn.data.repository.UserRepository;
import com.johncnstn.data.service.TaskService;
import com.johncnstn.data.service.UserService;
import com.johncnstn.data.service.impl.TaskServiceImpl;
import com.johncnstn.data.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {
//    @TestConfiguration
//    static class ProjectServiceImplTestContextConfiguration {
//        @Bean
//        public UserService employeeService() {
//            return new UserServiceImpl();
//        }
//    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User();
        user.setFirstName("alex1");
        user.setLastName("alex2");
        user.setUserName("alex3");
        user.setEmail("alex4");

        Mockito.when(userRepository.findByFirstName(user.getFirstName()))
                .thenReturn(user);

        Mockito.when(userRepository.findByLastName(user.getLastName()))
                .thenReturn(user);

        Mockito.when(userRepository.findByUserName(user.getUserName()))
                .thenReturn(user);

        Mockito.when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(user);
    }

    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String firstName = "alex1";
        User found = userService.findByFirstName(firstName);

        assert (found.getFirstName())
                .equals(firstName);
    }

    @Test
    public void whenNotValidName_thenUserShouldNotBeFound() {
        String firstName = "ddd";
        User found = userService.findByFirstName(firstName);

        assert (found == null);
    }

    @Test
    public void whenValidLastName_thenUserShouldBeFound() {
        String lastName = "alex2";
        User found = userService.findByLastName(lastName);

        assert (found.getLastName())
                .equals(lastName);
    }

    @Test
    public void whenNotValidLastName_thenUserShouldNotBeFound() {
        String firstName = "ddd";
        User found = userService.findByLastName(firstName);

        assert (found == null);
    }

    @Test
    public void whenValidUserName_thenUserShouldBeFound() {
        String userName = "alex3";
        User found = userService.findByUserName(userName);

        assert (found.getUserName())
                .equals(userName);
    }

    @Test
    public void whenNotValidUserName_thenUserShouldNotBeFound() {
        String userName = "ddd";
        User found = userService.findByUserName(userName);

        assert (found == null);
    }

    @Test
    public void whenValidEmail_thenUserShouldBeFound() {
        String email = "alex4";
        User found = userService.findByEmail(email);

        assert (found.getEmail())
                .equals(email);
    }

    @Test
    public void whenNotValidEmail_thenUserShouldNotBeFound() {
        String email = "ddd";
        User found = userService.findByEmail(email);

        assert (found == null);
    }
}
