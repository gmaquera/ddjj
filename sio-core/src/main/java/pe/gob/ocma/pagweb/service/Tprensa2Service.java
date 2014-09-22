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
package pe.gob.ocma.pagweb.service;

import java.io.Serializable;
import java.util.Map;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.web.TPrensa2;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 28/11/2013 10:55:38
 */
public interface Tprensa2Service {
	
	//public abstract List<TPrensa2> ListaTablaRes();
	
	public abstract WrappedData<TPrensa2> buscarResoluciones(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
	
	public abstract int guardarRes(TPrensa2 tPrensa2);
	
	public abstract void actualizaRes(TPrensa2 tprensa2);
	
	public abstract void updateUrlRes(int id, String desUrl);
	public abstract void updateUrlFot(int id, String desUrl);

	public abstract WrappedData<TPrensa2> buscarNoticias(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
	
}