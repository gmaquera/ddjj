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
package pe.gob.ocma.common.dao.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que sirve como utilidad para concatenar campos
 * @author César Altamirano Menor
 * 26/09/2013 14:42:44
 */
public class Auditoria {

	public final static String SEPARADOR = "|";
	
	/** Lista de campos */
    private List<String> fields = new ArrayList<String>();
    /** Lista de valores */
    private List<Serializable> values = new ArrayList<Serializable>();
    
	/**
	 * @param field Nombre del campo
	 * @param value Valor correspondiente al campo
	 */
	public Auditoria(String field, Serializable value) {
		super();
		fields.add(field);
		values.add(value);
	}
    
	/**
     * Agrega un campo y su descripción
     *
     * @param field Nombre del campo
     * @param value Valor correspondiente al campo
     */
    public void add(String field, Serializable value) {
        fields.add(field);
        values.add(value);
    }
    
    /**
     * Obtiene los campos como una cadena, para guardar en auditoría
     * @return La cadena con los campos
     */
    public String obtenerCampos() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < fields.size(); i++) {
    		if (i > 0) {
    			sb.append(" ").append(SEPARADOR);
    		}
    		if(i != fields.size()) {
    			sb.append(" ");
    		}
    		sb.append(fields.get(i));
        }
        return sb.toString();
    }
    
    /**
     * Obtiene los valores correspondientes a los campos como una cadena, para guardar en auditoría
     * @return La cadena con los valores
     */
    public String obtenerDatos() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < values.size(); i++) {
    		if (i > 0) {
    			sb.append(" ").append(SEPARADOR);
    		}
    		if(i != values.size()) {
    			sb.append(" ");
    		}
    		sb.append(values.get(i));
        }
        return sb.toString();
    }
}
