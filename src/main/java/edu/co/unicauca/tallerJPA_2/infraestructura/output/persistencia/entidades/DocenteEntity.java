package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "docentes")
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocente")
    private Integer idDocente;
    @Column(name = "nombres_docente", length = 100)
    private String nombresDocente;
    @Column(name = "apellidos_docente", length = 100)
    private String apellidosDocente;
    @Column(name = "nombre_grupo", length = 50)
    private String nombreGrupo;
    @Column(name = "correo", length = 50)
    private String correo;

    @ManyToMany(mappedBy = "docentes")
    private List<ObservacionEntity> observaciones;

    @OneToMany(mappedBy = "objDocente", fetch = FetchType.EAGER)
    private List<FormatoAEntity> formatos;

    public DocenteEntity() {
        observaciones = new ArrayList<ObservacionEntity>();
        formatos = new ArrayList<FormatoAEntity>();
    }
    
}
