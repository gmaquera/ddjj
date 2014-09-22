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
package pe.gob.ocma.persona.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.entities.persona.Pettipdoc;
import pe.gob.ocma.persona.dao.DocumentoIdentidadDao;
import pe.gob.ocma.persona.service.DocumentoIdentidadService;

/**
 * DECRIBIR TODO
 * @author César Altamirano Menor
 * 24/06/2013 09:56:56
 */
@Transactional(readOnly=true)
@Service("documentoIdentidadService")
public class DocumentoIdentidadServiceImpl implements DocumentoIdentidadService{
	
	private final boolean REGISTRO_POR_DEFECTO = true;
	
	@Autowired
	private DocumentoIdentidadDao docIdenDao;

	@Override
	public List<Pettipdoc> buscarTiposDoc(boolean habilitado) {
		FilterCriteria filter = new FilterCriteria("habilitado", habilitado);
		return docIdenDao.searchFilter(filter);
	}

	@Override
	public List<Pettipdoc> buscarTiposDoc(String nomTabla, String codColumna,
			boolean habilitado) {
		return docIdenDao.buscarTiposDoc(nomTabla, codColumna, habilitado);
	}

	@Override
	public Pettipdoc buscarTipoDocPorDefecto() {
		return docIdenDao.searchUnique(Pettipdoc.class, "porDefecto", REGISTRO_POR_DEFECTO, ConstanteCore.HABILITADO_TRUE);
	}
}
