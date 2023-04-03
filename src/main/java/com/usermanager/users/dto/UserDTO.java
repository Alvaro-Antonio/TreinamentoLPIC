package com.usermanager.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.usermanager.users.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8444899424565707250L;
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    //private V1UserType type;

    private String profilePicture;

    private LocalDateTime creationDate;

    private LocalDateTime lastLoginDate;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                //.type(user.getType())
                .creationDate(user.getCreationDate())
                .lastLoginDate(user.getLastLoginDate())
                .profilePicture(user.getProfilePicture())
                .build();
    }

    public static List<UserDTO> from(List<User> users) {
        return users.stream().map(UserDTO::from).collect(Collectors.toList());
    }
}