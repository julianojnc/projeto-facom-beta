package br.com.api.equipamento.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sub_equipamento")
@Getter
@Setter
public class SubEquipamentoModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_subequipamento;
    private String nome;
    private String patrimonio;
    private String data_compra;
    private String data_vencimento;
    private String data_desvinculacao;
    private String registro_desvinculacao;
    private String serial_number;


    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean vinculado;

    private int equipamento_cod_equipamento;
}
