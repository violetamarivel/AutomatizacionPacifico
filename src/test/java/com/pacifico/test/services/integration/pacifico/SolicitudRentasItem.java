package com.pacifico.test.services.integration.pacifico;

import java.util.List;

public class SolicitudRentasItem{
	private int porcentajePeriodoGarantizado;
	private boolean flagSeguroVidaFijo;
	private String otroMontoPrimaProveniente;
	private int idSolicitud;
	private int idSolicitudCotizacion;
	private String nombreProducto;
	private String usuarioCreacion;
	private String codigoPrimaProveniente;
	private String propositoMontoPrima;
	private int porcentajeDevolucionPrimaUnica;
	private String usuarioModificacion;
	private boolean flagGastoSepelioTemporal;
	private int montoGastosSepelio;
	private int sumaAseguradaSvv;
	private int tir;
	private int sumaAseguradaBma;
	private String fechaModificacion;
	private int montoRenta;
	private boolean flagBeneficioMuerteAccidental;
	private boolean flagRescateParcial;
	private String otraEntidad;
	private List<BeneficiariosItem> beneficiarios;
	private int montoPrimaProducto;
	private String numeroCuenta;
	private int porcentajeTasaRendimiento;
	private String tipoAjuste;
	private String monedaPrimaProducto;
	private int porcentajeVidaGarantizado;
	private String numeroSolicitudCotizacion;
	private int porcentajeTasaReservaDevolucionPrima;
	private boolean flagCesionDotePeriodica;
	private int codigoEntidad;
	private String fechaCreacion;
	private boolean flagRescateTotal;
	private String tipoCuenta;
	private boolean flagSeguroVida;
	private int plazoContratacion;

	public void setPorcentajePeriodoGarantizado(int porcentajePeriodoGarantizado){
		this.porcentajePeriodoGarantizado = porcentajePeriodoGarantizado;
	}

	public int getPorcentajePeriodoGarantizado(){
		return porcentajePeriodoGarantizado;
	}

	public void setFlagSeguroVidaFijo(boolean flagSeguroVidaFijo){
		this.flagSeguroVidaFijo = flagSeguroVidaFijo;
	}

	public boolean isFlagSeguroVidaFijo(){
		return flagSeguroVidaFijo;
	}

	public void setOtroMontoPrimaProveniente(String otroMontoPrimaProveniente){
		this.otroMontoPrimaProveniente = otroMontoPrimaProveniente;
	}

	public String getOtroMontoPrimaProveniente(){
		return otroMontoPrimaProveniente;
	}

	public void setIdSolicitud(int idSolicitud){
		this.idSolicitud = idSolicitud;
	}

	public int getIdSolicitud(){
		return idSolicitud;
	}

	public void setIdSolicitudCotizacion(int idSolicitudCotizacion){
		this.idSolicitudCotizacion = idSolicitudCotizacion;
	}

	public int getIdSolicitudCotizacion(){
		return idSolicitudCotizacion;
	}

	public void setNombreProducto(String nombreProducto){
		this.nombreProducto = nombreProducto;
	}

	public String getNombreProducto(){
		return nombreProducto;
	}

