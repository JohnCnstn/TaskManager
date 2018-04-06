package com.johncnstn.test.repository;

import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.entity.Task;
import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByName_thenReturnTask() {
        // given
        Task task = new Task();
        task.setName("asd");

        Project project = new Project();
        project.setName("project");

        task.setProject(project);

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        entityManager.persist(task);
        entityManager.flush();

        // when
        Task found = taskRepository.findByName(task.getName());

        // then
        assert (found.getName()).equals(task.getName());
    }

    @Test
    public void whenCantFindByName_thenReturnNull() {
        // given
        Task task = new Task();
        task.setName("asd");

        Project project = new Project();
        project.setName("project");

        task.setProject(project);

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        entityManager.persist(task);
        entityManager.flush();

        // when
        Task found = taskRepository.findByName("aaaaa");

        // then
        assert (found == null);
    }

    @Test
    public void whenFindByPath_thenReturnTask() {
        // given
        Task task = new Task();
        task.setName("asd");
        task.setPath("ddd");

        Project project = new Project();
        project.setName("project");

        task.setProject(project);

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        entityManager.persist(task);
        entityManager.flush();

        // when
        Task found = taskRepository.findByPath(task.getPath());

        // then
        assert (found.getName()).equals(task.getName());
    }

    @Test
    public void whenCantFindByPath_thenReturnNull() {
        // given
        Task task = new Task();
        task.setName("asd");
        task.setPath("ddd");

        Project project = new Project();
        project.setName("project");

        task.setProject(project);

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        entityManager.persist(task);
        entityManager.flush();

        // when
        Task found = taskRepository.findByPath("ppp");

        // then
        assert (found == null);
    }
}
