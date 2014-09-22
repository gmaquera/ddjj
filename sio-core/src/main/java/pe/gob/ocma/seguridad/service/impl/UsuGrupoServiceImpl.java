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
package pe.gob.ocma.seguridad.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.seguridad.Setusugrupo;
import pe.gob.ocma.entities.seguridad.SetusugrupoId;
import pe.gob.ocma.seguridad.dao.GrupoDao;
import pe.gob.ocma.seguridad.dao.UsuGrupoDao;
import pe.gob.ocma.seguridad.dao.UsuarioDao;
import pe.gob.ocma.seguridad.service.UsuGrupoService;

/**
 * Clase para manejar la lógica de negocio de los grupos de un usuario.
 * @author César Altamirano Menor
 * 26/06/2013 09:58:03
 */
@Transactional(readOnly=true)
@Service("usuGrupoService")
public class UsuGrupoServiceImpl implements UsuGrupoService, Serializable {

	private static final long serialVersionUID = 8823231697870879100L;
	
	@Autowired
	private UsuGrupoDao ugDao;
	@Autowired
	private UsuarioDao usuDao;
	@Autowired
	private GrupoDao grupoDao;
	@Autowired
	private AuditoriaDao auDao;

	@Override
	public List<String> buscarCodGruposUsuario(String codUsuario) {
		return ugDao.buscarCodGruposUsuario(codUsuario);
	}

	@Override
	public List<Setusugrupo> buscarUsuariosGrupo(int codGrupo) {
		return ugDao.buscarUsuariosGrupo(codGrupo);
	}

	@Override
	public void guardarUsuGrupo(Setusugrupo usuGrupo) {
		SetusugrupoId id = new SetusugrupoId();
		id.setCodGrupo(usuGrupo.getSetgrupo().getCodGrupo());
		id.setCodUsuario(usuGrupo.getSetusuario().getCodUsuario());
		usuGrupo.setId(id);
		Setusugrupo ug = ugDao.get(id);
		if(ug == null) {
			usuGrupo.setSetusuario(usuDao.load(usuGrupo.getId().getCodUsuario()));
			usuGrupo.setSetgrupo(grupoDao.load(usuGrupo.getId().getCodGrupo()));
			usuGrupo.setHabilitado(ConstanteCore.HABILITADO_TRUE);
			ugDao.save(usuGrupo);
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
			auDao.guardarCreacion(Tablas.SETUSUGRUPO, au, nomPk.toString(), valorPk.toString());
		} else {
			if(!ug.isHabilitado()) {
				ug.setHabilitado(ConstanteCore.HABILITADO_TRUE);
				ugDao.update(ug);
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
	}

	@Override
	public void desactivarUsuGrupo(Setusugrupo usuGrupo) {
		usuGrupo = ugDao.load(usuGrupo.getId());
		usuGrupo.setHabilitado(ConstanteCore.HABILITADO_FALSE);
		ugDao.update(usuGrupo);
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