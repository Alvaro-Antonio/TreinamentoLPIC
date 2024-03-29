package com.usermanager.users;

import com.usermanager.users.dto.UserDTO;
import com.usermanager.users.dto.UserRegisterDTO;
import com.usermanager.users.services.CreateUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final CreateUserService createUserService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "")
    public String index() {
        return "<h1>Bem-vindo ao UserManager</h1>";
    }

    /**
     * Registra um usuário
     */
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        return UserDTO.from(createUserService.createUser(userRegisterDTO));
    }
}
