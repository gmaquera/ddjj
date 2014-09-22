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
package pe.gob.ocma.ubigeo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.entities.ubigeojud.Ujtprojud;
import pe.gob.ocma.ubigeo.dao.ProvinciaJudDao;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla 05/11/2013 12:20:13
 * 07/11/2013 12:18:59
 */

@Repository("provinciaJudDao")
public class ProvinciaJudDaoImpl extends BaseHibernateDaoImpl<Ujtprojud, Short> implements ProvinciaJudDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<Ujtprojud> buscarProvinciasJud(Short codDisJud) {
		//SortCriteria sort = new SortCriteria("Ujtprojud.descripcion");
		//return super.searchFilterAndOrder(new FilterCriteria("Ujtdisjud.codDisJud", codDisJud), sort);		
		return super.searchFilter(new FilterCriteria("codDisJud", codDisJud));		
	}	
	
}
