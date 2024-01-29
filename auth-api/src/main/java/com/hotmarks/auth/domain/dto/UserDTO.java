package com.hotmarks.auth.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserDTO {
    public UserDTO(Long id, String email, String username, String password, Set<RoleDTO> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private Long id;
    private String email;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
