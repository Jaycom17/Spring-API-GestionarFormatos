package edu.co.unicauca.tallerJPA_2.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarDocenteGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarFormatoAGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarHistoricoGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarObservacionGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.casosDeUso.GestionarDocenteCUAdapter;
import edu.co.unicauca.tallerJPA_2.dominio.casosDeUso.GestionarFormatosACUAdapter;
import edu.co.unicauca.tallerJPA_2.dominio.casosDeUso.GestionarHistoricoCUAdapter;
import edu.co.unicauca.tallerJPA_2.dominio.casosDeUso.GestionarObservacionCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort obFormateadorResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway, obFormateadorResultados);
        
        return objGestionarDocenteCU;
    }

    @Bean
    public GestionarFormatosACUAdapter crearGestionarFormatoACUInt(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort obFormateadorResultados){
        GestionarFormatosACUAdapter objGestionarFormatoACU = new GestionarFormatosACUAdapter(objGestionarFormatoAGateway, objGestionarDocenteGateway, obFormateadorResultados);

        return objGestionarFormatoACU;
    }

    @Bean
    public GestionarObservacionCUAdapter crearGestionarObservacionCUInt(GestionarObservacionGatewayIntPort objGestionarObservacionGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, FormateadorResultadosIntPort obFormateadorResultados){
        GestionarObservacionCUAdapter objGestionarObservacionCU = new GestionarObservacionCUAdapter(objGestionarObservacionGateway, objGestionarDocenteGateway, objGestionarFormatoAGateway, obFormateadorResultados);

        return objGestionarObservacionCU;
    }

    @Bean
    public GestionarHistoricoCUAdapter crearGestionarHistoricoCUInt(GestionarHistoricoGatewayIntPort objGestionarHistoricosGateway, FormateadorResultadosIntPort obFormateadorResultados){
        GestionarHistoricoCUAdapter objGestionarHistoricoCU = new GestionarHistoricoCUAdapter(objGestionarHistoricosGateway,obFormateadorResultados);

        return objGestionarHistoricoCU;
    }
}
