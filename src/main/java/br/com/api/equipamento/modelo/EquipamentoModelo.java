package br.com.api.equipamento.modelo;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipamento")
@Getter
@Setter
public class EquipamentoModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_equipamento;
    private String nome;
    private String patrimonio;
    private String local;
    private String setor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private String data_compra;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private String data_vencimento;

    private String usuario;
    private String email_usuario;
    private String contato_usuario;
    private String marca;
    private String service_tag;
    private String express_code;
    private int usuario_cod_usuario;
}
