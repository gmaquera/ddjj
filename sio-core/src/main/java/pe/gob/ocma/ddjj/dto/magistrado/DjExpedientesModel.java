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
 * 16/09/2014 15:42:04
 */
public class DjExpedientesModel implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private String num_expedi;
	private String num_anios;
	private String fec_recepc;
	private String des_abrevi;
	private int cod_tipexp;
	private String des_resinf;
	private String fec_movimi;
	private String des_encarg;
	private String des_estaex;
	private String c_expediente;
	private BigDecimal c_tot_investigacion;
	private BigDecimal c_tot_proceso;
	private BigDecimal c_tot_cautelar;
	private BigDecimal c_tot_visita;
	private BigDecimal c_tot_queja;
	private BigDecimal c_tot_rehabilitado;
	private BigDecimal c_tot_sancion;
	private int cod_intexp;
	private int cod_intper;
	private int cod_distrito_origen;
	private String des_distri;
	private int cod_estado_;
	private String detalle_expediente;
	
	
	
	
	
	public String getNum_expedi() {
		return num_expedi;
	}
	public void setNum_expedi(String num_expedi) {
		this.num_expedi = num_expedi;
	}
	public String getNum_anios() {
		return num_anios;
	}
	public void setNum_anios(String num_anios) {
		this.num_anios = num_anios;
	}
	public String getFec_recepc() {
		return fec_recepc;
	}
	public void setFec_recepc(String fec_recepc) {
		this.fec_recepc = fec_recepc;
	}
	public String getDes_abrevi() {
		return des_abrevi;
	}
	public void setDes_abrevi(String des_abrevi) {
		this.des_abrevi = des_abrevi;
	}
	public int getCod_tipexp() {
		return cod_tipexp;
	}
	public void setCod_tipexp(int cod_tipexp) {
		this.cod_tipexp = cod_tipexp;
	}
	public String getDes_resinf() {
		return des_resinf;
	}
	public void setDes_resinf(String des_resinf) {
		this.des_resinf = des_resinf;
	}
	public String getFec_movimi() {
		return fec_movimi;
	}
	public void setFec_movimi(String fec_movimi) {
		this.fec_movimi = fec_movimi;
	}
	public String getDes_encarg() {
		return des_encarg;
	}
	public void setDes_encarg(String des_encarg) {
		this.des_encarg = des_encarg;
	}
	public String getDes_estaex() {
		return des_estaex;
	}
	public void setDes_estaex(String des_estaex) {
		this.des_estaex = des_estaex;
	}
	public String getC_expediente() {
		return c_expediente;
	}
	public void setC_expediente(String c_expediente) {
		this.c_expediente = c_expediente;
	}

	public int getCod_intexp() {
		return cod_intexp;
	}
	public void setCod_intexp(int cod_intexp) {
		this.cod_intexp = cod_intexp;
	}
	public int getCod_intper() {
		return cod_intper;
	}
	public void setCod_intper(int cod_intper) {
		this.cod_intper = cod_intper;
	}
	public int getCod_distrito_origen() {
		return cod_distrito_origen;
	}
	public void setCod_distrito_origen(int cod_distrito_origen) {
		this.cod_distrito_origen = cod_distrito_origen;
	}
	public String getDes_distri() {
		return des_distri;
	}
	public void setDes_distri(String des_distri) {
		this.des_distri = des_distri;
	}

	public int getCod_estado_() {
		return cod_estado_;
	}
	public void setCod_estado_(int cod_estado_) {
		this.cod_estado_ = cod_estado_;
	}
	public String getDetalle_expediente() {
		return detalle_expediente;
	}
	public void setDetalle_expediente(String detalle_expediente) {
		this.detalle_expediente = detalle_expediente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getC_tot_investigacion() {
		return c_tot_investigacion;
	}
	public void setC_tot_investigacion(BigDecimal c_tot_investigacion) {
		this.c_tot_investigacion = c_tot_investigacion;
	}
	public BigDecimal getC_tot_proceso() {
		return c_tot_proceso;
	}
	public void setC_tot_proceso(BigDecimal c_tot_proceso) {
		this.c_tot_proceso = c_tot_proceso;
	}
	public BigDecimal getC_tot_cautelar() {
		return c_tot_cautelar;
	}
	public void setC_tot_cautelar(BigDecimal c_tot_cautelar) {
		this.c_tot_cautelar = c_tot_cautelar;
	}
	public BigDecimal getC_tot_visita() {
		return c_tot_visita;
	}
	public void setC_tot_visita(BigDecimal c_tot_visita) {
		this.c_tot_visita = c_tot_visita;
	}
	public BigDecimal getC_tot_queja() {
		return c_tot_queja;
	}
	public void setC_tot_queja(BigDecimal c_tot_queja) {
		this.c_tot_queja = c_tot_queja;
	}
	public BigDecimal getC_tot_rehabilitado() {
		return c_tot_rehabilitado;
	}
	public void setC_tot_rehabilitado(BigDecimal c_tot_rehabilitado) {
		this.c_tot_rehabilitado = c_tot_rehabilitado;
	}
	public BigDecimal getC_tot_sancion() {
		return c_tot_sancion;
	}
	public void setC_tot_sancion(BigDecimal c_tot_sancion) {
		this.c_tot_sancion = c_tot_sancion;
	}


	
	
	
	
	
	
	
}
