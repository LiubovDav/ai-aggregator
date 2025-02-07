package org.liubov.ai_aggregator.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.liubov.ai_aggregator.dto.UserDTO;
import org.liubov.ai_aggregator.mapper.UserMapper;
import org.liubov.ai_aggregator.model.User;
import org.liubov.ai_aggregator.repository.UserRepository;
import org.liubov.ai_aggregator.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());

        if (user != null) {
            // todo: user with such email exists in the DB
            log.error("user with such email exists in the DB");
            return new UserDTO();
        }

        user = userRepository.save(userMapper.toUser(userDTO));
        log.info("User was successfully saved");
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO validate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            // todo: no user with such email in the DB
            log.error("no user with such email in the DB");
            return new UserDTO();
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            // todo: wrong password
            log.error("Wrong password!");
            return new UserDTO();
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userMapper.toUserDTO(userRepository.findByEmail(email));
    }
}
