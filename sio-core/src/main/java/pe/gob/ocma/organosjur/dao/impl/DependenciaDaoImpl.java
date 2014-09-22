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
package pe.gob.ocma.organosjur.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.entities.organosjurisd.Ojtdependen;
import pe.gob.ocma.organosjur.dao.DependenciaDao;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 08/11/2013 10:30:24
 */

@Repository("dependenciaDao")
public class DependenciaDaoImpl extends BaseHibernateDaoImpl<Ojtdependen,Integer> implements DependenciaDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Ojtdependen> buscarDependencia(Short codDisJud,
			Short codOrgJurisd, Short codEspeciali) {
		FilterCriteria filter = new FilterCriteria("codDisJud", codDisJud);
		filter.add("codOrgJurisd", codOrgJurisd);
		filter.add("codEspeciali", codEspeciali);
		System.out.println("disjud: "+codDisJud+" orgj: "+codOrgJurisd+" esp: "+codEspeciali);
		return super.searchFilter(filter);
	}
}
