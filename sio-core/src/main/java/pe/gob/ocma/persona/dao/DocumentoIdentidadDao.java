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
package pe.gob.ocma.persona.dao;

import java.util.List;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.persona.Pettipdoc;

/**
 * Interface de acceso a datos para manejar los tipos de documentos de identificación.
 * @author César Altamirano Menor
 * 21/06/2013 16:40:20
 */
public interface DocumentoIdentidadDao extends BaseHibernateDao<Pettipdoc, Short>{
	
	/**
	 * Devuelve una lista de tipos de documento según el tipo de persona y según su estado.
	 * @param nomTabla La tabla tipo de persona.
	 * @param codColumna La columna que indica el tipo de persona especificamente.
	 * @param habilitado El estado del tipo de documento.
	 * @return La lista buscada.
	 */
	public abstract List<Pettipdoc> buscarTiposDoc(String nomTabla, String codColumna, boolean habilitado);
	
}
