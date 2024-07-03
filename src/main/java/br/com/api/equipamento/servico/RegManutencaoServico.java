package br.com.api.equipamento.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.equipamento.modelo.RegManutencaoModelo;
import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.repositorio.RegManutencaoRepositorio;

@Service
public class RegManutencaoServico {
    @Autowired
    private RegManutencaoRepositorio regManutencaoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    // metodo para listar todos os produtos
    public Iterable<RegManutencaoModelo> listar() {
        return regManutencaoRepositorio.findAll();
    }

    // metodo para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(RegManutencaoModelo regManutencaoModelo, String acao) {

        if (regManutencaoModelo.getRegistro().equals("")) {
            respostaModelo.setMensagem("Registro deve ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<RegManutencaoModelo>(regManutencaoRepositorio.save(regManutencaoModelo),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<RegManutencaoModelo>(regManutencaoRepositorio.save(regManutencaoModelo),
                        HttpStatus.OK);
            }
        }

    }

    // metodo remover produtos
    public ResponseEntity<RespostaModelo> remover(long cod_regmanutencao) {

        regManutencaoRepositorio.deleteById(cod_regmanutencao);

        respostaModelo.setMensagem("Registro removido!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);

    }
}
