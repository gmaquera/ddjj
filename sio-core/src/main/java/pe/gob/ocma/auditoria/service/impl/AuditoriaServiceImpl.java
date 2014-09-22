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
package pe.gob.ocma.auditoria.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasTablaModel;
import pe.gob.ocma.auditoria.dto.AuditoriaModel;
import pe.gob.ocma.auditoria.service.AuditoriaService;
import pe.gob.ocma.common.util.DateUtil;
import pe.gob.ocma.common.wrapper.WrappedData;

/**
 * Clase para menejar la lógica de negocio de las opciones de auditoría.
 * @author César Altamirano Menor
 * 10/10/2013 16:05:03
 */
@Transactional(readOnly=true)
@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService{

	@Autowired
	private AuditoriaDao auDao;
	
	@Override
	public WrappedData<AuditoriaFechasModel> buscarAuditoria(Date fechaInicio,
			Date fechaFin, int first, int pageSize) {
		fechaInicio = DateUtil.obtenerFechaInicioDia(fechaInicio);
		fechaFin = DateUtil.obtenerFechaFinDia(fechaFin);
		return auDao.buscarAuditoria(fechaInicio, fechaFin, first, pageSize);
	}

	@Override
	public List<String> buscarCamposCabecera(short codTabla) {
		AuditoriaModel model = auDao.buscarCamposCabecera(codTabla);
		if(model != null){
			String[] campos = model.getCampos().split("\\|"); 
			List<String> lista = Arrays.asList(campos);
			return lista;
		}
		return null;
	}

	@Override
	public WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(short codTabla, Date fechaInicio, Date fechaFin, 
			int numColumnas, int first, int pageSize) {
		fechaInicio = DateUtil.obtenerFechaInicioDia(fechaInicio);
		fechaFin = DateUtil.obtenerFechaFinDia(fechaFin);
		return auDao.buscarAuditoria(codTabla, fechaInicio, fechaFin, numColumnas, first, pageSize);
	}

	@Override
	public WrappedData<AuditoriaFechasModel> buscarAuditoria(String codUsuario,
			Date fechaInicio, Date fechaFin, int first, int pageSize) {
		fechaInicio = DateUtil.obtenerFechaInicioDia(fechaInicio);
		fechaFin = DateUtil.obtenerFechaFinDia(fechaFin);
		return auDao.buscarAuditoria(codUsuario, fechaInicio, fechaFin, first, pageSize);
	}

	@Override
	public WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(String codUsuario, short codTabla, Date fechaInicio, Date fechaFin,
			int numColumnas, int first, int pageSize) {
		fechaInicio = DateUtil.obtenerFechaInicioDia(fechaInicio);
		fechaFin = DateUtil.obtenerFechaFinDia(fechaFin);
		return auDao.buscarAuditoria(codUsuario, codTabla, fechaInicio, fechaFin, numColumnas, first, pageSize);
	}
}
