/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión de los requerimientos del
 * personal de la OCMA. Constiene las funcionalidades desde
 * que el solicitante realiza una solicitud de un requerimiento 
 * hasta que es atendido por el personal encargado.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.auditoria.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.primefaces.component.api.UIData;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasTablaModel;
import pe.gob.ocma.auditoria.enums.TipoBusqueda;
import pe.gob.ocma.auditoria.model.AuditoriaDataModel;
import pe.gob.ocma.auditoria.model.AuditoriaFecUsuDataModel;
import pe.gob.ocma.auditoria.service.AuditoriaService;
import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.generico.Gettabla;
import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.generico.service.TablaService;
import pe.gob.ocma.seguridad.model.UsuarioDataModel;
import pe.gob.ocma.seguridad.service.UsuarioService;

/**
 * Clase de control para manejar auditoría en general.
 * @author César Altamirano Menor
 * 10/10/2013 14:25:30
 */
@ManagedBean
@ViewScoped
public class AuditoriaGeneralMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	TipoBusqueda tipoBusqueda;
	private Date fechaInicio;
	private Date fechaFin;
	private LazyDataModel<AuditoriaFechasModel> lazyDataAuditoria;
	
	private short codTabla;
	private String nomTabla;
	private String desTabla;
	private List<Gettabla> lisTablas;
	
	private String codUsuario;
	private String desUsuario;
	private LazyDataModel<Setusuario> lazyDataUsuarios;
	
	private List<String> columnas = new ArrayList<String>();
	private List<AuditoriaFechasTablaModel> lazyDataAuditoriaTabla;
	
	private int first;
	private int pageSize = 20;
	private long rowCount;
	private int page;
	private int pageCount;
	
	private LazyDataModel<AuditoriaFechasModel> lazyDataAuditoriaUsuario;
	
	@ManagedProperty(value = "#{tablaService}")
	private TablaService tablaService;
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	@ManagedProperty(value = "#{auditoriaService}")
	private AuditoriaService auService;
	
	public AuditoriaGeneralMBean() {
		Calendar calFin = Calendar.getInstance();
		fechaFin = calFin.getTime();
		int year = calFin.get(Calendar.YEAR);
		int month = calFin.get(Calendar.MONTH);
		month -= 1;
		int date = calFin.get(Calendar.DAY_OF_MONTH);
		Calendar calIni = Calendar.getInstance();
		calIni.set(year, month, date);
		this.fechaInicio = calIni.getTime();
	}
	
	@PostConstruct
	private void inicializar() {
		this.lisTablas = tablaService.listarTablas();
		this.lazyDataUsuarios = new UsuarioDataModel(usuarioService, null);
	}
	
	public void buscarEntreFechas(){
		if(codTabla == 0 && (codUsuario == null || codUsuario.isEmpty())) {
			this.tipoBusqueda = TipoBusqueda.FECHAS;
			lazyDataAuditoria = new AuditoriaDataModel(auService, fechaInicio, fechaFin);
		} else if(codTabla != 0 && (codUsuario == null || codUsuario.isEmpty())){
			this.tipoBusqueda = TipoBusqueda.FECHAS_TABLA;
			columnas = new ArrayList<String>();
			columnas.add(super.getMessage("msgFecha"));
			columnas.add(super.getMessage("msgUsuario"));
			columnas.add(super.getMessage("msgOperacion"));
			columnas.add(super.getMessage("msgPrimaryKey"));
			List<String> lista = auService.buscarCamposCabecera(codTabla);
			if(lista != null) {
				for(String c : lista) {
					columnas.add(c);
				}
			}
			this.first = 0;
			this.page = 0;
			this.pageCount = 0;
			WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
			lazyDataAuditoriaTabla = wd.getData();
			this.rowCount = wd.getRowCount();
			if(this.rowCount > 0) {
				this.page = 1;
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}else if(codTabla == 0 && codUsuario != null && !codUsuario.isEmpty()) {
			this.tipoBusqueda = TipoBusqueda.FECHAS_USUARIO;
			lazyDataAuditoriaUsuario = new AuditoriaFecUsuDataModel(auService, codUsuario, fechaInicio, fechaFin);
		} else {
			this.tipoBusqueda = TipoBusqueda.FECHAS_TABLA_USUARIO;
			columnas = new ArrayList<String>();
			columnas.add(super.getMessage("msgFecha"));
			columnas.add(super.getMessage("msgUsuario"));
			columnas.add(super.getMessage("msgOperacion"));
			columnas.add(super.getMessage("msgPrimaryKey"));
			List<String> lista = auService.buscarCamposCabecera(codTabla);
			if(lista != null) {
				for(String c : lista) {
					columnas.add(c);
				}
			}
			this.first = 0;
			this.page = 0;
			this.pageCount = 0;
			WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
			lazyDataAuditoriaTabla = wd.getData();
			this.rowCount = wd.getRowCount();
			if(this.rowCount > 0) {
				this.page = 1;
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}
	}
	
	public void seleccionarTabla(ActionEvent ev) {
		UIComponent ui = ev.getComponent().getParent().getParent();
		if(ui != null){
			UIData dt =(UIData) ui;
			Gettabla tb = (Gettabla) dt.getRowData();
			this.codTabla = tb.getCodTabla();
			this.nomTabla = tb.getNomTabla();
			this.desTabla = tb.getDescripcion();
		}
	}
	
	public void seleccionarUsuario(ActionEvent ev) {
		UIComponent ui = ev.getComponent().getParent().getParent();
		if(ui != null){
			UIData dt =(UIData) ui;
			Setusuario usu = (Setusuario) dt.getRowData();
			this.codUsuario = usu.getCodUsuario();
			StringBuilder sbUsu = new StringBuilder();
			sbUsu.append(usu.getPetpernatu().getApellido());
			sbUsu.append(" ");
			sbUsu.append(usu.getPetpernatu().getNombre());
			this.desUsuario = sbUsu.toString();
		}
	}
	
	public void paginaInicial() {
		if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA) {
			if(this.pageCount > 1 && this.page != 1) {
				this.page = 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		} else if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA_USUARIO) {
			if(this.pageCount > 1 && this.page != 1) {
				this.page = 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}
	}
	
	public void paginaSiguiente() {
		if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA) {
			if(this.page < this.pageCount) {
				this.page += 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		} else if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA_USUARIO) {
			if(this.page < this.pageCount) {
				this.page += 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}
	}
	
	public void paginaAnterior() {
		if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA) {
			if(this.page > 1) {
				this.page -= 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		} else if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA_USUARIO) {
			if(this.page > 1) {
				this.page -= 1;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}
	}
	
	public void paginaFinal() {
		if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA) {
			if(this.pageCount > 1 && this.page != this.pageCount) {
				this.page = this.pageCount;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		} else if(this.tipoBusqueda == TipoBusqueda.FECHAS_TABLA_USUARIO) {
			if(this.pageCount > 1 && this.page != this.pageCount) {
				this.page = this.pageCount;
				this.first = (this.page-1) * this.pageSize;
				WrappedData<AuditoriaFechasTablaModel> wd = auService.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, columnas.size(), first, pageSize); 
				lazyDataAuditoriaTabla = wd.getData();
				this.rowCount = wd.getRowCount();
				BigDecimal cant = new BigDecimal(this.rowCount);
				cant = cant.divide(new BigDecimal(this.pageSize), 0, RoundingMode.UP);
				this.pageCount = cant.intValue();
			}
		}
	}
	
	public void nuevaBusqueda() {
		this.codTabla = 0;
		this.nomTabla = "";
		this.codUsuario = "";
		this.desUsuario = "";
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LazyDataModel<AuditoriaFechasModel> getLazyDataAuditoria() {
		return lazyDataAuditoria;
	}

	public short getCodTabla() {
		return codTabla;
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public String getDesTabla() {
		return desTabla;
	}

	public List<Gettabla> getLisTablas() {
		return lisTablas;
	}

	public TipoBusqueda getTipoBusqueda() {
		return tipoBusqueda;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public String getDesUsuario() {
		return desUsuario;
	}

	public LazyDataModel<Setusuario> getLazyDataUsuarios() {
		return lazyDataUsuarios;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public List<AuditoriaFechasTablaModel> getLazyDataAuditoriaTabla() {
		return lazyDataAuditoriaTabla;
	}

	public int getFirst() {
		return first;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public int getPage() {
		return page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public LazyDataModel<AuditoriaFechasModel> getLazyDataAuditoriaUsuario() {
		return lazyDataAuditoriaUsuario;
	}

	public void setTablaService(TablaService tablaService) {
		this.tablaService = tablaService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setAuService(AuditoriaService auService) {
		this.auService = auService;
	}
}
