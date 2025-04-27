package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.HistoricoEntity;


public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    // You can add custom query methods if needed
    
}
