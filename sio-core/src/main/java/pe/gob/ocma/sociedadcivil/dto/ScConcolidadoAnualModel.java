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
package pe.gob.ocma.sociedadcivil.dto;

import java.io.Serializable;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 18/03/2014 09:13:33
 */
public class ScConcolidadoAnualModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Mes;
	private Short Numero;
	private int Observacion;
	private int Apersonamiento;
	private int ApersObservacion;
	private int ApersOdecma;
	private int Apelacion;
	private int Consentido;
	private int QuejaDerecho;
	private int DocumentoMeroTra;
	private int Nulidad;
	private int ApersApelacion;
	private int TotalMeses;
	
	
	public ScConcolidadoAnualModel() {
		super();
	}
	
	
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		Mes = mes;
	}
	public Short getNumero() {
		return Numero;
	}
	public void setNumero(Short numero) {
		Numero = numero;
	}
	public int getObservacion() {
		return Observacion;
	}
	public void setObservacion(int observacion) {
		Observacion = observacion;
	}
	public int getApersonamiento() {
		return Apersonamiento;
	}
	public void setApersonamiento(int apersonamiento) {
		Apersonamiento = apersonamiento;
	}
	public int getApersObservacion() {
		return ApersObservacion;
	}
	public void setApersObservacion(int apersObservacion) {
		ApersObservacion = apersObservacion;
	}
	public int getApersOdecma() {
		return ApersOdecma;
	}
	public void setApersOdecma(int apersOdecma) {
		ApersOdecma = apersOdecma;
	}
	public int getApelacion() {
		return Apelacion;
	}
	public void setApelacion(int apelacion) {
		Apelacion = apelacion;
	}
	public int getConsentido() {
		return Consentido;
	}
	public void setConsentido(int consentido) {
		Consentido = consentido;
	}
	public int getQuejaDerecho() {
		return QuejaDerecho;
	}
	public void setQuejaDerecho(int quejaDerecho) {
		QuejaDerecho = quejaDerecho;
	}
	public int getDocumentoMeroTra() {
		return DocumentoMeroTra;
	}
	public void setDocumentoMeroTra(int documentoMeroTra) {
		DocumentoMeroTra = documentoMeroTra;
	}
	public int getNulidad() {
		return Nulidad;
	}
	public void setNulidad(int nulidad) {
		Nulidad = nulidad;
	}
	public int getApersApelacion() {
		return ApersApelacion;
	}
	public void setApersApelacion(int apersApelacion) {
		ApersApelacion = apersApelacion;
	}
	public int getTotalMeses() {
		return TotalMeses;
	}
	public void setTotalMeses(int totalMeses) {
		TotalMeses = totalMeses;
	}
	
	
	

}
