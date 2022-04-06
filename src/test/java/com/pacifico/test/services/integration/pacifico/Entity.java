package com.pacifico.test.services.integration.pacifico;

import java.util.List;

public class Entity{
	private Contratante contratante;
	private Asegurado asegurado;
	private int codigoEstado;
	private List<PreguntaRespuestasItem> preguntaRespuestas;
	private int idSolicitudCotizacion;
	private String usuarioCreacion;
	private int codigoTipoCuenta;
	private List<SolicitudRentasItem> solicitudRentas;
	private int idProspecto;
	private String usuarioModificacion;
	private String fechaModificacion;
	private String nombreIntermediario;
	private int codigoIntermediario;
	private String numeroCuentaTarjeta;
	private int codigoModalidad;
	private String nombreJefeSuperior;
	private String nombresAsegurado;
	private int seccion;
	private int codigoTipoPrimerPago;
	private List<SolicitudMetodoPagosItem> solicitudMetodoPagos;
	private int idSolicitudMultiple;
	private int codigoEntidad;
	private String fechaCreacion;
	private boolean flagAceptaProteccionDato;
	private String mensaje;
	private boolean flagCesionDerechoBeneficiario;
	private int codigoAgencia;

	public void setContratante(Contratante contratante){
		this.contratante = contratante;
	}

	public Contratante getContratante(){
		return contratante;
	}

	public void setAsegurado(Asegurado asegurado){
		this.asegurado = asegurado;
	}

	public Asegurado getAsegurado(){
		return asegurado;
	}

	public void setCodigoEstado(int codigoEstado){
		this.codigoEstado = codigoEstado;
	}

	public int getCodigoEstado(){
		return codigoEstado;
	}

	public void setPreguntaRespuestas(List<PreguntaRespuestasItem> preguntaRespuestas){
		this.preguntaRespuestas = preguntaRespuestas;
	}

	public List<PreguntaRespuestasItem> getPreguntaRespuestas(){
		return preguntaRespuestas;
	}

	public void setIdSolicitudCotizacion(int idSolicitudCotizacion){
		this.idSolicitudCotizacion = idSolicitudCotizacion;
	}

	public int getIdSolicitudCotizacion(){
		return idSolicitudCotizacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}

	public void setCodigoTipoCuenta(int codigoTipoCuenta){
		this.codigoTipoCuenta = codigoTipoCuenta;
	}

	public int getCodigoTipoCuenta(){
		return codigoTipoCuenta;
	}

	public void setSolicitudRentas(List<SolicitudRentasItem> solicitudRentas){
		this.solicitudRentas = solicitudRentas;
	}

	public List<SolicitudRentasItem> getSolicitudRentas(){
		return solicitudRentas;
	}

	public void setIdProspecto(int idProspecto){
		this.idProspecto = idProspecto;
	}

	public int getIdProspecto(){
		return idProspecto;
	}

	public void setUsuarioModificacion(String usuarioModificacion){
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioModificacion(){
		return usuarioModificacion;
	}

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
	}

	public void setNombreIntermediario(String nombreIntermediario){
		this.nombreIntermediario = nombreIntermediario;
	}

	public String getNombreIntermediario(){
		return nombreIntermediario;
	}

	public void setCodigoIntermediario(int codigoIntermediario){
		this.codigoIntermediario = codigoIntermediario;
	}

	public int getCodigoIntermediario(){
		return codigoIntermediario;
	}

	public void setNumeroCuentaTarjeta(String numeroCuentaTarjeta){
		this.numeroCuentaTarjeta = numeroCuentaTarjeta;
	}

	public String getNumeroCuentaTarjeta(){
		return numeroCuentaTarjeta;
	}

	public void setCodigoModalidad(int codigoModalidad){
		this.codigoModalidad = codigoModalidad;
	}

	public int getCodigoModalidad(){
		return codigoModalidad;
	}

	public void setNombreJefeSuperior(String nombreJefeSuperior){
		this.nombreJefeSuperior = nombreJefeSuperior;
	}

	public String getNombreJefeSuperior(){
		return nombreJefeSuperior;
	}

	public void setNombresAsegurado(String nombresAsegurado){
		this.nombresAsegurado = nombresAsegurado;
	}

	public String getNombresAsegurado(){
		return nombresAsegurado;
	}

	public void setSeccion(int seccion){
		this.seccion = seccion;
	}

	public int getSeccion(){
		return seccion;
	}

	public void setCodigoTipoPrimerPago(int codigoTipoPrimerPago){
		this.codigoTipoPrimerPago = codigoTipoPrimerPago;
	}

	public int getCodigoTipoPrimerPago(){
		return codigoTipoPrimerPago;
	}

	public void setSolicitudMetodoPagos(List<SolicitudMetodoPagosItem> solicitudMetodoPagos){
		this.solicitudMetodoPagos = solicitudMetodoPagos;
	}

	public List<SolicitudMetodoPagosItem> getSolicitudMetodoPagos(){
		return solicitudMetodoPagos;
	}

	public void setIdSolicitudMultiple(int idSolicitudMultiple){
		this.idSolicitudMultiple = idSolicitudMultiple;
	}

	public int getIdSolicitudMultiple(){
		return idSolicitudMultiple;
	}

	public void setCodigoEntidad(int codigoEntidad){
		this.codigoEntidad = codigoEntidad;
	}

	public int getCodigoEntidad(){
		return codigoEntidad;
	}

	public void setFechaCreacion(String fechaCreacion){
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaCreacion(){
		return fechaCreacion;
	}

	public void setFlagAceptaProteccionDato(boolean flagAceptaProteccionDato){
		this.flagAceptaProteccionDato = flagAceptaProteccionDato;
	}

	public boolean isFlagAceptaProteccionDato(){
		return flagAceptaProteccionDato;
	}

	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje(){
		return mensaje;
	}

	public void setFlagCesionDerechoBeneficiario(boolean flagCesionDerechoBeneficiario){
		this.flagCesionDerechoBeneficiario = flagCesionDerechoBeneficiario;
	}

	public boolean isFlagCesionDerechoBeneficiario(){
		return flagCesionDerechoBeneficiario;
	}

	public void setCodigoAgencia(int codigoAgencia){
		this.codigoAgencia = codigoAgencia;
	}

	public int getCodigoAgencia(){
		return codigoAgencia;
	}
}