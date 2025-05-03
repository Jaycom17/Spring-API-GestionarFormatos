package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarDocenteGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.DocenteRepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.HistoricoRepository;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepository objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepository objDocenteRepository, HistoricoRepository objHistoricoRepository, @Qualifier("DocenteMapperPersistenciaDominio") ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorCorreo(String correo) {
        return objDocenteRepository.existsByCorreo(correo) != 0;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorId(Integer idDocente) {
        return objDocenteRepository.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarDocentesPorGrupoPatron(String nombreGrupo, String patronBusqueda) {

        List<DocenteEntity> listaDocentesEntity = objDocenteRepository.findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCase(nombreGrupo, patronBusqueda);

        List<Docente> listaObtenida = this.docenteModelMapper.map(listaDocentesEntity, new TypeToken<List<Docente>>() {}.getType());
        
        return listaObtenida;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Docente obtenerDocentePorId(Integer idDocente) {
        DocenteEntity docenteEntity = objDocenteRepository.findById(idDocente).orElse(null);

        Docente objDocente = null;

        if(docenteEntity != null){
            objDocente = docenteModelMapper.map(docenteEntity, Docente.class);
        }

        return objDocente;
    }
}
