package com.usermanager.permission.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.usermanager.permission.jpa.Permission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class PermissionCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 762303265011151011L;
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String description;

    public static PermissionCreateDTO from (Permission permission){
        return PermissionCreateDTO
                .builder()
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }
}
