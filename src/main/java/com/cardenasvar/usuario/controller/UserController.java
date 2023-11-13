package com.cardenasvar.usuario.controller;

import com.cardenasvar.usuario.dto.AuthRequest;
import com.cardenasvar.usuario.dto.BackofficeResponse;
import com.cardenasvar.usuario.dto.UserRequest;
import com.cardenasvar.usuario.dto.UserResponse;
import com.cardenasvar.usuario.dto.UsersListResponse;
import com.cardenasvar.usuario.service.UserService;
import com.cardenasvar.usuario.util.Constantes;
import com.cardenasvar.usuario.util.JwtUtil;
import com.cardenasvar.usuario.util.Utils;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    private final Logger log;

    @Value("${user.pass.regexp}")
    private String userPassRegexp;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserController(final UserService userService) {
        this.log = LogManager.getLogger(UserController.class);;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception ex) {
            return new ResponseEntity<>(Constantes.ERROR_MSG_INVALID_USERNAME_PASSWORD, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUserName()), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Proceso finalizado correctamente.", response = UserResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = BackofficeResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = BackofficeResponse.class),
            @ApiResponse(code = 403, message = "Forbidden", response = BackofficeResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = BackofficeResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = BackofficeResponse.class)
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody final UserRequest userRequest) {
        UserResponse response = validateRegexPassword(userRequest.getPassword());

        if (response.getRespuestaBackoffice() != null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
        try {
            response = userService.createUser(userRequest);
        } catch (Exception e) {
			log.error(Constantes.DESC_RESULT_KO, e);
			response.setRespuestaBackoffice(Utils.getBackOfficeResponseKO(e.getMessage()));
		}

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsersListResponse getUsers() {
        return userService.getUsers();
    }

    private UserResponse validateRegexPassword(final String password) {
        log.info("[UserController] Init Method: validateRegexPassword");

        UserResponse uResponse = new UserResponse();
        Pattern pattern = Pattern.compile(userPassRegexp);
        Matcher mather = pattern.matcher(password);

        if (mather.find() != true) {
            uResponse.setRespuestaBackoffice(
                    Utils.getBackOfficeResponseKO(Constantes.ERROR_MSG_FORMAT_PASSWORD));
        }

        log.info("[UserController] End Method: validateRegexPassword");
        return uResponse;
    }
}