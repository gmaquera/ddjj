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
package pe.gob.ocma.seguridad.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.seguridad.service.UsuarioService;

/**
 * Modelo para la paginación de la lista de usuarios.
 * @author César Altamirano Menor
 * 20/06/2013 08:41:33
 */
public class UsuarioDataModel extends LazyDataModel<Setusuario>{

	private static final long serialVersionUID = -4361565217067445962L;

	private List<Setusuario> datasource;
	Map<String, Serializable> extFilters = new HashMap<String, Serializable>();
    private int pageSize;
    private int rowIndex;
    private int rowCount;
    private UsuarioService usuarioService;
    
    public UsuarioDataModel(UsuarioService usuarioService, Map<String, Serializable> extFilters){
    	this.usuarioService = usuarioService;
    	this.extFilters = extFilters;
    }
    
    @Override
    public List<Setusuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
    	SortCriteria sort = new SortCriteria();
    	if(sortField == null){
			sort.add("petpernatu.apellido", true);
		} else {
			if(sortOrder == SortOrder.ASCENDING) {
				sort.add(sortField, true);
			}else{
				sort.add(sortField, false);
			}
		}
    	WrappedData<Setusuario> wd = usuarioService.buscarUsuariosDisJudicial(filters, extFilters, sort, first, pageSize);
        datasource = wd.getData();
        setRowCount(wd.getRowCount().intValue());
        return datasource;
    }
 
    @Override
    public boolean isRowAvailable() {
        if(datasource == null)
            return false;
        int index = rowIndex % pageSize ;
        return index >= 0 && index < datasource.size();
    }
 
    @Override
    public Object getRowKey(Setusuario user) {
        return user.getCodUsuario();
    }
 
    @Override
    public Setusuario getRowData() {
        if(datasource == null)
            return null;
        int index =  rowIndex % pageSize;
        if(index > datasource.size()){
            return null;
        }
        return datasource.get(index);
    }
 
    @Override
    public Setusuario getRowData(String rowKey) {
        if(datasource == null)
            return null;
       for(Setusuario user : datasource) {
           if(user.getCodUsuario().equals(rowKey)) return user;
       }
       return null;
    }
 
    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
 
    @Override
    public int getPageSize() {
        return pageSize;
    }
 
    @Override
    public int getRowIndex() {
        return this.rowIndex;
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
 
    @SuppressWarnings("unchecked")
	@Override
    public void setWrappedData(Object list) {
        this.datasource = (List<Setusuario>) list;
    }
 
    @Override
    public Object getWrappedData() {
        return datasource;
	}
}
