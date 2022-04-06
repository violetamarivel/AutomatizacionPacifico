package com.pacifico.test.services.integration.pacifico;

public class SolicitudMetodoPagosItem{
	private int idSolicitudMetodoPago;
	private int codigoEntidadBancaria;
	private String fechaModificacion;
	private int montoOperacion;
	private String numeroOperacion;
	private int idSolicitudMultiple;
	private String fechaCreacion;
	private int monedaOperacion;
	private String usuarioModificacion;
	private ArchivoAdjunto archivoAdjunto;
	private String usuarioCreacion;

	public void setIdSolicitudMetodoPago(int idSolicitudMetodoPago){
		this.idSolicitudMetodoPago = idSolicitudMetodoPago;
	}

	public int getIdSolicitudMetodoPago(){
		return idSolicitudMetodoPago;
	}

	public void setCodigoEntidadBancaria(int codigoEntidadBancaria){
		this.codigoEntidadBancaria = codigoEntidadBancaria;
	}

	public int getCodigoEntidadBancaria(){
		return codigoEntidadBancaria;
	}

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
	}

	public void setMontoOperacion(int montoOperacion){
		this.montoOperacion = montoOperacion;
	}

	public int getMontoOperacion(){
		return montoOperacion;
	}

	public void setNumeroOperacion(String numeroOperacion){
		this.numeroOperacion = numeroOperacion;
	}

	public String getNumeroOperacion(){
		return numeroOperacion;
	}

	public void setIdSolicitudMultiple(int idSolicitudMultiple){
		this.idSolicitudMultiple = idSolicitudMultiple;
	}

	public int getIdSolicitudMultiple(){
		return idSolicitudMultiple;
	}

	public void setFechaCreacion(String fechaCreacion){
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaCreacion(){
		return fechaCreacion;
	}

	public void setMonedaOperacion(int monedaOperacion){
		this.monedaOperacion = monedaOperacion;
	}

	public int getMonedaOperacion(){
		return monedaOperacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion){
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioModificacion(){
		return usuarioModificacion;
	}

	public void setArchivoAdjunto(ArchivoAdjunto archivoAdjunto){
		this.archivoAdjunto = archivoAdjunto;
	}

	public ArchivoAdjunto getArchivoAdjunto(){
		return archivoAdjunto;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}
}
