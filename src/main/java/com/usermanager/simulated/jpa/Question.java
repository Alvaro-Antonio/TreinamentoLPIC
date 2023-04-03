package com.usermanager.simulated.jpa;

import com.usermanager.simulated.DTO.question.QuestionCreateDTO;
import com.usermanager.simulated.DTO.question.QuestionDTO;
import com.usermanager.users.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 8255541387391760428L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
    @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "title not blank")
    @NotNull(message = "title not null")
    @Size(min = 15, max = 512)
    private String title;

    @NotNull(message = "user is mandatory")
    @JoinColumn(name = "user_create_id")
    @ManyToOne
    private User userCreate;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    public static Question from(QuestionDTO questionDTO) {
        return Question.builder()
                .id(questionDTO.getId())
                .title(questionDTO.getTitle())
                .userCreate(questionDTO.getUserCreate())
                .feedback(questionDTO.getFeedback())
                .build();
    }

    public static Question from(QuestionCreateDTO questionDTO) {
        return Question.builder()
                .title(questionDTO.getTitle())
                .userCreate(questionDTO.getUserCreate())
                .feedback(questionDTO.getFeedback())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
