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
package pe.gob.ocma.persona.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.persona.service.PersonaService;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 02/12/2013 12:21:48
 */
public class PernatuDataModel extends LazyDataModel<Petpersona> {

	private static final long serialVersionUID = 1L;
	
	private List<Petpersona> datasource;
	Map<String, Serializable> extFilters = new HashMap<String, Serializable>();		
    private int pageSize;
    private int rowIndex;
    private int rowCount;    
    private PersonaService personaService;    
    
    public PernatuDataModel(PersonaService personaService, Map<String, Serializable> extFilters){
    	this.personaService = personaService;
    	this.extFilters = extFilters;
    }
    
    @Override
    public List<Petpersona> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
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
		WrappedData<Petpersona> wd = personaService.buscarPersonas(filters, extFilters, sort, first, pageSize);
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
    public Object getRowKey(Petpersona persona) {
        return persona.getCodPersona();
    }
 
    @Override
    public Petpersona getRowData() {
        if(datasource == null) 
        	return null;
        int index =  rowIndex % pageSize;
        if(index > datasource.size()){
            return null;
        }
        return datasource.get(index);
    }
 
    @Override
    public Petpersona getRowData(String rowKey) {
        if(datasource == null) 
        	return null;
       for(Petpersona persona : datasource) {
           if(persona.getCodPersona()==Long.parseLong(rowKey)) return persona;
       }
       return null;
    } 
    
    @Override
    public int getPageSize() {
        return this.pageSize;
    }
    
    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
    public int getRowCount() {
        return this.rowCount;
    }
    
    @Override
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
 
    @Override
    public Object getWrappedData() {
        return datasource;
	}
    
    @SuppressWarnings("unchecked")
	@Override
    public void setWrappedData(Object list) {
        this.datasource = (List<Petpersona>) list;
    }

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public Map<String, Serializable> getExtFilters() {
		return extFilters;
	}

	public void setExtFilters(Map<String, Serializable> extFilters) {
		this.extFilters = extFilters;
	}
    
	
    
}
