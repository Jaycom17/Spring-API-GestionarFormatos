package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoAEntity;


public interface FormatoARepository extends JpaRepository<FormatoAEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    
}