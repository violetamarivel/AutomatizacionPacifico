package com.pacifico.test.services.integration.pacifico;

public class DetallePreguntaRespuestasItem{
	private String fechaModificacion;
	private String fechaCreacion;
	private String usuarioModificacion;
	private int idDetallePreguntaRespuesta;
	private String respuesta;
	private int codigoTipoDatoRespuesta;
	private String detalleRespuesta;
	private int idBancoAlternativaRenta;
	private String usuarioCreacion;

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
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

	public void setIdDetallePreguntaRespuesta(int idDetallePreguntaRespuesta){
		this.idDetallePreguntaRespuesta = idDetallePreguntaRespuesta;
	}

	public int getIdDetallePreguntaRespuesta(){
		return idDetallePreguntaRespuesta;
	}

	public void setRespuesta(String respuesta){
		this.respuesta = respuesta;
	}

	public String getRespuesta(){
		return respuesta;
	}

	public void setCodigoTipoDatoRespuesta(int codigoTipoDatoRespuesta){
		this.codigoTipoDatoRespuesta = codigoTipoDatoRespuesta;
	}

	public int getCodigoTipoDatoRespuesta(){
		return codigoTipoDatoRespuesta;
	}

	public void setDetalleRespuesta(String detalleRespuesta){
		this.detalleRespuesta = detalleRespuesta;
	}

	public String getDetalleRespuesta(){
		return detalleRespuesta;
	}

	public void setIdBancoAlternativaRenta(int idBancoAlternativaRenta){
		this.idBancoAlternativaRenta = idBancoAlternativaRenta;
	}

	public int getIdBancoAlternativaRenta(){
		return idBancoAlternativaRenta;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}
}
