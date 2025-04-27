package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

    List<DocenteEntity> findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCase(String nombreGrupo, String patronBusqueda);
}
