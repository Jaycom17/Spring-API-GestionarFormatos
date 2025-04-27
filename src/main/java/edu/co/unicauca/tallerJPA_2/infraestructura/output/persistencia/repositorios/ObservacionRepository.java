package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.ObservacionEntity;


public interface ObservacionRepository extends JpaRepository<ObservacionEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    // You can define custom query methods here if needed
    
}