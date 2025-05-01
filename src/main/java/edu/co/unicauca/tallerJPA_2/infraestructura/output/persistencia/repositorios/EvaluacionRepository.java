package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EvaluacionEntity;

public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity, Integer> {
    // No additional methods are needed for basic CRUD operations
    @Query(value = "SELECT MAX(e.id) FROM evaluaciones e WHERE e.formatosA.idFormatoA = :formatoAId", nativeQuery = true)
    Integer findLastEvaluacionIdByFormatoAId(@Param("formatoAId") Integer formatoAId);
}