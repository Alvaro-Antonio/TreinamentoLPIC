package com.usermanager.indicators.jpa;

import com.usermanager.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Indicators implements Serializable {

    @Serial
    private static final long serialVersionUID = 8185108157531821274L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indicators_generator")
    @SequenceGenerator(name = "indicators_generator", sequenceName = "indicators_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    private Long score;

    @ManyToMany
    @JoinTable(name="indicators_achievement", joinColumns=
            {@JoinColumn(name="indicators_id")}, inverseJoinColumns=
            {@JoinColumn(name="achievement_id")})
    private Set<Achievement> achievements;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
