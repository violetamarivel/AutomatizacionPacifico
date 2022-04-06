package com.pacifico.test.services.integration.pacifico;

import java.util.List;

public class PreguntaRespuestasItem{
	private String fechaModificacion;
	private int idAsegurado;
	private int idContratante;
	private int idPreguntaRespuesta;
	private String fechaCreacion;
	private String usuarioModificacion;
	private boolean flagRespuesta;
	private int idBancoPreguntaRenta;
	private List<DetallePreguntaRespuestasItem> detallePreguntaRespuestas;
	private String usuarioCreacion;

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
	}

	public void setIdAsegurado(int idAsegurado){
		this.idAsegurado = idAsegurado;
	}

	public int getIdAsegurado(){
		return idAsegurado;
	}

	public void setIdContratante(int idContratante){
		this.idContratante = idContratante;
	}

	public int getIdContratante(){
		return idContratante;
	}

	public void setIdPreguntaRespuesta(int idPreguntaRespuesta){
		this.idPreguntaRespuesta = idPreguntaRespuesta;
	}

	public int getIdPreguntaRespuesta(){
		return idPreguntaRespuesta;
	}

	public void setFechaCreacion(String fechaCreacion){
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaCreacion(){
		return fechaCreacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion){
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioModificacion(){
		return usuarioModificacion;
	}

	public void setFlagRespuesta(boolean flagRespuesta){
		this.flagRespuesta = flagRespuesta;
	}

	public boolean isFlagRespuesta(){
		return flagRespuesta;
	}

	public void setIdBancoPreguntaRenta(int idBancoPreguntaRenta){
		this.idBancoPreguntaRenta = idBancoPreguntaRenta;
	}

	public int getIdBancoPreguntaRenta(){
		return idBancoPreguntaRenta;
	}

	public void setDetallePreguntaRespuestas(List<DetallePreguntaRespuestasItem> detallePreguntaRespuestas){
		this.detallePreguntaRespuestas = detallePreguntaRespuestas;
	}

	public List<DetallePreguntaRespuestasItem> getDetallePreguntaRespuestas(){
		return detallePreguntaRespuestas;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}
}