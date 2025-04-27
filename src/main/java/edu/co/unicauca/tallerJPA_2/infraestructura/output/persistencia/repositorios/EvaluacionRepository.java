package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EvaluacionEntity;


public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    
}