package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoAEntity;

public interface FormatoARepository extends JpaRepository<FormatoAEntity, Integer> {
    // No additional methods are needed for basic CRUD operations

    @Query("SELECT fa, e, d FROM FormatoAEntity fa " +
       "JOIN fa.objEstado e " +
       "JOIN fa.objDocente d " +
       "WHERE fa.titulo = :titulo " +
       "AND fa.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<Object[]> findFormatoAWithEstadoAndDocentes(
        @Param("titulo") String titulo,
        @Param("fechaInicio") LocalDate fechaInicio,
        @Param("fechaFin") LocalDate fechaFin
    );

    @Query(value = "SELECT COUNT(*) > 0 FROM FormatosA WHERE LOWER(titulo) = LOWER(:titulo)", nativeQuery = true)
    Integer existsByTitulo(@Param("titulo") String titulo);

    List<FormatoAEntity> findByObjDocenteIdDocente(Integer idDocente);
}