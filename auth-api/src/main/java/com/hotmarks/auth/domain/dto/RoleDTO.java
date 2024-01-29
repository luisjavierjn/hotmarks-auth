package com.hotmarks.auth.domain.dto;

import com.hotmarks.auth.domain.entities.ERole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class RoleDTO {
    public RoleDTO(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private ERole name;
}
