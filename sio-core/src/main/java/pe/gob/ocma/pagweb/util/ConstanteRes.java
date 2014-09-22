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
package pe.gob.ocma.pagweb.util;

import java.util.Calendar;
import java.util.Date;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 29/11/2013 14:28:51
 */
public class ConstanteRes {
	
	public final static int ORIGEN_NOTICIA=29;
	public final static int DISTRI_NOTICIA=0;
	public final static int FLA_PRINCIPAL=0;
	public final static Date FEC_NOTICIA=Calendar.getInstance().getTime();
	public final static String KEY_PARAM_RES="RUTRES";
	public final static String KEY_PARAM_FOT="RUTFOT";
	public final static int CATE_NOTICIA=12;
	public final static int CATE_RESOLUCION=13;

}