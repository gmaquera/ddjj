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
package pe.gob.ocma.ddjj.service;

import java.util.List;

import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionIdiomaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpeProfesionalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaCompModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralCVModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoPersonalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjMeritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjPublicacionesModel;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 19/09/2014 08:46:55
 */
public interface DjCVService {

	public abstract List<DjInfoPersonalModel> lisInfoPersonalCV(String cod_personal);
	
	public abstract List<DjInfoLaboralCVModel> lisInfoLaboralCV(String cod_personal);
	
	public abstract List<DjInfoAcademicaModel> lisInfoAcademicaCV(String cod_personal,String cod_academia);
	
	public abstract List<DjInfoAcademicaCompModel> lisInfoAcademicaComCV(String cod_personal,String cod_academia);
	
	public abstract List<DjCapacitacionModel> lisInfoCapacitacionCV(String cod_personal,String cod_academia);
	
	public abstract List<DjCapacitacionIdiomaModel> lisInfoCapacitacionCompCV(String cod_personal,String cod_academia);
	
	public abstract List<DjExpeProfesionalModel> lisInfoExpProfesionalCV(String cod_personal,String cod_academia);
	
	public abstract List<DjPublicacionesModel> lisInfoPublicacionesCV(String cod_personal);
	
	public abstract List<DjMeritoModel> lisInfoMeritoCV(String cod_personal,String cod_academia);
}
