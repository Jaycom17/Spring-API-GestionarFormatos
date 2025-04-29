package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarFormatoAGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoppA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatotiA;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EstadoEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoppAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatotiAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.DocenteRepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.FormatoARepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.FormatoPPARepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.FormatoTIARepository;

@Service
public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort {

    private final FormatoARepository objFormatoARepository;
    private final FormatoPPARepository objFormatoPPARepository;
    private final FormatoTIARepository objFormatoTIARepository;
    private final DocenteRepository objDocenteRepository;
    private final ModelMapper formatoAModelMapper;

    public GestionarFormatoAGatewayImplAdapter(FormatoARepository objFormatoARepository, FormatoPPARepository objFormatoPPARepository,
            FormatoTIARepository objFormatoTIARepository, DocenteRepository objDocenteRepository,
            @Qualifier("FormatoAMapperPersistenciaDominio") ModelMapper formatoAModelMapper) {
        this.objFormatoARepository = objFormatoARepository;
        this.objFormatoPPARepository = objFormatoPPARepository;
        this.objFormatoTIARepository = objFormatoTIARepository;
        this.objDocenteRepository = objDocenteRepository;
        this.formatoAModelMapper = formatoAModelMapper;
    }

    @Override
    @Transactional
    public FormatoA crearFormatoA(FormatoA formatoA) {

        FormatoA objFormatoA = null;
        DocenteEntity docenteEntity = null;

        EstadoEntity estadoEntity = new EstadoEntity();
        estadoEntity.setEstadoActual("EN_FORMULACION");
        estadoEntity.setFechaRegistroEstado(new Date());

        if (formatoA.getObjDocente().getIdDocente() != null) {
            docenteEntity = this.objDocenteRepository.getReferenceById(formatoA.getObjDocente().getIdDocente());
        }

        if (formatoA instanceof FormatoppA) {
            FormatoppAEntity formatoPPAEntity = this.formatoAModelMapper.map(formatoA, FormatoppAEntity.class);

            formatoPPAEntity.setObjEstado(estadoEntity);
            estadoEntity.setObjFormatoA(formatoPPAEntity);

            if (docenteEntity != null) {
                formatoPPAEntity.setObjDocente(docenteEntity);
                docenteEntity.getFormatos().add(formatoPPAEntity);
            }

            FormatoppAEntity objFormatoAEntity = this.objFormatoPPARepository.save(formatoPPAEntity);

            objFormatoA = this.formatoAModelMapper.map(objFormatoAEntity, FormatoppA.class);
        } else {
            FormatotiAEntity formatoPPAEntity = this.formatoAModelMapper.map(formatoA, FormatotiAEntity.class);

            formatoPPAEntity.setObjEstado(estadoEntity);
            estadoEntity.setObjFormatoA(formatoPPAEntity);

            if (docenteEntity != null) {
                formatoPPAEntity.setObjDocente(docenteEntity);
                docenteEntity.getFormatos().add(formatoPPAEntity);
            }

            FormatotiAEntity objFormatoAEntity = this.objFormatoTIARepository.save(formatoPPAEntity);

            objFormatoA = this.formatoAModelMapper.map(objFormatoAEntity, FormatotiA.class);
        }

        return objFormatoA;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoPorTitulo(String titulo) {
        return this.objFormatoARepository.existsByTitulo(titulo) != 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> listarPorDocente(Integer idDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorDocente'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> listarPorTituloEntreFechas(String titulo, Date fechaInicio, Date fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorTituloEntreFechas'");
    }

    @Override
    @Transactional(readOnly = true)
    public Integer obtenerUltimaEvaluacion(Integer idFormatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUltimaEvaluacion'");
    }

}
