package com.johncnstn.test.service;

import com.johncnstn.data.entity.Project;
import com.johncnstn.data.repository.ProjectRepository;
import com.johncnstn.data.service.ProjectService;
import com.johncnstn.data.service.impl.ProjectServiceImpl;
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
public class ProjectServiceTest {
//    @TestConfiguration
//    static class ProjectServiceImplTestContextConfiguration {
//
//        @Bean
//        public ProjectService employeeService() {
//            return new ProjectServiceImpl();
//        }
//    }

    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

    @Before
    public void setUp() {
        Project project = new Project("alex");
        project.setDescription("ddd");
        project.setQuantity(1);

        Mockito.when(projectRepository.findByName(project.getName()))
                .thenReturn(project);

        Mockito.when(projectRepository.findByDescription(project.getDescription()))
                .thenReturn(project);

        Mockito.when(projectRepository.findByQuantity(project.getQuantity()))
                .thenReturn(project);
    }

    @Test
    public void whenValidName_thenProjectShouldBeFound() {
        String name = "alex";
        Project found = projectService.findByName(name);

        assert (found.getName())
                .equals(name);
    }

    @Test
    public void whenNotValidName_thenProjectShouldNotBeFound() {
        String name = "d";
        Project found = projectService.findByName(name);
        assert found == null;
    }

    @Test
    public void whenValidDescription_thenProjectShouldBeFound() {
        String description = "ddd";
        Project found = projectService.findByDescription(description);

        assert (found.getDescription())
                .equals(description);
    }

    @Test
    public void whenNotValidDescription_thenProjectShouldNotBeFound() {
        String description = "d";
        Project found = projectService.findByDescription(description);
        assert found == null;
    }

    @Test
    public void whenValidQuantity_thenProjectShouldBeFound() {
        int quantity = 1;
        Project found = projectService.findByQuantity(quantity);

        assert (found.getQuantity()) == quantity;
    }

    @Test
    public void whenNotValidQuantity_thenProjectShouldNotBeFound() {
        int quantity = 2;
        Project found = projectService.findByQuantity(quantity);
        assert found == null;
    }
}
