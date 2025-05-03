package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarHistoricoGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.HistoricoRepository;

@Service
public class GestionarHistoricosGatewayImplAdapter implements GestionarHistoricoGatewayIntPort{

    private final HistoricoRepository objHistoricoRepository;
    private final ModelMapper historicoModelMapper;

    public GestionarHistoricosGatewayImplAdapter(HistoricoRepository objHistoricoRepository, @Qualifier("HistoricoMapperPersistenciaDominio") ModelMapper historicoModelMapper) {
        this.objHistoricoRepository = objHistoricoRepository;
        this.historicoModelMapper = historicoModelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Historico> listarMiembrosComite() {

        List<Historico> listaMiembrosComite = this.historicoModelMapper.map(objHistoricoRepository.findAll(), new TypeToken<List<Historico>>() {}.getType());
        
        return listaMiembrosComite;
    }
    
    
}
