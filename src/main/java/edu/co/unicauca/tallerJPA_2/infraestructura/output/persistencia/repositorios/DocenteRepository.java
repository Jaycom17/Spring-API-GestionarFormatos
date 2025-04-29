package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

    List<DocenteEntity> findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCase(String nombreGrupo, String patronBusqueda);

    @Query(value = "SELECT COUNT(*) > 0 FROM docentes WHERE correo = :correo", nativeQuery = true)
    Integer existsByCorreo(@Param("correo") String correo);
}