	public void setUsuarioCreacion(String usuarioCreacion){
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioCreacion(){
		return usuarioCreacion;
	}

	public void setCodigoPrimaProveniente(String codigoPrimaProveniente){
		this.codigoPrimaProveniente = codigoPrimaProveniente;
	}

	public String getCodigoPrimaProveniente(){
		return codigoPrimaProveniente;
	}

	public void setPropositoMontoPrima(String propositoMontoPrima){
		this.propositoMontoPrima = propositoMontoPrima;
	}

	public String getPropositoMontoPrima(){
		return propositoMontoPrima;
	}

	public void setPorcentajeDevolucionPrimaUnica(int porcentajeDevolucionPrimaUnica){
		this.porcentajeDevolucionPrimaUnica = porcentajeDevolucionPrimaUnica;
	}

	public int getPorcentajeDevolucionPrimaUnica(){
		return porcentajeDevolucionPrimaUnica;
	}

	public void setUsuarioModificacion(String usuarioModificacion){
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioModificacion(){
		return usuarioModificacion;
	}

	public void setFlagGastoSepelioTemporal(boolean flagGastoSepelioTemporal){
		this.flagGastoSepelioTemporal = flagGastoSepelioTemporal;
	}

	public boolean isFlagGastoSepelioTemporal(){
		return flagGastoSepelioTemporal;
	}

	public void setMontoGastosSepelio(int montoGastosSepelio){
		this.montoGastosSepelio = montoGastosSepelio;
	}

	public int getMontoGastosSepelio(){
		return montoGastosSepelio;
	}

	public void setSumaAseguradaSvv(int sumaAseguradaSvv){
		this.sumaAseguradaSvv = sumaAseguradaSvv;
	}

	public int getSumaAseguradaSvv(){
		return sumaAseguradaSvv;
	}

	public void setTir(int tir){
		this.tir = tir;
	}

	public int getTir(){
		return tir;
	}

	public void setSumaAseguradaBma(int sumaAseguradaBma){
		this.sumaAseguradaBma = sumaAseguradaBma;
	}

	public int getSumaAseguradaBma(){
		return sumaAseguradaBma;
	}

	public void setFechaModificacion(String fechaModificacion){
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaModificacion(){
		return fechaModificacion;
	}

	public void setMontoRenta(int montoRenta){
		this.montoRenta = montoRenta;
	}

	public int getMontoRenta(){
		return montoRenta;
	}

	public void setFlagBeneficioMuerteAccidental(boolean flagBeneficioMuerteAccidental){
		this.flagBeneficioMuerteAccidental = flagBeneficioMuerteAccidental;
	}

	public boolean isFlagBeneficioMuerteAccidental(){
		return flagBeneficioMuerteAccidental;
	}

	public void setFlagRescateParcial(boolean flagRescateParcial){
		this.flagRescateParcial = flagRescateParcial;
	}

	public boolean isFlagRescateParcial(){
		return flagRescateParcial;
	}

	public void setOtraEntidad(String otraEntidad){
		this.otraEntidad = otraEntidad;
	}

	public String getOtraEntidad(){
		return otraEntidad;
	}

	public void setBeneficiarios(List<BeneficiariosItem> beneficiarios){
		this.beneficiarios = beneficiarios;
	}

	public List<BeneficiariosItem> getBeneficiarios(){
		return beneficiarios;
	}

	public void setMontoPrimaProducto(int montoPrimaProducto){
		this.montoPrimaProducto = montoPrimaProducto;
	}

	public int getMontoPrimaProducto(){
		return montoPrimaProducto;
	}

	public void setNumeroCuenta(String numeroCuenta){
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta(){
		return numeroCuenta;
	}

	public void setPorcentajeTasaRendimiento(int porcentajeTasaRendimiento){
		this.porcentajeTasaRendimiento = porcentajeTasaRendimiento;
	}

	public int getPorcentajeTasaRendimiento(){
		return porcentajeTasaRendimiento;
	}

	public void setTipoAjuste(String tipoAjuste){
		this.tipoAjuste = tipoAjuste;
	}

	public String getTipoAjuste(){
		return tipoAjuste;
	}

	public void setMonedaPrimaProducto(String monedaPrimaProducto){
		this.monedaPrimaProducto = monedaPrimaProducto;
	}

	public String getMonedaPrimaProducto(){
		return monedaPrimaProducto;
	}

	public void setPorcentajeVidaGarantizado(int porcentajeVidaGarantizado){
		this.porcentajeVidaGarantizado = porcentajeVidaGarantizado;
	}

	public int getPorcentajeVidaGarantizado(){
		return porcentajeVidaGarantizado;
	}

	public void setNumeroSolicitudCotizacion(String numeroSolicitudCotizacion){
		this.numeroSolicitudCotizacion = numeroSolicitudCotizacion;
	}

	public String getNumeroSolicitudCotizacion(){
		return numeroSolicitudCotizacion;
	}

	public void setPorcentajeTasaReservaDevolucionPrima(int porcentajeTasaReservaDevolucionPrima){
		this.porcentajeTasaReservaDevolucionPrima = porcentajeTasaReservaDevolucionPrima;
	}

	public int getPorcentajeTasaReservaDevolucionPrima(){
		return porcentajeTasaReservaDevolucionPrima;
	}

	public void setFlagCesionDotePeriodica(boolean flagCesionDotePeriodica){
		this.flagCesionDotePeriodica = flagCesionDotePeriodica;
	}

	public boolean isFlagCesionDotePeriodica(){
		return flagCesionDotePeriodica;
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

	public void setFlagRescateTotal(boolean flagRescateTotal){
		this.flagRescateTotal = flagRescateTotal;
	}

	public boolean isFlagRescateTotal(){
		return flagRescateTotal;
	}

	public void setTipoCuenta(String tipoCuenta){
		this.tipoCuenta = tipoCuenta;
	}

	public String getTipoCuenta(){
		return tipoCuenta;
	}

	public void setFlagSeguroVida(boolean flagSeguroVida){
		this.flagSeguroVida = flagSeguroVida;
	}

	public boolean isFlagSeguroVida(){
		return flagSeguroVida;
	}

	public void setPlazoContratacion(int plazoContratacion){
		this.plazoContratacion = plazoContratacion;
	}

	public int getPlazoContratacion(){
		return plazoContratacion;
	}
}