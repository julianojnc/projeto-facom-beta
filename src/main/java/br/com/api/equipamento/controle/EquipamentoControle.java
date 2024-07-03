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

import br.com.api.equipamento.modelo.EquipamentoModelo;
import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.servico.EquipamentoServico;

@RestController
@CrossOrigin(origins = "*")
public class EquipamentoControle {

    @Autowired
    private EquipamentoServico equipamentoServico;

    @DeleteMapping("/remover/{cod_equipamento}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long cod_equipamento){
        return equipamentoServico.remover(cod_equipamento);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody EquipamentoModelo equipamentoModelo){
        return equipamentoServico.cadastrarAlterar(equipamentoModelo, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody EquipamentoModelo equipamentoModelo){
        return equipamentoServico.cadastrarAlterar(equipamentoModelo, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<EquipamentoModelo> listar(){
        return equipamentoServico.listar();
    }
    
    @GetMapping("/equipamento")
    public String rota(){
        return "Api de Equipamentos funcionando";
    }

}
