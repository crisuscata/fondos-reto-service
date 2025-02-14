package com.utec.group6.reto.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Diagnostico")
    private Integer idDiagnostico;

    @Column(name = "ID_Paciente")
    private Integer idPaciente;

    @Column(name = "Fecha_Diagnostico")
    private String fechaDiagnostico;

    @Column(name = "Tipo_Enfermedad")
    private String tipoEnfermedad;

    @Column(name = "Tipo_Cancer")
    private String tipoCancer;

    @Column(name = "Estadio_Cancer")
    private String estadioCancer;

    @Column(name = "Grado_Agresividad")
    private String gradoAgresividad;

    @Column(name = "Metastasis")
    private String metastasis;

    @Column(name = "Histología")
    private String histologia;

    @Column(name = "Marcadores_Tumorales")
    private String marcadoresTumorales;

    @Column(name = "ID_Doctor")
    private Integer idDoctor;

    @Column(name = "ID_Tratamiento")
    private Integer idTratamiento;

    @Column(name = "Seguimiento_Placebo")
    private String seguimientoPlacebo;

    /* @Column(name = "UsuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "FechaCreacion")
    private String fechaCreacion;

    @Column(name = "UsuarioModificac")
    private String usuarioModificacion;

    @Column(name = "FechaModifica")
    private String fechaModifica;*/

	public Integer getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Integer idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getFechaDiagnostico() {
		return fechaDiagnostico;
	}

	public void setFechaDiagnostico(String fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}

	public String getTipoEnfermedad() {
		return tipoEnfermedad;
	}

	public void setTipoEnfermedad(String tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}

	public String getTipoCancer() {
		return tipoCancer;
	}

	public void setTipoCancer(String tipoCancer) {
		this.tipoCancer = tipoCancer;
	}

	public String getEstadioCancer() {
		return estadioCancer;
	}

	public void setEstadioCancer(String estadioCancer) {
		this.estadioCancer = estadioCancer;
	}

	public String getGradoAgresividad() {
		return gradoAgresividad;
	}

	public void setGradoAgresividad(String gradoAgresividad) {
		this.gradoAgresividad = gradoAgresividad;
	}

	public String getMetastasis() {
		return metastasis;
	}

	public void setMetastasis(String metastasis) {
		this.metastasis = metastasis;
	}

	public String getHistologia() {
		return histologia;
	}

	public void setHistologia(String histologia) {
		this.histologia = histologia;
	}

	public String getMarcadoresTumorales() {
		return marcadoresTumorales;
	}

	public void setMarcadoresTumorales(String marcadoresTumorales) {
		this.marcadoresTumorales = marcadoresTumorales;
	}

	public Integer getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Integer getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(Integer idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getSeguimientoPlacebo() {
		return seguimientoPlacebo;
	}

	public void setSeguimientoPlacebo(String seguimientoPlacebo) {
		this.seguimientoPlacebo = seguimientoPlacebo;
	}

	/*public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(String fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
    */
    
}

