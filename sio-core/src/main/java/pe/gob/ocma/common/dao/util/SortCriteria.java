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

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que sirve como utilidad para agregar query de ordenamientos.
 * @author César Altamirano Menor
 * 06/05/2013 11:06:39
 */
public class SortCriteria {
	
	/** Lista de campos a ordenar */
    private List<String> fields = new ArrayList<String>();

    /**
     * List de valores que indican la forma de ordenar (ascendiente o descendiente)
     */
    private List<Boolean> ascendings = new ArrayList<Boolean>();

    /**
     * Constructor vacio.
     */
    public SortCriteria() {
    }

    /**
     * Constructor conveniente para ordenar por un solo campo
     *
     * @param field Nombre de campo
     * @param ascending Dirección de órden
     */
    public SortCriteria(String field, boolean ascending) {
        add(field, ascending);
    }

    /**
     * Constructor conveniente cuando se desea ordenar ascendente
     *
     * @param field Nombre del campo
     */
    public SortCriteria(String field) {
        this(field, true);
    }

    /**
     * Constructor conveniente cuando se desea ordenar múltiples campos
     *
     * @param fields Nombre de campo
     * @param ascendings Dirección de orden (can be null to set all to true)
     */
    public SortCriteria(String[] fields, boolean[] ascendings) {
        // Check arguments
        if (ascendings != null && (fields.length != ascendings.length)) {
            throw new IllegalArgumentException("SortCriteria: fields.length must be equal to ascendings.length");
        }

        // Process arguments
        for (int i = 0; i < fields.length; i++) {
            add(fields[i], (ascendings != null) ? ascendings[i] : true);
        }
    }

    /**
     * Constructor conveniente cuando se desea ordenar por múltiples campos ascendentemente
     *
     * @param fields Nombre del campo
     * @param ascendings Dirección de ordenamiento
     */
    public SortCriteria(String[] fields) {
        this(fields, null);
    }

    /**
     * Agrega un criterio de ordenación a este objeto
     *
     * @param field Nombre del campo
     * @param ascending Criterio de ordenacion ascendente/descendente
     */
    public void add(String field, boolean ascending) {
        fields.add(field);
        ascendings.add(ascending);
    }

    /**
     * Obtiene HQL statement Ordenado por el criterio
     *
     * @return Un string con el formato " ORDER BY field1 [desc], field2 [desc], field3 [desc], ..."
     */
    public String getHQL() {
        StringBuilder sb = new StringBuilder();
        if (fields.size() > 0) {
            sb.append("ORDER BY ");
            for (int i = 0; i < fields.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("p.").append(fields.get(i));
                if (!ascendings.get(i)) {
                    sb.append(" DESC");
                }
            }
        }
        return sb.toString();
    }
}
