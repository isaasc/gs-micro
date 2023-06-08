package com.fiap.microgs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class LicencaVoo {

    @Id
    @NotNull
    private Long numeroLicenca;

    private Long idDrone;

    @NotNull
    private Date dataEmissao;

    @NotNull
    private Date dataValidade;

}
