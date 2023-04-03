package com.usermanager.simulated.DTO.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.usermanager.simulated.jpa.Feedback;
import com.usermanager.simulated.jpa.Question;
import com.usermanager.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class QuestionCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -795252887881827085L;

    @NotBlank(message = "title not blank")
    @NotNull(message = "title not null")
    @Size(min = 15, max = 512)
    private String title;

    @NotNull(message = "Feedback is mandatory!")
    private Feedback feedback;

    private User userCreate;

    public static QuestionCreateDTO from (Question question){
        return QuestionCreateDTO.builder()
                .title(question.getTitle())
                .feedback(question.getFeedback())
                .build();
    }
}
