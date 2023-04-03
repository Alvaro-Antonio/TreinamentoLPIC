package com.usermanager.permission.jpa;

import com.usermanager.permission.dto.PermissionCreateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="permission_manager")
public class Permission implements Serializable {

    private static final long serialVersionUID = -6007993487204547585L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_generator")
    @SequenceGenerator(name = "permission_generator", sequenceName = "permission_sequence", allocationSize = 1)
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String description;

    public static Permission from (PermissionCreateDTO permissionCreateDTO) {
        return Permission
                .builder()
                .name(permissionCreateDTO.getName())
                .description(permissionCreateDTO.getDescription())
                .build();
    }
}
