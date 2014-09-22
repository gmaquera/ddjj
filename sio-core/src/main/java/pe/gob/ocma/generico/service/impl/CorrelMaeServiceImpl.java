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
package pe.gob.ocma.generico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.generico.Getcorrelmae;
import pe.gob.ocma.generico.dao.CorrelMaeDao;
import pe.gob.ocma.generico.service.CorrelMaeService;

/**
 * Clase de negocio para manejar los correlativos de las tablas maestras.
 * @author César Altamirano Menor
 * 14/06/2013 16:25:54
 */
@Transactional(readOnly=true)
@Service("correlMaeService")
public class CorrelMaeServiceImpl implements CorrelMaeService{

	@Autowired
	private CorrelMaeDao correlMaeDao;
	@Autowired
	private AuditoriaDao auDao;
	
	@Override
	public List<Getcorrelmae> listarCorrelativosMaestras() {
		return correlMaeDao.searAll();
	}

	@Transactional
	@Override
	public Getcorrelmae guardarCorrelativoMaestra(Getcorrelmae correlativoMae) {
		if(correlativoMae.getNomTabla().equals(Tablas.GETCORRELMAE) && correlMaeDao.searAll().isEmpty()){
			short co = (short) correlativoMae.getCorrelativo();
			if(co == 0) co = 1;
			correlativoMae.setCodCorrel(co);
			correlativoMae.setCorrelativo(co);
			correlMaeDao.save(correlativoMae);
		} else {
			long correlativo = correlMaeDao.searchNextCorrelMae(Tablas.GETCORRELMAE);
			correlativoMae.setCodCorrel((short) correlativo);
			correlMaeDao.save(correlativoMae);
		}
		// Auditoría
		Auditoria au = new Auditoria(Tablas.GETCORRELMAE_CODCORREL, correlativoMae.getCodCorrel());
		au.add(Tablas.GETCORRELMAE_NOMTABLA, correlativoMae.getNomTabla());
		au.add(Tablas.GETCORRELMAE_CORRELATIVO, correlativoMae.getCorrelativo());
		String valorPk = String.valueOf(correlativoMae.getCodCorrel());
		auDao.guardarCreacion(Tablas.GETCORRELMAE, au, Tablas.GETCORRELMAE_CODCORREL, valorPk);
		
		return correlativoMae;
	}

	@Transactional
	@Override
	public void actualizarCorrelativoMeastra(Getcorrelmae correlativoMae) {
		
		correlMaeDao.update(correlativoMae);
		// Auditoria
		Auditoria au = new Auditoria(Tablas.GETCORRELMAE_CODCORREL, correlativoMae.getCodCorrel());
		au.add(Tablas.GETCORRELMAE_NOMTABLA, correlativoMae.getNomTabla());
		au.add(Tablas.GETCORRELMAE_CORRELATIVO, correlativoMae.getCorrelativo());
		String valorPk = String.valueOf(correlativoMae.getCodCorrel());
		auDao.guardarActualizacion(Tablas.GETCORRELMAE, au, Tablas.GETCORRELMAE_CODCORREL, valorPk);
	}

	@Transactional
	@Override
	public void eliminarCorrelativoMaestra(Getcorrelmae correlativoMae) {
		correlMaeDao.delete(correlativoMae);
		// Auditoría
		String valorPk = String.valueOf(correlativoMae.getCodCorrel());
		auDao.guardarEliminacion(Tablas.GETCORRELMAE, Tablas.GETCORRELMAE_CODCORREL, valorPk);
	}
}