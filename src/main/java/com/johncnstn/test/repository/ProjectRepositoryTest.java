package com.johncnstn.test.repository;

import com.johncnstn.data.entity.Manager;
import com.johncnstn.data.entity.Project;
import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByName_thenReturnProject() {
        // given
        Project project = new Project("aaa");

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        userProfile.getType();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        // when
        Project found = projectRepository.findByName(project.getName());

        // then
        assert  (found.getName()) .equals(project.getName());
    }

    @Test
    public void whenFindByDescription_thenReturnProject() {
        // given
        Project project = new Project();

        project.setDescription("odkodk");

        Manager manager = new Manager();
        UserProfile userProfile = new UserProfile();
        userProfile.getType();
        manager.setUserProfile(userProfile);
        project.setManager(manager);

        entityManager.persist(manager);
        entityManager.flush();

        entityManager.persist(project);
        entityManager.flush();

        // when
        Project found = projectRepository.findByDescription(project.getDescription());

        // then
        assert   (found.getId()) == (project.getId());
    }
}
