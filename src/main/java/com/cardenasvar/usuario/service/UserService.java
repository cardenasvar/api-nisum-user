package com.cardenasvar.usuario.service;

import com.cardenasvar.usuario.dto.UserRequest;
import com.cardenasvar.usuario.dto.UserResponse;
import com.cardenasvar.usuario.dto.UsersListResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UsersListResponse getUsers();
}