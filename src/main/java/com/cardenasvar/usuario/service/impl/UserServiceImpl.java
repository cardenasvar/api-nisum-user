package com.cardenasvar.usuario.service.impl;

import com.cardenasvar.usuario.dto.UserRequest;
import com.cardenasvar.usuario.dto.UserResponse;
import com.cardenasvar.usuario.dto.UsersListResponse;
import com.cardenasvar.usuario.model.User;
import com.cardenasvar.usuario.repository.UserRepository;
import com.cardenasvar.usuario.service.UserService;
import com.cardenasvar.usuario.util.Constantes;
import com.cardenasvar.usuario.util.JwtUtil;
import com.cardenasvar.usuario.util.Utils;

import static com.cardenasvar.usuario.util.DateUtils.dateNow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final Logger log;

    public UserServiceImpl(final UserRepository userRepository, final JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.log = LogManager.getLogger(UserServiceImpl.class);
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        log.info("[UserServiceImpl] Init Method: createUser");

        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByEmail(userRequest.getEmail());
        final String token = jwtUtil.generateToken(userRequest.getEmail());

        if (user == null) {
            user = userRepository.save(new User(
                    userRequest.getName(),
                    userRequest.getEmail(),
                    userRequest.getPassword(),
                    userRequest.getPhones(),
                    dateNow(),
                    dateNow(),
                    dateNow(),
                    token,
                    true));
        } else {
            userResponse.setRespuestaBackoffice(Utils.getBackOfficeResponseKO(Constantes.ERROR_MSG_ALREADY_REGISTERED_EMAIL));
            return userResponse;
        }

        if (user.getToken() != null) {
            final String dateNow = dateNow();
            final int updateUser = userRepository.updateUser(user.getEmail(), token, dateNow, dateNow);
            log.info("[UserServiceImpl] Method: createUser, Action: update user, Message: {}", updateUser);
        }

        userResponse = new UserResponse(
                user.getId(),
                user.getCreated(),
                user.getModified(),
                user.getLastLogin(),
                user.getToken(),
                user.getIsActive());
        userResponse.setRespuestaBackoffice(Utils.getBackOfficeResponseOK(Constantes.DESC_RESULT_OK));

        log.info("[UserServiceImpl] Method: createUser, Action: create response, Message: {}", userResponse);
        log.info("[UserServiceImpl] End Method: createUser");
        return userResponse;
    }

    @Override
    public UsersListResponse getUsers() {
        return new UsersListResponse(userRepository.findAll());
    }
}
