package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatotiAEntity;


public interface FormatoTIARepository extends CrudRepository<FormatotiAEntity, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}