package com.usermanager.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class AuthRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6922291308006049370L;
    @NotNull(message = "email is mandatory")
    @Size(max = 64, message = "email must be less than 64 characters")
    @Email(message = "email should be valid")
    private String email;

    @NotNull(message = "password is mandatory")
    private String password;
}
