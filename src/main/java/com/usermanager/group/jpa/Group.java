package com.usermanager.group.jpa;

import com.usermanager.group.dto.GroupCreateDTO;
import com.usermanager.permission.jpa.Permission;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="group_manager")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 8647104129250551803L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    @SequenceGenerator(name = "group_generator", sequenceName = "group_sequence", allocationSize = 1)
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String description;

    @ManyToMany
    @JoinTable(name="group_permission", joinColumns=
            {@JoinColumn(name="group_id")}, inverseJoinColumns=
            {@JoinColumn(name="permission_id")})
    private Set<Permission> permissions;

//    @ManyToOne
//    private User user;

    public static Group from (GroupCreateDTO groupCreateDTO){
        return Group
                .builder()
                .name(groupCreateDTO.getName())
                .description(groupCreateDTO.getDescription())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Group group = (Group) o;
        return id != null && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
