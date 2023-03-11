package com.usermanager.indicators.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
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
