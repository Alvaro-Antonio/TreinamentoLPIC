package com.usermanager.simulated.jpa;

import com.usermanager.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
