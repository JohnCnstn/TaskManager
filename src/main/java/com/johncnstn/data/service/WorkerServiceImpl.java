package com.johncnstn.data.service;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.Worker;
import com.johncnstn.data.repository.UserRepository;
import com.johncnstn.data.repository.WorkerRepository;
import com.johncnstn.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
public class WorkerServiceImpl implements WorkerService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("workerRepository")
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public Worker registerNewUserAccount(UserDto userDto) throws EmailExistsException {

        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "  + userDto.getEmail());
        }

        Worker worker = new Worker();

        worker.setUserName(userDto.getUserName());
        worker.setFirstName(userDto.getFirstName());
        worker.setLastName(userDto.getLastName());
        worker.setEmail(userDto.getEmail());

        worker.setUserProfile(userProfileService.getByType("WORKER"));

        worker.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        return workerRepository.save(worker);
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

}