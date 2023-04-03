package com.usermanager.indicators.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Achievement implements Serializable {

    @Serial
    private static final long serialVersionUID = -1646867098754843974L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "achievement_generator")
    @SequenceGenerator(name = "achievement_generator", sequenceName = "achievement_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    private String icon;

    @NotNull
    private String title;

    @NotNull
    private String description;

}
