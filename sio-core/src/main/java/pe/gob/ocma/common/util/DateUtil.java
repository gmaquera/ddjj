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
package pe.gob.ocma.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase útil para el manejo de fechas
 * @author César Altamirano Menor
 * 10/10/2013 16:08:10
 */
public final class DateUtil {
	
	private final static int HORA_INICIO_DIA = 0;
	private final static int MINUTO_INICIO_DIA = 0;
	private final static int SEGUNDO_INICIO_DIA = 0;
	private final static int HORA_FIN_DIA = 23;
	private final static int MINUTO_FIN_DIA = 59;
	private final static int SEGUNDO_FIN_DIA = 59;
	

	/**
	 * Duevuelve una fecha a las cero cero horas.
	 * @param fecha La fecha con cualquier hora.
	 * @return La fecha con las cero cero horas.
	 */
	public static Date obtenerFechaInicioDia(Date fecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_MONTH);
		Calendar calInicioDia = Calendar.getInstance();
		calInicioDia.set(year, month, date, HORA_INICIO_DIA, MINUTO_INICIO_DIA, SEGUNDO_INICIO_DIA);
		return calInicioDia.getTime();
	}
	
	/**
	 * Devuelve una fecha con las 23 horas (final del día).
	 * @param fecha La fecha con cualquier hora.
	 * @return La fecha con la última hora y minuto del día.
	 */
	public static Date obtenerFechaFinDia(Date fecha){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_MONTH);
		Calendar calFinDia = Calendar.getInstance();
		calFinDia.set(year, month, date, HORA_FIN_DIA, MINUTO_FIN_DIA, SEGUNDO_FIN_DIA);
		return calFinDia.getTime();
	}
	
	/**
	 * 
	 */
	public static String obtenerFecBD(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecNomArc = sdf.format(fecha);
		return fecNomArc;
	}

}
