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

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 22/09/2014 15:45:12
 */
public class DjInfoFamiliarModel implements Serializable{
	
	private static final long serialVersionUID = 1L;


	
	private int cod_intfamilia;
	private int cod_personal;
	private int c_pariente;
	private String des_pariente;
	private String des_ape_paterno;
	private String des_ape_materno;
	private String des_nombre;
	private String fecha;
	private String des_sexo;
	private int fla_sexo;
	private int fla_vivo;
	private String des_vivo;
	private int num_hijos;
	private String fec_modificacion;
	private String nombre_completo;
	
	
	
	public int getCod_intfamilia() {
		return cod_intfamilia;
	}
	public void setCod_intfamilia(int cod_intfamilia) {
		this.cod_intfamilia = cod_intfamilia;
	}
	public int getCod_personal() {
		return cod_personal;
	}
	public void setCod_personal(int cod_personal) {
		this.cod_personal = cod_personal;
	}
	public int getC_pariente() {
		return c_pariente;
	}
	public void setC_pariente(int c_pariente) {
		this.c_pariente = c_pariente;
	}
	public String getDes_pariente() {
		return des_pariente;
	}
	public void setDes_pariente(String des_pariente) {
		this.des_pariente = des_pariente;
	}
	public String getDes_ape_paterno() {
		return des_ape_paterno;
	}
	public void setDes_ape_paterno(String des_ape_paterno) {
		this.des_ape_paterno = des_ape_paterno;
	}
	public String getDes_ape_materno() {
		return des_ape_materno;
	}
	public void setDes_ape_materno(String des_ape_materno) {
		this.des_ape_materno = des_ape_materno;
	}
	public String getDes_nombre() {
		return des_nombre;
	}
	public void setDes_nombre(String des_nombre) {
		this.des_nombre = des_nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDes_sexo() {
		return des_sexo;
	}
	public void setDes_sexo(String des_sexo) {
		this.des_sexo = des_sexo;
	}
	public int getFla_sexo() {
		return fla_sexo;
	}
	public void setFla_sexo(int fla_sexo) {
		this.fla_sexo = fla_sexo;
	}
	public int getFla_vivo() {
		return fla_vivo;
	}
	public void setFla_vivo(int fla_vivo) {
		this.fla_vivo = fla_vivo;
	}
	public String getDes_vivo() {
		return des_vivo;
	}
	public void setDes_vivo(String des_vivo) {
		this.des_vivo = des_vivo;
	}
	public int getNum_hijos() {
		return num_hijos;
	}
	public void setNum_hijos(int num_hijos) {
		this.num_hijos = num_hijos;
	}

	public String getFec_modificacion() {
		return fec_modificacion;
	}
	public void setFec_modificacion(String fec_modificacion) {
		this.fec_modificacion = fec_modificacion;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
}
