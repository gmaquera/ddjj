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
package pe.gob.ocma.seguridad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pe.gob.ocma.common.controller.BaseMBean;

/**
 * Bean de respaldo para guardar un contador de intentos de logeo y asi renderizar un captcha.
 * @author Gino Maquera Coyla
 * 12/12/2013 09:03:34
 */

@ManagedBean
@SessionScoped
public class CaptchaMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Exception typeException;
	private short contador = 0;
	private boolean paginaLogin = true;
		
	public CaptchaMBean() {
	}

	public Exception getTypeException() {
		return typeException;
	}

	public void setTypeException(Exception typeException) {
		if(typeException != null) this.typeException = typeException;
	}

	public short getContador() {
		return contador;
	}

	public void setContador(short contador) {
		this.contador = contador;
	}

	public boolean isPaginaLogin() {
		return paginaLogin;
	}

	public void setPaginaLogin(boolean paginaLogin) {
		this.paginaLogin = paginaLogin;
	}
}
