package com.fiap.microgs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class HistoricoVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idDrone;

    private String latitudeInicio;

    private String latitudeFim;

    private String longitudeInicio;

    private String longitudeFim;

    private int altitude;

    private Date dataDecolagem;

    private Date dataAterrisagem;

    private int velocidadeMedia;
}
