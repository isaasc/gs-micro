package com.fiap.microgs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
public class HistoricoVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idDrone;

    private String latitudeInicio;

    private String latitudeFim;

    private String longitudeInicio;

    private String longitudeFim;

    private String altitudeMedia;

    private Date dataDecolagem;

    private Date dataAterrisagem;

    private String velocidadeMedia;
}
