package com.usermanager.simulated.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.usermanager.simulated.DTO.feedback.FeedbackCreateDTO;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.URL;

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
public class Feedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_generator")
    @SequenceGenerator(name = "feedback_generator", sequenceName = "feedback_sequence", allocationSize = 1)
    private Long id;

    @Serial
    private static final long serialVersionUID = -1524837905491317331L;

    @NotNull
    @NotBlank
    @URL
    private String link;

    @NotNull
    @NotBlank
    @Size(min = 20,max = 512, message = "description must be less than 512 characters")
    private String feedbackText;

    @OneToOne(mappedBy = "feedback")
    @JsonBackReference
    private Question question;

    public static Feedback from (FeedbackCreateDTO feedbackCreateDTO){
        return Feedback.builder()
                .link(feedbackCreateDTO.getLink())
                .feedbackText(feedbackCreateDTO.getFeedbackText())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Feedback feedback = (Feedback) o;
        return id != null && Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
