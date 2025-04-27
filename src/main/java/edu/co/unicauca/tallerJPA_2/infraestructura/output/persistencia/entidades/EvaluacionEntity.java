package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "evaluaciones")
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idEvaluacion")
    private Integer idEvaluacion;
    @Column(name = "concepto", length = 255)
    private String concepto;
    @Column(name = "fecha_registro_concepto")
    private Date fechaRegistroConcepto;
    @Column(name = "nombre_coordinador", length = 100)
    private String nombreCoordinador;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "idfkFormatoa")
    private FormatoAEntity objFormatoA;

    @OneToMany(mappedBy = "objEvaluacion", fetch = FetchType.LAZY)
    private List<ObservacionEntity> observaciones;

    public EvaluacionEntity() {
        observaciones = new ArrayList<ObservacionEntity>();
    }
}

