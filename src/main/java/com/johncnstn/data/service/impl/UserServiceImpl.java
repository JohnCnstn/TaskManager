package com.johncnstn.data.service.impl;

import com.johncnstn.data.detail.CustomUserDetail;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.UserProfile;
import com.johncnstn.data.repository.UserRepository;
import com.johncnstn.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public CustomUserDetail loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        CustomUserDetail customUserDetail = new CustomUserDetail();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(getGrantedAuthorities(user));

        return customUserDetail;
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserProfile userProfile = user.getUserProfile();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        return authorities;
    }

    @Override
<<<<<<< HEAD
    public List<User> findAll() {
        return userRepository.findAll();
    }
=======
    public List<User> findAllByUserProfile(UserProfile userProfile) {
        return userRepository.findAllByUserProfile(userProfile);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public User findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
>>>>>>> f4f3d8cdf813a4cf165d18841f570002778d425e
}
