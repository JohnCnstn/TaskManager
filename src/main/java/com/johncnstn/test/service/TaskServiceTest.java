//package com.johncnstn.test.service;
//
//import com.johncnstn.data.entity.Task;
//import com.johncnstn.data.repository.TaskRepository;
//import com.johncnstn.data.service.TaskService;
//import com.johncnstn.data.service.impl.TaskServiceImpl;
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
////public class TaskServiceTest {
//
//    @TestConfiguration
//    static class ProjectServiceImplTestContextConfiguration {
//        @Bean
//        public TaskService employeeService() {
//            return new TaskServiceImpl();
//        }
//    }
//
//    @Autowired
//    private TaskService taskService;
//
//    @MockBean
//    private TaskRepository taskRepository;
//
//    @Before
//    public void setUp() {
//        Task task = new Task();
//        task.setName("alex");
//        task.setPath("aaa");
//
//        Mockito.when(taskRepository.findByName(task.getName()))
//                .thenReturn(task);
//
//        Mockito.when(taskRepository.findByPath(task.getPath()))
//                .thenReturn(task);
//    }
//
//    @Test
//    public void whenValidName_thenTaskShouldBeFound() {
//        String name = "alex";
//        Task found = taskService.findByName(name);
//
//        assert (found.getName())
//                .equals(name);
//    }
//
//    @Test
//    public void whenNotValidName_thenTaskShouldNotBeFound() {
//        String name = "ddd";
//        Task found = taskService.findByName(name);
//
//        assert (found == null);
//    }
//
//    @Test
//    public void whenValidPath_thenTaskShouldBeFound() {
//        String path = "aaa";
//        Task found = taskService.findByPath(path);
//
//        assert (found.getPath())
//                .equals(path);
//    }
//
//    @Test
//    public void whenNotValidPath_thenTaskShouldNotBeFound() {
//        String path = "ddd";
//        Task found = taskService.findByPath(path);
//
//        assert (found == null);
//    }
//}

import com.johncnstn.data.entity.Task;
import com.johncnstn.data.repository.TaskRepository;
import com.johncnstn.data.service.TaskService;
import com.johncnstn.data.service.impl.TaskServiceImpl;
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
public class TaskServiceTest {
//
//    @TestConfiguration
//    static class ProjectServiceImplTestContextConfiguration {
//        @Bean
//        public TaskService employeeService() {
//            return new TaskServiceImpl();
//        }
//    }

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Before
    public void setUp() {
        Task task = new Task();
        task.setName("alex");
        task.setPath("aaa");

        Mockito.when(taskRepository.findByName(task.getName()))
                .thenReturn(task);

        Mockito.when(taskRepository.findByPath(task.getPath()))
                .thenReturn(task);
    }

    @Test
    public void whenValidName_thenTaskShouldBeFound() {
        String name = "alex";
        Task found = taskService.findByName(name);

        assert (found.getName())
                .equals(name);
    }

    @Test
    public void whenNotValidName_thenTaskShouldNotBeFound() {
        String name = "ddd";
        Task found = taskService.findByName(name);

        assert (found == null);
    }

    @Test
    public void whenValidPath_thenTaskShouldBeFound() {
        String path = "aaa";
        Task found = taskService.findByPath(path);

        assert (found.getPath())
                .equals(path);
    }

    @Test
    public void whenNotValidPath_thenTaskShouldNotBeFound() {
        String path = "ddd";
        Task found = taskService.findByPath(path);

        assert (found == null);
    }
}
