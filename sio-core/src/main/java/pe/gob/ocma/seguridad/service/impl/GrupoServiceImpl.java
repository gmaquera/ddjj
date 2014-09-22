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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.seguridad.Setgrupo;
import pe.gob.ocma.seguridad.dao.AplicacionDao;
import pe.gob.ocma.seguridad.dao.GrupoDao;
import pe.gob.ocma.seguridad.service.GrupoService;

/**
 * Clase de negocio que gestiona los grupos de usuarios desde base de datos.
 * @author César Altamirano Menor
 * 13/06/2013 15:50:52
 */
@Transactional(readOnly=true)
@Service("grupoService")
public class GrupoServiceImpl implements GrupoService{

	@Autowired
	private GrupoDao grupoDao;
	@Autowired
	private AplicacionDao aplicaDao;	
	@Autowired
	private AuditoriaDao auDao;
	
	@Override
	public Setgrupo buscarGrupo(int codGrupo){
		return grupoDao.get(codGrupo);
	}
	
	@Override
	public List<Setgrupo> listarGrupos(){
		return grupoDao.searAll();
	}
	
	@Override
	public List<Setgrupo>  listarGrupos(boolean habilitado) {
		FilterCriteria filter = new FilterCriteria("habilitado", habilitado);
		return grupoDao.searchFilter(filter);
	}

	@Transactional
	@Override
	public Setgrupo guardarGrupo(Setgrupo grupo) {
		long correlativo = grupoDao.searchNextCorrelMae(Tablas.SETGRUPO);
		grupo.setCodGrupo((int)correlativo);
		grupoDao.save(grupo);
		grupo.setSetaplica(aplicaDao.load(grupo.getCodAplica()));
		// Auditoría
		Auditoria au = new Auditoria(Tablas.SETGRUPO_CODGRUPO, grupo.getCodGrupo());
		au.add(Tablas.SETGRUPO_DESCORTA, grupo.getDesCorta());
		au.add(Tablas.SETGRUPO_DESCRIPCION, grupo.getDescripcion());
		au.add(Tablas.SETGRUPO_CODAUTORIZA, grupo.getCodAutoriza());
		au.add(Tablas.SETGRUPO_DES_APP, grupo.getSetaplica().getDescripcion());
		au.add(Tablas.SETGRUPO_HABILITADO, grupo.isHabilitado());
		String valorPk = String.valueOf(grupo.getCodGrupo());
		auDao.guardarCreacion(Tablas.SETGRUPO, au, Tablas.SETGRUPO_CODGRUPO, valorPk);
		return grupo;
	}

	@Transactional
	@Override
	public void actualizarGrupo(Setgrupo grupo) {
		grupo.setSetaplica(aplicaDao.load(grupo.getCodAplica()));
		grupoDao.update(grupo);
		// Auditoría
		Auditoria au = new Auditoria(Tablas.SETGRUPO_CODGRUPO, grupo.getCodGrupo());
		au.add(Tablas.SETGRUPO_DESCORTA, grupo.getDesCorta());
		au.add(Tablas.SETGRUPO_DESCRIPCION, grupo.getDescripcion());
		au.add(Tablas.SETGRUPO_CODAUTORIZA, grupo.getCodAutoriza());
		au.add(Tablas.SETGRUPO_DES_APP, grupo.getSetaplica().getDescripcion());
		au.add(Tablas.SETGRUPO_HABILITADO, grupo.isHabilitado());
		String valorPkm = String.valueOf(grupo.getCodGrupo());
		auDao.guardarActualizacion(Tablas.SETGRUPO, au, Tablas.SETGRUPO_CODGRUPO, valorPkm);
	}

	@Transactional
	@Override
	public void eliminarGrupo(Setgrupo grupo) {
		grupoDao.delete(grupo);
		// Auditoría
		String valorPk = String.valueOf(grupo.getCodGrupo());
		auDao.guardarEliminacion(Tablas.SETGRUPO, Tablas.SETGRUPO_CODGRUPO, valorPk);
	}
}