package com.usermanager.simulated.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alternative implements Serializable {

    @Serial
    private static final long serialVersionUID = -3583657800912094731L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternative_generator")
    @SequenceGenerator(name = "alternative_generator", sequenceName = "alternative_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "title not blank")
    @NotNull(message = "title not null")
    private String title;

    @NotNull
    @Value("false")
    private Boolean correct;

    @NotNull(message = "Question is mandatory")
    @JoinColumn(name = "question_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private Question question;

    public static Alternative from (AlternativeCreateDTO alternativeCreateDTO){
        return Alternative.builder()
                .correct(alternativeCreateDTO.getCorrect())
                .title(alternativeCreateDTO.getTitle())
                .question(alternativeCreateDTO.getQuestion())
                .build();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Alternative that = (Alternative) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
