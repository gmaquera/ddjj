/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.ddjj.dto.magistrado;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 17/09/2014 15:28:35
 */
public class DjSancionesModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private String num_anios;
	private String des_tipexp;
	private String num_expedi;
	private String expediente;
	private String des_tipsan;
	private String des_sancio;
	private String fec_movimi;
	private String des_estado;
	private int cod_distrito_origen;
	private BigDecimal cantidad_rehabilitados;
	private int apercibimiento;
	private int multa;
	private int destitucion;
	private int suspension;
	private String des_distrito_judicial;
	private String detalle_sancion;
	
	
	public String getNum_anios() {
		return num_anios;
	}
	public void setNum_anios(String num_anios) {
		this.num_anios = num_anios;
	}
	public String getDes_tipexp() {
		return des_tipexp;
	}
	public void setDes_tipexp(String des_tipexp) {
		this.des_tipexp = des_tipexp;
	}
	public String getNum_expedi() {
		return num_expedi;
	}
	public void setNum_expedi(String num_expedi) {
		this.num_expedi = num_expedi;
	}
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getDes_tipsan() {
		return des_tipsan;
	}
	public void setDes_tipsan(String des_tipsan) {
		this.des_tipsan = des_tipsan;
	}
	public String getDes_sancio() {
		return des_sancio;
	}
	public void setDes_sancio(String des_sancio) {
		this.des_sancio = des_sancio;
	}
	public String getFec_movimi() {
		return fec_movimi;
	}
	public void setFec_movimi(String fec_movimi) {
		this.fec_movimi = fec_movimi;
	}
	public String getDes_estado() {
		return des_estado;
	}
	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}
	public int getCod_distrito_origen() {
		return cod_distrito_origen;
	}
	public void setCod_distrito_origen(int cod_distrito_origen) {
		this.cod_distrito_origen = cod_distrito_origen;
	}
	public BigDecimal getCantidad_rehabilitados() {
		return cantidad_rehabilitados;
	}
	public void setCantidad_rehabilitados(BigDecimal cantidad_rehabilitados) {
		this.cantidad_rehabilitados = cantidad_rehabilitados;
	}
	public int getApercibimiento() {
		return apercibimiento;
	}
	public void setApercibimiento(int apercibimiento) {
		this.apercibimiento = apercibimiento;
	}
	public int getMulta() {
		return multa;
	}
	public void setMulta(int multa) {
		this.multa = multa;
	}
	public int getDestitucion() {
		return destitucion;
	}
	public void setDestitucion(int destitucion) {
		this.destitucion = destitucion;
	}
	public int getSuspension() {
		return suspension;
	}
	public void setSuspension(int suspension) {
		this.suspension = suspension;
	}
	public String getDes_distrito_judicial() {
		return des_distrito_judicial;
	}
	public void setDes_distrito_judicial(String des_distrito_judicial) {
		this.des_distrito_judicial = des_distrito_judicial;
	}
	public String getDetalle_sancion() {
		return detalle_sancion;
	}
	public void setDetalle_sancion(String detalle_sancion) {
		this.detalle_sancion = detalle_sancion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
