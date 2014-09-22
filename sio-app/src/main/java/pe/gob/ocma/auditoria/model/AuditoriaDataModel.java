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
package pe.gob.ocma.auditoria.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.service.AuditoriaService;
import pe.gob.ocma.common.wrapper.WrappedData;

/**
 * Clase modelo para la paginación de la auditoría general.
 * @author César Altamirano Menor
 * 10/10/2013 16:22:54
 */
public class AuditoriaDataModel extends LazyDataModel<AuditoriaFechasModel> {

	private static final long serialVersionUID = 1L;

	private List<AuditoriaFechasModel> datasource;
	private int pageSize;
	private int rowIndex;
	private int rowCount;
	private AuditoriaService auService;
	private Date fechaInicio;
    private Date fechaFin;
	/**
	 * @param auService El servició de auditoria para acceder a la base de datos.
	 * @param extFilters Los filtros de formulario.
	 */
	public AuditoriaDataModel(AuditoriaService auService, Date fechaInicio, Date fechaFin) {
		super();
		this.auService = auService;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	@Override
	public List<AuditoriaFechasModel> load(int first, int pageSize, String sortField,	SortOrder sortOrder, Map<String, String> filters) {
		WrappedData<AuditoriaFechasModel> wd = auService.buscarAuditoria(this.fechaInicio, this.fechaFin, first, pageSize);
		this.datasource = wd.getData();
		setRowCount(wd.getRowCount().intValue());
		return datasource;
	}
	
	@Override
	public boolean isRowAvailable() {
		if(datasource == null) return false;
		int index = rowIndex % pageSize;
		return index >= 0 && index < datasource.size();
	}
	
	@Override
	public Object getRowKey(AuditoriaFechasModel object) {
		return object.getCodTraza();
	}
	
	@Override
	public AuditoriaFechasModel getRowData() {
		if(datasource == null) return null;
		int index =  rowIndex % pageSize;
		if(index > datasource.size()){
			return null;
		}
		return datasource.get(index);
    }
	
	@Override
	public AuditoriaFechasModel getRowData(String rowKey) {
		if(datasource == null) return null;
		for(AuditoriaFechasModel a : datasource) {
			if(a.getCodTraza() == Long.parseLong(rowKey)) return a;
		}
		return null;
	}
	
	@Override
	public int getPageSize() {
		return this.getPageSize();
	}
	
	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public int getRowIndex() {
		return this.getRowIndex();
	}
	
	@Override
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	
	@Override
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
	
	@Override
	public int getRowCount() {
		return this.rowCount;
	}
	
	@Override
	public Object getWrappedData() {
		return this.datasource;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setWrappedData(Object list) {
		this.datasource = (List<AuditoriaFechasModel>) list;
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
}
