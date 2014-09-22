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

import pe.gob.ocma.ddjj.dto.magistrado.DjExpedientesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoGeneralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjSancionesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjTrayMagistradoModel;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 10/09/2014 15:19:19
 */
public interface DjInfoGeneralService {

	public abstract List<DjInfoGeneralModel> lisInfoGeneral(String cod_personal);
	
	public abstract List<DjInfoLaboralModel> lisInfoLaboral(String cod_personal);
	
	public abstract List<DjTrayMagistradoModel> lisTrayectoriaMagis(String cod_personal);
	
	public abstract List<DjExpedientesModel> lisExpedienteMagis(int cod_personal,int cod_inicio,int cod_fin);
	
	public abstract List<DjSancionesModel> lisSancionesMagis(int distrito_origen, int cod_personal,int cod_inicio,int cod_fin);
	
}
