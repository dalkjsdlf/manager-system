package io.ratel.managesystem.domain.application.entity;

import io.ratel.managesystem.common.entity.AuditableFields;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="APPLICATION")
@Getter
public class Application extends AuditableFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Setter
    @Column(name = "NAME", nullable = false) private String name;

}
