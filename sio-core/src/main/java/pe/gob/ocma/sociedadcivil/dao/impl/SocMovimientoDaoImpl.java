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
package pe.gob.ocma.sociedadcivil.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.oc_ocma.Socmovimiento;
import pe.gob.ocma.sociedadcivil.dao.SocMovimientoDao;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 18/02/2014 15:16:33
 */
@Repository("socMovimientoDao")
public class SocMovimientoDaoImpl  extends BaseHibernateDaoImpl<Socmovimiento, Integer> implements SocMovimientoDao, Serializable{

	private static final long serialVersionUID = 1L;

}
