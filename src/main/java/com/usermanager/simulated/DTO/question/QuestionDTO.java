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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class QuestionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1410674872539341148L;

    private Long id;

    @NotBlank(message = "title not blank")
    @NotNull(message = "title not null")
    @Size(min = 15, max = 512)
    private String title;

    @NotNull(message = "user is mandatory")
    private User userCreate;

    private Feedback feedback;

    public static QuestionDTO from (Question question){
        return QuestionDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .userCreate(question.getUserCreate())
                .feedback(question.getFeedback())
                .build();
    }
}
