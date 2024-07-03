package br.com.api.equipamento.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.modelo.SubEquipamentoModelo;
import br.com.api.equipamento.repositorio.SubEquipamentoRepositorio;

@Service
public class SubEquipamentoServico {

    @Autowired
    private SubEquipamentoRepositorio subEquipamentoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<SubEquipamentoModelo> listar() {
        return subEquipamentoRepositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(SubEquipamentoModelo subEquipamentoModelo, String acao) {
        if (subEquipamentoModelo.getNome().equals("")) {
            respostaModelo.setMensagem("Nome do Sub Equipamento deve ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<SubEquipamentoModelo>(subEquipamentoRepositorio.save(subEquipamentoModelo),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<SubEquipamentoModelo>(subEquipamentoRepositorio.save(subEquipamentoModelo),
                        HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<RespostaModelo> remover(long cod_subequipamento) {
        subEquipamentoRepositorio.deleteById(cod_subequipamento);

        respostaModelo.setMensagem("Sub Equipamento removido!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
