package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.ObservacionEntity;


public interface ObservacionRepository extends JpaRepository<ObservacionEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    // You can define custom query methods here if needed

    //traer observaciones por idFormatoA
    @Query("SELECT o FROM ObservacionEntity o WHERE o.objEvaluacion.objFormatoA.idFormatoA = :idFormatoA")
    List<ObservacionEntity> findByIdFormatoA(Integer idFormatoA);
    
}