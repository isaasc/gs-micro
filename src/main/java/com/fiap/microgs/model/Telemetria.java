package com.fiap.microgs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Telemetria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String latitude;

    @NotNull
    @NotBlank
    private String longitude;

    @NotNull
    @NotBlank
    private String velocidade;

    @NotNull
    @NotBlank
    private String direcao;

    private Date dataHora;

}
