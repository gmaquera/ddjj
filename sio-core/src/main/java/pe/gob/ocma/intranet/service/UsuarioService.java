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
package pe.gob.ocma.intranet.service;

import pe.gob.ocma.entities.web_ocma.Usuario;
import pe.gob.ocma.intranet.dto.LoginModel;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 19/9/2014 12:07:04
 */
public interface UsuarioService {
	
	public abstract Usuario buscarUsuario(String codUsuario);
	
	public abstract LoginModel obtenerUsuario(String codUsuario);

}
