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
package pe.gob.ocma.ddjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.ddjj.dao.DjInfoGeneralDao;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpedientesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoGeneralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjSancionesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjTrayMagistradoModel;
import pe.gob.ocma.ddjj.service.DjInfoGeneralService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 10/09/2014 15:19:33
 */

@Transactional(readOnly=true)
@Service("djInfoGeneralService")
public class DjInfoGeneralServiceImpl implements DjInfoGeneralService{

	
	@Autowired
	private DjInfoGeneralDao djInfoGeneralDao;
	
	@Override
	public List<DjInfoGeneralModel> lisInfoGeneral(String cod_personal) {
		return djInfoGeneralDao.lisInfoGeneral(cod_personal);
	}

	@Override
	public List<DjInfoLaboralModel> lisInfoLaboral(String cod_personal) {
		return djInfoGeneralDao.lisInfoLaboral(cod_personal);
	}

	@Override
	public List<DjTrayMagistradoModel> lisTrayectoriaMagis(String cod_personal) {
		return djInfoGeneralDao.lisTrayectoriaMagis(cod_personal);
	}

	@Override
	public List<DjExpedientesModel> lisExpedienteMagis(int cod_personal,int cod_inicio, int cod_fin) {
		return djInfoGeneralDao.lisExpedienteMagis(cod_personal, cod_inicio, cod_fin);
	}

	@Override
	public List<DjSancionesModel> lisSancionesMagis(int distrito_origen,int cod_personal, int cod_inicio, int cod_fin) {
		return djInfoGeneralDao.lisSancionesMagis(distrito_origen,cod_personal, cod_inicio, cod_fin);
	}	
	
}
