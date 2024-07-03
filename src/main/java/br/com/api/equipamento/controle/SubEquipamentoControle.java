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

import br.com.api.equipamento.modelo.RespostaModelo;
import br.com.api.equipamento.modelo.SubEquipamentoModelo;
import br.com.api.equipamento.servico.SubEquipamentoServico;

@RestController
@CrossOrigin(origins = "*")
public class SubEquipamentoControle {
    
    @Autowired
    private SubEquipamentoServico subEquipamentoServico;

    @DeleteMapping("/subequipamento/remover/{cod_subequipamento}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long cod_subequipamento){
        return subEquipamentoServico.remover(cod_subequipamento);
    }

    @PutMapping("/subequipamento/alterar")
    public ResponseEntity<?> alterar(@RequestBody SubEquipamentoModelo subEquipamentoModelo){
        return subEquipamentoServico.cadastrarAlterar(subEquipamentoModelo, "alterar");
    }

    @PostMapping("/subequipamento/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody SubEquipamentoModelo subEquipamentoModelo){
        return subEquipamentoServico.cadastrarAlterar(subEquipamentoModelo, "cadastrar");
    }

    @GetMapping("/subequipamento/listar")
    public Iterable<SubEquipamentoModelo> listar(){
        return subEquipamentoServico.listar();
    }

    @GetMapping("/subequipamento")
    public String rota(){
        return "Api de sub equipamentos funcionando!";
    }
}   
