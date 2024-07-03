package br.com.api.equipamento.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.equipamento.modelo.EquipamentoModelo;
import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.repositorio.EquipamentoRepositorio;

@Service
public class EquipamentoServico {

    @Autowired
    private EquipamentoRepositorio equipamentoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    // metodo para listar todos os produtos
    public Iterable<EquipamentoModelo> listar() {
        return equipamentoRepositorio.findAll();
    }

    // metodo para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(EquipamentoModelo equipamentoModelo, String acao) {

        if (equipamentoModelo.getNome().equals("")) {
            respostaModelo.setMensagem("Nome do Equipamento deve ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (equipamentoModelo.getPatrimonio().equals("")) {
            respostaModelo.setMensagem("Patrimonio deve ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<EquipamentoModelo>(equipamentoRepositorio.save(equipamentoModelo),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<EquipamentoModelo>(equipamentoRepositorio.save(equipamentoModelo),
                        HttpStatus.OK);
            }
        }

    }

    // metodo remover produtos
    public ResponseEntity<RespostaModelo> remover(long cod_equipamento) {

        equipamentoRepositorio.deleteById(cod_equipamento);

        respostaModelo.setMensagem("Equipamento removido!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);

    }

}
