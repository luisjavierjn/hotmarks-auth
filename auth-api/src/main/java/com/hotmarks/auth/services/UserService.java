package com.hotmarks.auth.services;

import com.hotmarks.auth.domain.dto.UserDTO;
import com.hotmarks.auth.domain.entities.ERole;
import com.hotmarks.auth.domain.entities.RoleEntity;
import com.hotmarks.auth.domain.entities.UserEntity;
import com.hotmarks.auth.domain.requests.CreateUserRequest;
import com.hotmarks.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDTO createUser(CreateUserRequest createUserRequest) {
        Set<RoleEntity> roles = createUserRequest.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .email(createUserRequest.getEmail())
                .roles(roles)
                .build();

        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
