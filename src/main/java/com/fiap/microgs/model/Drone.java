package com.fiap.microgs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "modelo"))
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String modelo;

    private Long numeroSerie;

    private Long numeroLicenca;

    private Date dataCompra;

    private int horasTotalVoo;

    private int capacidadeBateria;

    private int capacidadeCarga;

}
