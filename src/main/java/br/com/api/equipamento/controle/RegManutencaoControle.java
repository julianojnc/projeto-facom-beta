package br.com.api.equipamento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.equipamento.modelo.RegManutencaoModelo;
import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.servico.RegManutencaoServico;


@RestController
@CrossOrigin(origins = "*")
public class RegManutencaoControle {

  @Autowired
    private RegManutencaoServico regManutencaoServico;

    @DeleteMapping("/registro/remover/{cod_regmanutencao}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long cod_regmanutencao){
        return regManutencaoServico.remover(cod_regmanutencao);
    }

    @PutMapping("/registro/alterar")
    public ResponseEntity<?> alterar(@RequestBody RegManutencaoModelo regManutencaoModelo){
        return regManutencaoServico.cadastrarAlterar(regManutencaoModelo, "alterar");
    }

    @PostMapping("/registro/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody RegManutencaoModelo regManutencaoModelo){
        return regManutencaoServico.cadastrarAlterar(regManutencaoModelo, "cadastrar");
    }

    @GetMapping("/registro/listar")
    public Iterable<RegManutencaoModelo> listar(){
        return regManutencaoServico.listar();
    }

    @GetMapping("/regmanutencao")
    public String rota(){
        return "Api de registros funcionando!";
    }

}