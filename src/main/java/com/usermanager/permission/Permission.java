package com.usermanager.permission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

}
