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
package pe.gob.ocma.intranet.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.web_ocma.Usuario;
import pe.gob.ocma.intranet.dao.UsuarioDao;
import pe.gob.ocma.intranet.dto.LoginModel;
import pe.gob.ocma.intranet.service.UsuarioService;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 19/9/2014 12:07:55
 */


@Transactional(readOnly=true)
@Service("usuarioWebService")
public class UsuarioServiceImpl implements UsuarioService, Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioDao usuarioWebDao;

	@Override
	public Usuario buscarUsuario(String codUsuario) {
		return usuarioWebDao.buscarUsuario(codUsuario);
	}

	@Override
	public LoginModel obtenerUsuario(String codUsuario) {
		return usuarioWebDao.obtenerUsuario(codUsuario);
	}

}
