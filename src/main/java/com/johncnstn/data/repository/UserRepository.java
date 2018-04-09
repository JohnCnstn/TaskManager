package com.johncnstn.data.repository;

import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserProfile(UserProfile userProfile);
    User findByEmail(String email);
    User findByUserName(String userName);
    User findByLastName(String lastName);
    User findByFirstName(String firstName);
    User findByUserNameAndPassword(String userName, String password);
}
