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
 * Ing. Orlando Peña Mora - Jefe de Sistemas
 *
 */
package pe.gob.ocma.seguridad.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import java.util.Set;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import pe.gob.ocma.entities.web_ocma.Usuario;
//import pe.gob.ocma.entities.seguridad.Setusuario;
//import pe.gob.ocma.entities.seguridad.Setusugrupo;
//import pe.gob.ocma.entities.web_ocma.Usuario;
import pe.gob.ocma.intranet.dao.UsuarioDao;
import pe.gob.ocma.intranet.dto.LoginModel;
import pe.gob.ocma.seguridad.dao.GrupoDao;
import pe.gob.ocma.seguridad.util.Encriptador;
//import pe.gob.ocma.seguridad.dao.UsuarioDao;
//import pe.gob.ocma.seguridad.util.ConstanteSe;
//import pe.gob.ocma.seguridad.util.Encriptador;

/**
 * Clase que carga la lista de roles o perfiles que tiene un usuario
 * para manejar la seguridad del sistema.
 * @author César Altamirano Menor
 * 14/05/2013 15:31:05
 */
@Transactional(readOnly=true)
@Service("autenUsuarioService")
public class AutenUsuarioServiceImpl implements UserDetailsService, Serializable{

	private static final long serialVersionUID = -9060399619851575230L;

	@Autowired
    private UsuarioDao usuarioDao;
	@Autowired
    private GrupoDao grupoDao;

    @Override
    public UserDetails loadUserByUsername(String nomUsuario) throws UsernameNotFoundException {    	
    	
    	//LoginModel usuario = usuarioDao.obtenerUsuario(nomUsuario);
    	Usuario usuario = usuarioDao.searchUnique(Usuario.class, "codUsuario", nomUsuario);
        if (usuario == null) {
            StringBuilder sbMensaje = new StringBuilder();
            sbMensaje.append("El usuario ");
            sbMensaje.append(nomUsuario);
            sbMensaje.append(", no está registrado");
            throw new UsernameNotFoundException(sbMensaje.toString());
        }        
        
        //String clave = "";
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_Administrador"));
        System.out.println("usuario: "+usuario.getCodUsuario());
        System.out.println("clave: "+usuario.getDesContrasenaLimpia());
        /*
        try {
			clave = Encriptador.encriptar(usuario.getDesContrasenaLimpia());
		} catch (Exception e) {
			e.printStackTrace();
		}
        */
        //return new User(usuario.getCodUsuario(), usuario.getDesContrasenaLimpia(), true, true, true, true, roles);
        return new User(usuario.getCodUsuario(), usuario.getDesContrasenaLimpia(), roles);
        //return new User("00", "00", true, true, true, true, roles);
     }
}
