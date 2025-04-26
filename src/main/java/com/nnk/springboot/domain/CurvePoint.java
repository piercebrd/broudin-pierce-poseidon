package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CurvePoint")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotNull(message = "CurveId is mandatory")
    private Integer curveId;

    private Timestamp asOfDate;

    @NotNull(message = "Term is mandatory")
    private Double term;

    @NotNull(message = "Value is mandatory")
    private Double value;

    private Timestamp creationDate;
}
