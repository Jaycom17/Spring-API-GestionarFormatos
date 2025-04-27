package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoppAEntity;


public interface FormatoPPARepository extends CrudRepository<FormatoppAEntity, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
