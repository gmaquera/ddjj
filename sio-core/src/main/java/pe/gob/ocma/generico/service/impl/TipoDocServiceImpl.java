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
package pe.gob.ocma.generico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.generico.Gettipdoc;
import pe.gob.ocma.generico.dao.TipoDocDao;
import pe.gob.ocma.generico.service.TipoDocService;

/**
 * Clase para manejar la lógica de negocio de los tipos de documentos.
 * @author Gino Maquera Coyla
 * 28/11/2013 09:57:42
 */

@Transactional(readOnly=true)
@Service("tipoDocService")
public class TipoDocServiceImpl implements TipoDocService{

	@Autowired
	private TipoDocDao tipoDocDao;
	
	@Override
	public List<Gettipdoc> listarTipoDoc() {
		return tipoDocDao.searAll();
	}

}
