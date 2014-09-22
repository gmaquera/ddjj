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

import pe.gob.ocma.ddjj.dao.DjCVDao;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionIdiomaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpeProfesionalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaCompModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoFamiliarModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralCVModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoPersonalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjMeritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjPublicacionesModel;
import pe.gob.ocma.ddjj.service.DjCVService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 19/09/2014 08:49:32
 */

@Transactional(readOnly=true)
@Service("djCVService")
public class DjCVServiceImpl implements DjCVService{

	
	@Autowired
	private DjCVDao djCVDao;
	
	@Override
	public List<DjInfoPersonalModel> lisInfoPersonalCV(String cod_personal) {
		return djCVDao.lisInfoPersonalCV(cod_personal);
	}

	@Override
	public List<DjInfoLaboralCVModel> lisInfoLaboralCV(String cod_personal) {
		return djCVDao.lisInfoLaboralCV(cod_personal);
	}

	@Override
	public List<DjInfoAcademicaModel> lisInfoAcademicaCV(String cod_personal,String cod_academia) {
		return djCVDao.lisInfoAcademicaCV(cod_personal, cod_academia);
	}

	@Override
	public List<DjInfoAcademicaCompModel> lisInfoAcademicaComCV(String cod_personal, String cod_academia) {
		return djCVDao.lisInfoAcademicaComCV(cod_personal, cod_academia);
	}

	@Override
	public List<DjCapacitacionModel> lisInfoCapacitacionCV(String cod_personal, String cod_academia) {
		return djCVDao.lisInfoCapacitacionCV(cod_personal, cod_academia);
	}

	@Override
	public List<DjCapacitacionIdiomaModel> lisInfoCapacitacionCompCV(String cod_personal, String cod_academia) {
		return djCVDao.lisInfoCapacitacionCompCV(cod_personal, cod_academia);
	}

	@Override
	public List<DjExpeProfesionalModel> lisInfoExpProfesionalCV(String cod_personal, String cod_academia) {
		return djCVDao.lisInfoExpProfesionalCV(cod_personal, cod_academia);
	}

	@Override
	public List<DjPublicacionesModel> lisInfoPublicacionesCV(String cod_personal) {
		return djCVDao.lisInfoPublicacionesCV(cod_personal);
	}

	@Override
	public List<DjMeritoModel> lisInfoMeritoCV(String cod_personal,String cod_academia) {
		return djCVDao.lisInfoMeritoCV(cod_personal,cod_academia);
	}

	@Override
	public List<DjInfoFamiliarModel> lisInfoFamiliarCV(int cod_personal,int cpariente) {
		return djCVDao.lisInfoFamiliarCV(cod_personal,cpariente);
	}

}
