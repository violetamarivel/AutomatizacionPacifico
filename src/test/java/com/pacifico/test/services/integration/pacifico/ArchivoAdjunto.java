package com.pacifico.test.services.integration.pacifico;

public class ArchivoAdjunto{
	private int idTransaccion;
	private int codigoEsquema;
	private String fechaModificacion;
	private String archivo;
	private int codigoTipoArchivo;
	private int codigoTabla;
	private String fechaCreacion;
	private String usuarioModificacion;
	private int idArchivoAdjunto;
	private String usuarioCreacion;

	public void setIdTransaccion(int idTransaccion){
		this.idTransaccion = idTransaccion;
	}

	public int getIdTransaccion(){
		return idTransaccion;
	}

	public void setCodigoEsquema(int codigoEsquema){
		this.codigoEsquema = codigoEsquema;
	}

	public int getCodigoEsquema(){
		return codigoEsquema;
	}

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
	}

	public void setArchivo(String archivo){
		this.archivo = archivo;
	}

	public String getArchivo(){
		return archivo;
	}

	public void setCodigoTipoArchivo(int codigoTipoArchivo){
		this.codigoTipoArchivo = codigoTipoArchivo;
	}

	public int getCodigoTipoArchivo(){
		return codigoTipoArchivo;
	}

	public void setCodigoTabla(int codigoTabla){
		this.codigoTabla = codigoTabla;
	}

	public int getCodigoTabla(){
		return codigoTabla;
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

	public void setIdArchivoAdjunto(int idArchivoAdjunto){
		this.idArchivoAdjunto = idArchivoAdjunto;
	}

	public int getIdArchivoAdjunto(){
		return idArchivoAdjunto;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}
}
