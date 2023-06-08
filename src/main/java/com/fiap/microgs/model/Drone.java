package com.fiap.microgs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private Long numeroSerie;

    private Long numeroLicenca;

    private Date dataCompra;

    private Long horasTotalVoo;

    private String capacidadeBateria;

    private String capacidadeCarga;

}
