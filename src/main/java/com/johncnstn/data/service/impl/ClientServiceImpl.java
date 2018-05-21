package com.johncnstn.data.service.impl;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.entity.Client;
import com.johncnstn.data.repository.ClientRepository;
import com.johncnstn.data.repository.UserRepository;
import com.johncnstn.data.service.ClientService;
import com.johncnstn.data.service.UserProfileService;
import com.johncnstn.data.service.ClientTypeService;
import com.johncnstn.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
public class ClientServiceImpl implements ClientService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("clientRepository")
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ClientTypeService clientTypeService;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public Client registerNewUserAccount(UserDto userDto) throws EmailExistsException {

        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "  + userDto.getEmail());
        }

        Client client = new Client();

        client.setUserName(userDto.getUserName());
        client.setFirstName(userDto.getFirstName());
        client.setLastName(userDto.getLastName());
        client.setEmail(userDto.getEmail());

        client.setClientType(clientTypeService.getByType("KID"));

        client.setUserProfile(userProfileService.getByType("CLIENT"));

        client.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

}