package com.johncnstn.data.repository;

import com.johncnstn.data.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByType(String type);
}
