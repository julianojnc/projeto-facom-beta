package br.com.api.equipamento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.equipamento.modelo.RegManutencaoModelo;

@Repository
public interface RegManutencaoRepositorio extends JpaRepository<RegManutencaoModelo, Long> {
    
}
