package com.hotmarks.auth.controllers;

import com.hotmarks.auth.domain.dto.UserDTO;
import com.hotmarks.auth.domain.requests.CreateUserRequest;
import com.hotmarks.auth.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class PrincipalController {
    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello World Secured";
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String id) {
        userService.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id".concat(id);
    }
}
