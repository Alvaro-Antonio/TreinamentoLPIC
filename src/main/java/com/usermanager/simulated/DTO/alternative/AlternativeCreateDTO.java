package com.usermanager.simulated.DTO.alternative;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.usermanager.simulated.jpa.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AlternativeCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8718860753097815154L;

    @NotBlank(message = "title not blank")
    @NotNull(message = "title not null")
    private String title;

    @NotNull
    @Value("false")
    private Boolean correct;

    private Question question;
}
