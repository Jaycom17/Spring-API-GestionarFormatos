package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "historicos")
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idHistorico")
    private Integer idHistorico;
    @Column(name = "activo", columnDefinition = "tinyint")
    private int activo;
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "fechaFin")
    private Date fechaFin;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idfkDocente")
    private DocenteEntity objDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfkRol")
    private RolEntity objRol;
}