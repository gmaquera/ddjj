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
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.generico.Gettabmae;
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.entities.seguridad.Setnivseguri;
import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.entities.seguridad.Setusugrupo;
import pe.gob.ocma.entities.seguridad.SetusugrupoId;
import pe.gob.ocma.exception.OcmaException;
import pe.gob.ocma.generico.dao.MaestraMaestrasDao;
import pe.gob.ocma.persona.dao.DocumentoIdentidadDao;
import pe.gob.ocma.persona.dao.PersonaDao;
import pe.gob.ocma.persona.dao.PersonaNaturalDao;
import pe.gob.ocma.seguridad.dao.GrupoDao;
import pe.gob.ocma.seguridad.dao.NivelSeguridadDao;
import pe.gob.ocma.seguridad.dao.UsuGrupoDao;
import pe.gob.ocma.seguridad.dao.UsuarioDao;
import pe.gob.ocma.seguridad.service.UsuarioService;
import pe.gob.ocma.seguridad.util.ConstanteSe;
import pe.gob.ocma.seguridad.util.Encriptador;

/**
 * Clase que gestiona los usuarios en relación con el acceso a base de datos.
 * @author César Altamirano Menor
 * 15/05/2013 08:36:24
 */
@Transactional(readOnly=true)
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	private static final long serialVersionUID = 6878463674228153771L;
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PersonaDao perDao;
	@Autowired
	private PersonaNaturalDao perNatuDao;
	@Autowired
	private DocumentoIdentidadDao docIdenDao;
	@Autowired
	MaestraMaestrasDao maeDao;
	@Autowired
	private UsuGrupoDao usuGrupoDao;
	@Autowired
	private NivelSeguridadDao nivSegDao;
	@Autowired
	private UsuarioDao usuDao;
	@Autowired
	private GrupoDao grupoDao;
	@Autowired
	private AuditoriaDao auDao;

	@Override
	public Setusuario buscarUsuario(String nomUsuario) {
		return usuarioDao.buscarUsuario(nomUsuario);
	}	

	@Transactional
	@Override
	public int guardarTemaUsuario(String codUsuario, String codTema, String terminal) {
		return usuarioDao.guardarTemaUsuario(codUsuario, codTema, terminal);
	}

	@Override
	public WrappedData<Setusuario> buscarUsuariosDisJudicial(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize) {
		return usuarioDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}
	
	@Override
	public Setusuario buscarUsuarioPorCodPersonal(int codPersonal){
		List<Setusuario> lista = usuarioDao.searchFilter(new FilterCriteria("codPersonal", codPersonal));
		if(lista == null || lista.size() == 0){
			return null;
		}
		return lista.get(0);
	}

	@Transactional
	@Override
	public Setusuario guardarUsuario(Setusuario usuario, Petpernatu perNatural, Petpersona persona, 
			String generoPersona, List<String> grupos, boolean actualizarPersona) {
		Setusuario usuRep = usuarioDao.get(usuario.getCodUsuario());
		if(usuRep != null){
			throw new OcmaException("El nombre de usuario ya existe por favor verifique.");
		}
		long codPersona;
		long codPerNatu;
		if(perNatural.getCodPerNatu() == 0){
			codPersona = perDao.searchNextCorrelMae(Tablas.PETPERSONA);
			persona.setCodPersona(codPersona);
			Gettabmae tipoPersona = maeDao.buscar(Tablas.PETTIPO, Tablas.PETTIPO_CODCOLUMNA_PERNATURAL);
			persona.setCodTabMae(tipoPersona.getCodTabMae());
			persona.setPettipdoc(docIdenDao.load(persona.getPettipdoc().getCodTipDoc()));
			perDao.save(persona);
			
			codPerNatu = perNatuDao.searchNextCorrelMae(Tablas.PETPERNATU);
			perNatural.setCodPerNatu(codPerNatu);
			Gettabmae genPersona = maeDao.buscar(Tablas.PETGENERO, generoPersona);
			perNatural.setCodTabMae(genPersona.getCodTabMae());
			perNatural.setPetpersona(persona);
			perNatuDao.save(perNatural);
		} else {
			codPerNatu = perNatural.getCodPerNatu();
			if(actualizarPersona) {
				perDao.update(persona);
				Gettabmae genPersona = maeDao.buscar(Tablas.PETGENERO, generoPersona);
				perNatural.setCodTabMae(genPersona.getCodTabMae());
				perNatuDao.update(perNatural);
			}
		}
		usuario.setContrasenia(usuarioDao.obtenerContraseMD5(usuario.getContrasenia()));
		usuario.setCodPerNatu(codPerNatu);
		usuario.setPetpernatu(perNatuDao.load(perNatural.getCodPerNatu()));
		usuarioDao.save(usuario);
		/* Inicio auditoría creación de usuarios */
		try{
			String tipo = Encriptador.desencriptar(usuario.getTipo());
			if(usuario.getTipo().equals(ConstanteSe.TIPO_USU_SUPER)) {
				tipo = "Super usuario";
			} else if(usuario.getTipo().equals(ConstanteSe.TIPO_USU_ADMIN)) {
				tipo = "Administrador";
			}else {
				tipo = "Normal";
			}
			Setnivseguri ns = nivSegDao.load(usuario.getSetnivseguri().getCodNivSeguri());
			Auditoria au = new Auditoria(Tablas.SETUSUARIO_DES_CODUSUARIO, usuario.getCodUsuario());
			au.add(Tablas.SETUSUARIO_DES_USUARIO, persona.getNombre());
			au.add(Tablas.SETUSUARIO_DES_TIPO, tipo);
			au.add(Tablas.SETUSUARIO_DES_NIVSEG, ns.getDescripcion());
			au.add(Tablas.SETUSUARIO_DES_ULTLOGIN, usuario.getUltLogin());
			au.add(Tablas.SETUSUARIO_DES_ULTRESCLAVE, usuario.getUltResClave());
			au.add(Tablas.SETUSUARIO_DES_ENVCORREO, usuario.isEnvCorreo());
			au.add(Tablas.SETUSUARIO_DES_ENVFAX, usuario.isEnvFax());
			au.add(Tablas.SETUSUARIO_HABILITADO, usuario.isHabilitado());
			auDao.guardarCreacion(Tablas.SETUSUARIO, au, Tablas.SETUSUARIO_CODUSUARIO, usuario.getCodUsuario());
		} catch (Exception ex){
			throw new OcmaException("Error guardando auditoría de usuario");
		}
		/* Fin auditoría creación de usuarios */
		for(String cg : grupos){
			SetusugrupoId id = new SetusugrupoId(Integer.parseInt(cg), usuario.getCodUsuario());
			Setusugrupo usuGrupo = usuGrupoDao.get(id);
			if(usuGrupo == null){
				usuGrupo = new Setusugrupo();
				usuGrupo.setId(id);
				usuGrupo.setSetusuario(usuDao.load(usuGrupo.getId().getCodUsuario()));
				usuGrupo.setSetgrupo(grupoDao.load(usuGrupo.getId().getCodGrupo()));
				usuGrupo.setHabilitado(ConstanteCore.HABILITADO_TRUE);
				usuGrupoDao.save(usuGrupo);
				// Auditoria
				Auditoria au = new Auditoria(Tablas.SETUSUGRUPO_DES_CODUSUARIO, usuGrupo.getId().getCodUsuario());
				au.add(Tablas.SETUSUGRUPO_DES_CODGRUPO, usuGrupo.getId().getCodGrupo());
				StringBuilder usu = new StringBuilder();
				usu.append(usuGrupo.getSetusuario().getPetpernatu().getApellido());
				usu.append(" ").append(usuGrupo.getSetusuario().getPetpernatu().getNombre());
				au.add(Tablas.SETUSUGRUPO_DES_USUARIO, usu.toString());
				au.add(Tablas.SETUSUGRUPO_DES_GRUPO, usuGrupo.getSetgrupo().getDesCorta());
				au.add(Tablas.SETUSUGRUPO_HABILITADO, usuGrupo.isHabilitado());
				StringBuilder nomPk = new StringBuilder();
				nomPk.append(Tablas.SETUSUGRUPO_CODUSUARIO);
				nomPk.append(", ").append(Tablas.SETUSUGRUPO_CODGRUPO);
				StringBuilder valorPk = new StringBuilder();
				valorPk.append(usuGrupo.getId().getCodUsuario());
				valorPk.append(", ").append(usuGrupo.getId().getCodGrupo());
				auDao.guardarCreacion(Tablas.SETUSUGRUPO, au, nomPk.toString(), valorPk.toString());
			} else {
				if(!usuGrupo.isHabilitado()){
					usuGrupo.setHabilitado(ConstanteCore.HABILITADO_TRUE);
					usuGrupoDao.update(usuGrupo);
					// Auditoría
					Auditoria au = new Auditoria(Tablas.SETUSUGRUPO_DES_CODUSUARIO, usuGrupo.getId().getCodUsuario());
					au.add(Tablas.SETUSUGRUPO_DES_CODGRUPO, usuGrupo.getId().getCodGrupo());
					StringBuilder usu = new StringBuilder();
					usu.append(usuGrupo.getSetusuario().getPetpernatu().getApellido());
					usu.append(" ").append(usuGrupo.getSetusuario().getPetpernatu().getNombre());
					au.add(Tablas.SETUSUGRUPO_DES_USUARIO, usu.toString());
					au.add(Tablas.SETUSUGRUPO_DES_GRUPO, usuGrupo.getSetgrupo().getDesCorta());
					au.add(Tablas.SETUSUGRUPO_HABILITADO, usuGrupo.isHabilitado());
					StringBuilder nomPk = new StringBuilder();
					nomPk.append(Tablas.SETUSUGRUPO_CODUSUARIO);
					nomPk.append(", ").append(Tablas.SETUSUGRUPO_CODGRUPO);
					StringBuilder valorPk = new StringBuilder();
					valorPk.append(usuGrupo.getId().getCodUsuario());
					valorPk.append(", ").append(usuGrupo.getId().getCodGrupo());
					auDao.guardarActualizacion(Tablas.SETGRUPO, au, nomPk.toString(), valorPk.toString());
				}
			}
		}
		return usuario;
	}

	@Transactional
	@Override
	public void actualizarDatosUsuario(Setusuario usuario, List<String> grupos) {
		usuario.setPetpernatu(perNatuDao.load(usuario.getCodPerNatu()));
		usuarioDao.actualizarDatosUsuario(usuario);
		/* Inicio auditoría actualización de usuarios */
		try{
			String tipo = Encriptador.desencriptar(usuario.getTipo());
			if(usuario.getTipo().equals(ConstanteSe.TIPO_USU_SUPER)) {
				tipo = "Super usuario";
			} else if(usuario.getTipo().equals(ConstanteSe.TIPO_USU_ADMIN)) {
				tipo = "Administrador";
			}else {
				tipo = "Normal";
			}
			Setnivseguri ns = nivSegDao.load(usuario.getSetnivseguri().getCodNivSeguri());
			Auditoria au = new Auditoria(Tablas.SETUSUARIO_DES_CODUSUARIO, usuario.getCodUsuario());
			au.add(Tablas.SETUSUARIO_DES_USUARIO, usuario.getPetpernatu().getPetpersona().getNombre());
			au.add(Tablas.SETUSUARIO_DES_TIPO, tipo);
			au.add(Tablas.SETUSUARIO_DES_NIVSEG, ns.getDescripcion());
			au.add(Tablas.SETUSUARIO_DES_ULTLOGIN, usuario.getUltLogin());
			au.add(Tablas.SETUSUARIO_DES_ULTRESCLAVE, usuario.getUltResClave());
			au.add(Tablas.SETUSUARIO_DES_ENVCORREO, usuario.isEnvCorreo());
			au.add(Tablas.SETUSUARIO_DES_ENVFAX, usuario.isEnvFax());
			au.add(Tablas.SETUSUARIO_HABILITADO, usuario.isHabilitado());
			auDao.guardarActualizacion(Tablas.SETUSUARIO, au, Tablas.SETUSUARIO_CODUSUARIO, usuario.getCodUsuario());
		} catch (Exception ex){
			throw new OcmaException("Error guardando auditoría de usuario");
		}
		/* Fin auditoría actualización de usuarios */
		for(String cg : grupos){
			SetusugrupoId id = new SetusugrupoId(Integer.parseInt(cg), usuario.getCodUsuario());
			Setusugrupo usuGrupo = usuGrupoDao.get(id);
			if(usuGrupo == null){
				usuGrupo = new Setusugrupo();
				usuGrupo.setId(id);
				usuGrupo.setSetusuario(usuDao.load(usuGrupo.getId().getCodUsuario()));
				usuGrupo.setSetgrupo(grupoDao.load(usuGrupo.getId().getCodGrupo()));
				usuGrupo.setHabilitado(ConstanteCore.HABILITADO_TRUE);
				usuGrupoDao.save(usuGrupo);
				// Auditoria
				Auditoria au = new Auditoria(Tablas.SETUSUGRUPO_DES_CODUSUARIO, usuGrupo.getId().getCodUsuario());
				au.add(Tablas.SETUSUGRUPO_DES_CODGRUPO, usuGrupo.getId().getCodGrupo());
				StringBuilder usu = new StringBuilder();
				usu.append(usuGrupo.getSetusuario().getPetpernatu().getApellido());
				usu.append(" ").append(usuGrupo.getSetusuario().getPetpernatu().getNombre());
				au.add(Tablas.SETUSUGRUPO_DES_USUARIO, usu.toString());
				au.add(Tablas.SETUSUGRUPO_DES_GRUPO, usuGrupo.getSetgrupo().getDesCorta());
				au.add(Tablas.SETUSUGRUPO_HABILITADO, usuGrupo.isHabilitado());
				StringBuilder nomPk = new StringBuilder();
				nomPk.append(Tablas.SETUSUGRUPO_CODUSUARIO);
				nomPk.append(", ").append(Tablas.SETUSUGRUPO_CODGRUPO);
				StringBuilder valorPk = new StringBuilder();
				valorPk.append(usuGrupo.getId().getCodUsuario());
				valorPk.append(", ").append(usuGrupo.getId().getCodGrupo());
				auDao.guardarCreacion(Tablas.SETUSUGRUPO, au, nomPk.toString(), valorPk.toString());
			} else {
				if(!usuGrupo.isHabilitado()){
					usuGrupo.setHabilitado(ConstanteCore.HABILITADO_TRUE);
					usuGrupoDao.update(usuGrupo);
					// Auditoría
					Auditoria au = new Auditoria(Tablas.SETUSUGRUPO_DES_CODUSUARIO, usuGrupo.getId().getCodUsuario());
					au.add(Tablas.SETUSUGRUPO_DES_CODGRUPO, usuGrupo.getId().getCodGrupo());
					StringBuilder usu = new StringBuilder();
					usu.append(usuGrupo.getSetusuario().getPetpernatu().getApellido());
					usu.append(" ").append(usuGrupo.getSetusuario().getPetpernatu().getNombre());
					au.add(Tablas.SETUSUGRUPO_DES_USUARIO, usu.toString());
					au.add(Tablas.SETUSUGRUPO_DES_GRUPO, usuGrupo.getSetgrupo().getDesCorta());
					au.add(Tablas.SETUSUGRUPO_HABILITADO, usuGrupo.isHabilitado());
					StringBuilder nomPk = new StringBuilder();
					nomPk.append(Tablas.SETUSUGRUPO_CODUSUARIO);
					nomPk.append(", ").append(Tablas.SETUSUGRUPO_CODGRUPO);
					StringBuilder valorPk = new StringBuilder();
					valorPk.append(usuGrupo.getId().getCodUsuario());
					valorPk.append(", ").append(usuGrupo.getId().getCodGrupo());
					auDao.guardarActualizacion(Tablas.SETGRUPO, au, nomPk.toString(), valorPk.toString());
				}
			}
		}
		List<Setusugrupo> lista = usuGrupoDao.buscarHabilitadosPorDeshabilitar(usuario.getCodUsuario(), grupos);
		for(Setusugrupo ug : lista) {
			ug.setHabilitado(ConstanteCore.HABILITADO_FALSE);
			usuGrupoDao.update(ug);
			// Auditoría
			Auditoria au = new Auditoria(Tablas.SETUSUGRUPO_DES_CODUSUARIO, ug.getId().getCodUsuario());
			au.add(Tablas.SETUSUGRUPO_DES_CODGRUPO, ug.getId().getCodGrupo());
			StringBuilder usu = new StringBuilder();
			usu.append(ug.getSetusuario().getPetpernatu().getApellido());
			usu.append(" ").append(ug.getSetusuario().getPetpernatu().getNombre());
			au.add(Tablas.SETUSUGRUPO_DES_USUARIO, usu.toString());
			au.add(Tablas.SETUSUGRUPO_DES_GRUPO, ug.getSetgrupo().getDesCorta());
			au.add(Tablas.SETUSUGRUPO_HABILITADO, ug.isHabilitado());
			StringBuilder nomPk = new StringBuilder();
			nomPk.append(Tablas.SETUSUGRUPO_CODUSUARIO);
			nomPk.append(", ").append(Tablas.SETUSUGRUPO_CODGRUPO);
			StringBuilder valorPk = new StringBuilder();
			valorPk.append(ug.getId().getCodUsuario());
			valorPk.append(", ").append(ug.getId().getCodGrupo());
			auDao.guardarActualizacion(Tablas.SETGRUPO, au, nomPk.toString(), valorPk.toString());
		}
	}

	@Override
	public void cambiarContrasenia(String codUsuario, String contraseActual, String contraseNueva) {
		usuarioDao.cambiarContrasenia(codUsuario, contraseActual, contraseNueva);
		// Auditoría
		Auditoria au = new Auditoria(Tablas.SETUSUARIO_DES_CODUSUARIO, codUsuario);
		au.add(Tablas.SETUSUARIO_DES_CONSTRASE, contraseNueva);
		auDao.guardarActualizacion(Tablas.SETUSUARIO, au, Tablas.SETUSUARIO_CODUSUARIO, codUsuario);
	}

	@Override
	public Setusuario buscarUsuarioCod(String codUsuario) {
		return usuDao.get(codUsuario);
	}
}