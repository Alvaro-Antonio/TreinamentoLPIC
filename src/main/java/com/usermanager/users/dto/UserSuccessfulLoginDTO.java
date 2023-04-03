package com.usermanager.users.dto;

import com.usermanager.users.User;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UserSuccessfulLoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3337465005777631152L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String token;

    //private V1UserType type;

    public static UserSuccessfulLoginDTO from(User v1User){
        return UserSuccessfulLoginDTO.builder()
                .id(v1User.getId())
                .firstName(v1User.getFirstName())
                .lastName(v1User.getLastName())
                .email(v1User.getEmail())
                //.type(v1User.getType())
                .build();
    }

}
