package com.johncnstn.test.repository;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByUserName_thenReturnUser() {
        // given
        User user = new User();
        user.setUserName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByUserName(user.getUserName());

        // then
        assert (found.getUserName()).equals(user.getUserName());
    }

    @Test
    public void whenCantFindByUserName_thenReturnNull() {
        // given
        User user = new User();
        user.setUserName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByUserName("zzz");

        // then
        assert (found == null);
    }

    @Test
    public void whenFindByEmail_thenReturnUser() {
        // given
        User user = new User();
        user.setEmail("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByEmail(user.getEmail());

        // then
        assert (found.getEmail()).equals(user.getEmail());
    }

    @Test
    public void whenCantFindByEmail_thenReturnNull() {
        // given
        User user = new User();
        user.setEmail("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByEmail("www");

        // then
        assert (found == null);
    }

    @Test
    public void whenFindByLastName_thenReturnUser() {
        // given
        User user = new User();
        user.setLastName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByLastName(user.getLastName());

        // then
        assert (found.getLastName()).equals(user.getLastName());
    }

    @Test
    public void whenCantFindByLastName_thenReturnNull() {
        // given
        User user = new User();
        user.setLastName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByLastName("d");

        // then
        assert (found == null);
    }

    @Test
    public void whenFindByFirstName_thenReturnUser() {
        // given
        User user = new User();
        user.setFirstName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByFirstName(user.getFirstName());

        // then
        assert (found.getFirstName()).equals(user.getFirstName());
    }



    @Test
    public void whenCantFindByFirstName_thenReturnNull() {
        // given
        User user = new User();
        user.setFirstName("aaa");

        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByFirstName("d");

        // then
        assert (found == null);
    }
}
