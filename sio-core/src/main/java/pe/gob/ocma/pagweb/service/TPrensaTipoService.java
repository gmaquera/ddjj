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

import java.util.List;

import pe.gob.ocma.entities.web.TPrensaTipo;

/**
 * FIXME DESCRIBIR
 * 
 * @author Adolfo Edgar Queque Cruz 
 * 26/11/2013 10:35:04
 */
public interface TPrensaTipoService {
	public abstract List<TPrensaTipo> lisTipNot(int idCateg);

}