package com.usermanager.simulated.jpa;

import com.usermanager.simulated.DTO.alternative.AlternativeCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
