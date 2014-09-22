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
package pe.gob.ocma.seguridad.converter;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.gob.ocma.seguridad.controller.UsuarioMBean;

/**
 * Converter para autocompletar los textos con información de personal.
 * @author César Altamirano Menor
 * 21/06/2013 12:50:38
 */
@FacesConverter(value="personalUsuarioConverter")
public class PersonalUsuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fcx, UIComponent comp, String value) {
		/*if(value.trim().equals("")){	TODO
			return null;
		} else {
			UsuarioMBean usuMB = (UsuarioMBean) fcx.getViewRoot().getViewMap().get("usuarioMBean");
			Iterator<WebPersonal> it = usuMB.getLisPerAutoComplete().iterator();
			while(it.hasNext()){
				WebPersonal wp = it.next();
				if(wp.getCodPersonal() == Integer.parseInt(value)){
					return wp;
				}
			}
		}*/
		return null;
	}

	@Override
	public String getAsString(FacesContext fcx, UIComponent comp, Object value) {
		if(value == null || value.equals("")){
			return "";
		}
		return null; //String.valueOf(((WebPersonal) value).getCodPersonal());
	}
}
