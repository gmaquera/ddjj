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
package pe.gob.ocma.webocma.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.web_ocma.PersonalInfo;
import pe.gob.ocma.entities.web_ocma.TablaEstadoCivil;
import pe.gob.ocma.entities.web_ocma.WebPersonal;
import pe.gob.ocma.webocma.dao.WebPersonalInfoDao;
import pe.gob.ocma.webocma.dto.WebInfoPersonalModel;
import pe.gob.ocma.webocma.service.WebCVService;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 30/9/2014 8:46:42
 */
//@Transactional(readOnly=true)
@Service("webCVService")
public class WebCVServiceImpl implements WebCVService{
	
	@Autowired
	private WebPersonalInfoDao webPersonalInfoDao; 
	//@Autowired
	//private WebPersonal webPersonal; 
	
	@Transactional
	@Override
	public void EditarInfPersonalCV(WebInfoPersonalModel personalInfoCV,int codpersonal) {
		
			
		
		    //WebInfoPersonalModel DataInfPerCV = new WebInfoPersonalModel(); 
		    //DataInfPerCV =	listaData;
			
			//PersonalInfo
			PersonalInfo personal = new PersonalInfo();
			
			personal = webPersonalInfoDao.get(codpersonal);
//			personal.setFlaSexo(personalInfoCV.getFlaSexo());
			//personalInfoCV = webPersonalInfoDao.get(codpersonal);
			//personalInfoCV.setFlaSexo(listaData.getFla_sexo());
			//personalInfoCV.setCodPersonal(codpersonal);
			personal.setFlaSexo(personalInfoCV.getFla_sexo());
			
			//Tabla Estado Civil
			TablaEstadoCivil tablaEstadoCivil = new TablaEstadoCivil();
			tablaEstadoCivil.setCodEstadocivil(personalInfoCV.getC_estadocivil());
			personal.setTablaEstadoCivil(tablaEstadoCivil);
			personal.setNumPasaporte(personalInfoCV.getPasaporte());
////			
//			//***** DATOS  DEL NACIMIENTO *****///
			
			Date fec_nacimiento = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
			try {
				fec_nacimiento = dateFormat.parse(personalInfoCV.getFec_nacimiento());
				personal.setFecNacimiento(fec_nacimiento);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			personal.setCodDepartamentonac(personalInfoCV.getC_departamentonac());
			personal.setCodProvincianac(personalInfoCV.getC_provincianac());
			personal.setCodDistritonac(personalInfoCV.getC_distritonac());

//		
//			//***** DATOS  DE  RESIDENCIA  *****///
			personal.setDesDireccion(personalInfoCV.getDireccion());
			personal.setCodDepartamento(personalInfoCV.getC_departamento());
			personal.setCodProvincia(personalInfoCV.getC_provincia());
			personal.setCodDistrito(personalInfoCV.getC_distrito());
//			
//
//			//***** MEDIOS  DEL CONTACTO  *****///
			personal.setNumTelefono(personalInfoCV.getTelefono());
			personal.setNumMovil(personalInfoCV.getMovil());
			personal.setDesEmailLaboral(personalInfoCV.getDes_email_laboral());
			personal.setDesEmail(personalInfoCV.getMail());
			//servicio.update(Listaxdj);
			webPersonalInfoDao.update(personal);

			//WebPersonal
			//WebPersonal webPersonalCV = new WebPersonal();  
			//webPersonalCV.setCodPersonal(codpersonal);
			
			
//			System.out.println(djListaxdj.getDesObservacion());
//			System.out.println(djListaxdj.getDjLista().getCodLista());
//			System.out.println(djListaxdj.getDjMaster().getCodDj());
//			System.out.println(djListaxdj.getId().getCodDj());
			//DjListaxdj djListaxdj = djListaxdjDao.searchUnique(DjListaxdj.class,"DjListaxdjId.codDj",it1.next().get);		
		
	}
	
	
}
