package com.fiap.microgs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;


@Entity
@Data
public class LicencaVoo {

    @Id
    @NotNull
    private Long numeroLicenca;

    @NotNull
    private Long idDrone;

    private Date dataEmissao;

    private Date dataValidade;

}
