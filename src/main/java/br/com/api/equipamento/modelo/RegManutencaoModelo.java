package br.com.api.equipamento.modelo;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reg_manutencao")
@Getter
@Setter
public class RegManutencaoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_regmanutencao;
    private String registro;
    private String valor;
    private Blob pdf_arquivo;
    private int equipamento_cod_equipamento;
}
