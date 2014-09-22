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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.seguridad.Setopcgrupo;
import pe.gob.ocma.entities.seguridad.SetopcgrupoId;
import pe.gob.ocma.seguridad.dao.GrupoDao;
import pe.gob.ocma.seguridad.dao.OpcGrupoDao;
import pe.gob.ocma.seguridad.dao.OpcionDao;
import pe.gob.ocma.seguridad.dto.MenuModel;
import pe.gob.ocma.seguridad.service.OpcGrupoService;

/**
 * Clase que gestiona el control de acceso para el menu y opciones del sistema según usuario y roles desde base de datos.
 * @author César Altamirano Menor
 * 05/06/2013 17:17:13
 */
@Transactional(readOnly=true)
@Repository("opcGrupoService")
public class OpcGrupoServiceImpl implements OpcGrupoService, Serializable{

	private static final long serialVersionUID = 7981199559406707464L;
	
	@Autowired
	private OpcGrupoDao opcGrupoDao;
	@Autowired
	private GrupoDao grupoDao;
	@Autowired
	private OpcionDao opcDao;
	@Autowired
	private AuditoriaDao auDao;

	
	@Override
	public List<MenuModel> buscarMenuSoloPadres(char tipo) {
		return opcGrupoDao.buscarMenuSoloPadres(tipo);
	}

	@Override
	public List<MenuModel> buscarMenuHijosPadres(char tipo) {
		return opcGrupoDao.buscarMenuHijosPadres(tipo);
	}
	
	@Override
	public List<MenuModel> buscarMenuSoloPadres(String codUsuario, char tipo) {
		return opcGrupoDao.buscarMenuSoloPadres(codUsuario, tipo);
	}

	@Override
	public List<MenuModel> buscarMenuHijosPadres(String codUsuario, char tipo) {
		return opcGrupoDao.buscarMenuHijosPadres(codUsuario, tipo);
	}

	@Override
	public List<MenuModel> buscarMenuSoloPadres(int codDisJudicial) {
		return opcGrupoDao.buscarMenuSoloPadres(codDisJudicial);
	}

	@Override
	public List<MenuModel> buscarMenuHijosPadres(int codDisJudicial) {
		return opcGrupoDao.buscarMenuHijosPadres(codDisJudicial);
	}

	@Override
	public List<MenuModel> buscarMenuSoloPadres() {
		return opcGrupoDao.buscarMenuSoloPadres();
	}

	@Override
	public List<MenuModel> buscarMenuHijosPadres() {
		return opcGrupoDao.buscarMenuHijosPadres();
	}

	@Override
	public List<MenuModel> buscarMenuHijosPadre(Integer opcPadre) {
		return opcGrupoDao.buscarMenuHijosPadre(opcPadre);
	}

	@Override
	public List<Setopcgrupo> buscarOpcGrupo(int codGrupo) {
		return opcGrupoDao.buscarOpcGrupo(codGrupo);
	}

	@Transactional
	@Override
	public void guardarPermisosGrupo(int codGrupo, Collection<Integer> opciones, String codUsuario, String terminal) {
		Collection<Integer> opcEliminar = new ArrayList<Integer>();
		for(Integer i : opciones){
			SetopcgrupoId id = new SetopcgrupoId(i, codGrupo);
			Setopcgrupo og = opcGrupoDao.get(id);
			if(og == null){
				og = new Setopcgrupo();
				og.setId(id);
				opcGrupoDao.save(og);
				// Cargar objetos relacionados
				og.setSetgrupo(grupoDao.load(og.getId().getCodGrupo()));
				og.setSetopcion(opcDao.load(og.getId().getCodOpcion()));
				// Auditoría
				Auditoria au = new Auditoria(Tablas.SETOPCGRUPO_CODGRUPO, og.getId().getCodGrupo());
				au.add(Tablas.SETOPCGRUPO_CODOPCION, og.getId().getCodOpcion());
				au.add(Tablas.SETOPCGRUPO_DES_GRUPO, og.getSetgrupo().getDesCorta());
				au.add(Tablas.SETOPCGRUPO_DES_OPCION, og.getSetopcion().getDescripcion());
				StringBuilder nomPk = new StringBuilder(Tablas.SETOPCGRUPO_CODGRUPO);
				nomPk.append(", ").append(Tablas.SETOPCGRUPO_CODOPCION);
				StringBuilder valorPk = new StringBuilder();
				valorPk.append(og.getId().getCodGrupo());
				valorPk.append(", ").append(og.getId().getCodOpcion());
				auDao.guardarCreacion(Tablas.SETOPCGRUPO, au, nomPk.toString(), valorPk.toString());
			}
			opcEliminar.add(i);
		}
		List<Setopcgrupo> lista = opcGrupoDao.buscarOpcionesPorEliminar(codGrupo, opcEliminar);
		for(Setopcgrupo og : lista){
			opcGrupoDao.delete(og);
			// Auditoría
			StringBuilder nomPk = new StringBuilder(Tablas.SETOPCGRUPO_CODGRUPO);
			nomPk.append(", ").append(Tablas.SETOPCGRUPO_CODOPCION);
			StringBuilder valorPk = new StringBuilder();
			valorPk.append(og.getId().getCodGrupo());
			valorPk.append(", ").append(og.getId().getCodOpcion());
			auDao.guardarEliminacion(Tablas.SETOPCGRUPO, nomPk.toString() , valorPk.toString());
		}
	}
}