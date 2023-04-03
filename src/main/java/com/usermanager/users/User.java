package com.usermanager.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usermanager.indicators.jpa.Indicators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.usermanager.users.dto.UserRegisterDTO;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@Entity(name = "user")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_manager")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "firstName cannot be blank")
    @NotNull(message = "firstName is mandatory")
    @Size(min = 3, max = 64, message = "firstName must be less than 64 characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank")
    @NotNull(message = "lastName is mandatory")
    @Size(min = 3, max = 64, message = "lastName must be less than 64 characters")
    private String lastName;

    @NotNull(message = "email is mandatory")
    @Size(max = 64, message = "email must be less than 64 characters")
    @Email(message = "email should be valid")
    @Column(unique = true)
    private String email;

    @NotNull(message = "password is mandatory")
    @JsonIgnore
    private String password;

//    @NotNull(message = "type is mandatory")
//    private UserType type;

    @JsonIgnore
    private String profilePicture;

    @NotNull(message = "creationDate is mandatory")
    @JsonIgnore
    private LocalDateTime creationDate;

    @JsonIgnore
    private LocalDateTime lastLoginDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indicators_id", referencedColumnName = "id")
    private Indicators indicators;

    public String getUsername (){
        return this.email;
    }

    public static User from(UserRegisterDTO userRegisterDTO) {
        return User.builder()
                .firstName(userRegisterDTO.getFirstName())
                .lastName(userRegisterDTO.getLastName())
                .email(userRegisterDTO.getEmail())
                .password(userRegisterDTO.getPassword())
                .build();
    }
}
