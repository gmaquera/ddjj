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
package pe.gob.ocma.common.dao.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que sirve como utilidad para agregar query de filtros.
 * @author César Altamirano Menor
 * 06/05/2013 11:08:42
 */
public class FilterCriteria {
	
	/** Lista de campos */
    private List<String> fields = new ArrayList<String>();
    /** Lista de valores a comparar */
    private List<Serializable> values = new ArrayList<Serializable>();

    /**
     * Constructor vacio
     */
    public FilterCriteria() {
        super();
    }

    /**
     * Constructor conveniente para una restricción
     *
     * @param field Nombre de campo
     * @param value Valor a comparar
     */
    public FilterCriteria(String field, Serializable value) {
        add(field, value);
    }

    /**
     * Constructor conveniente para múltiples restricciones
     *
     * @param fields Lista con nombres de los campos
     * @param values Lista con los valores a comparar
     */
    public FilterCriteria(String[] fields, Serializable[] values) {
        // Check arguments
        if (values != null && (fields.length != values.length)) {
            throw new IllegalArgumentException("RestricStr: fields.length must be equal to values.length");
        }
        // Process arguments
        for (int i = 0; i < fields.length; i++) {
            add(fields[i], values[i]);
        }
    }

    /**
     * Agrega una restricción
     *
     * @param field Nombre del campo
     * @param value Valor a comparar
     */
    public void add(String field, Serializable value) {
        fields.add(field);
        values.add(value);
    }

    /**
     * Obtiene HQL statement con las cláusulas de restricción y comparación de strings
     *
     * @return Un string con el formato " WHERE field1 = [value1] AND field2 = [value2], ..."
     */
    public String getHQL() {
        StringBuilder sb = new StringBuilder();
        if (fields.size() > 0) {
        	sb.append("where ");
        	for (int i = 0; i < fields.size(); i++) {
        		if (i > 0) {
        			sb.append(" and ");
                }
        		if(values.get(i) instanceof Integer){
        			sb.append(fields.get(i));
        			sb.append("=");
        			sb.append((Integer)values.get(i));
                } else if(values.get(i) instanceof Long){
                	sb.append(fields.get(i));
        			sb.append("=");
        			sb.append((Long)values.get(i));
                } else if(values.get(i) instanceof Short){
                	sb.append(fields.get(i));
        			sb.append("=");
        			sb.append((Short)values.get(i));
                } else if(values.get(i) instanceof String){
                	sb.append("lower(");
                	sb.append(fields.get(i));
                	sb.append(") like '%");
                	sb.append(values.get(i).toString().toLowerCase());
                	sb.append("%'");
                } else if (values.get(i) instanceof Character) {
                	sb.append(fields.get(i));
                	sb.append("='");
                	sb.append(String.valueOf(values.get(i)));
                	sb.append("'");
                } else if (values.get(i) instanceof Boolean) {
                	sb.append(fields.get(i));
                	sb.append("=");
                	sb.append(Boolean.parseBoolean(String.valueOf(values.get(i))));
                } else {
                	throw new IllegalArgumentException("FilterCriteria: El tipo de dato de un filtro no es soportado.");
                }
            }
        }
        return sb.toString();
    }
}
