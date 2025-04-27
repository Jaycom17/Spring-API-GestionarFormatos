package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EstadoEntity;


public interface EstadoRepository extends CrudRepository<EstadoEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    
}