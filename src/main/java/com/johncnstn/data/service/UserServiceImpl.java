package com.johncnstn.data.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.Role;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.repository.RoleRepository;
import com.johncnstn.data.repository.UserRepository;
import com.johncnstn.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());

        return userRepository.save(user);
    }
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

}