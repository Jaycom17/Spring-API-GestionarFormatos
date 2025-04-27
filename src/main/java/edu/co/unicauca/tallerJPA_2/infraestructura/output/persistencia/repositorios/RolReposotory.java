package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.RolEntity;


public interface RolReposotory extends JpaRepository<RolEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    // You can add custom query methods if needed
    
}

