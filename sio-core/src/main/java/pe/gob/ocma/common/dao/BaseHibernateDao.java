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
package pe.gob.ocma.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.custom.ScalarReturn;
import org.hibernate.transform.ResultTransformer;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;

/**
 * Interface genérica que maneja el acceso a datos de la aplicación.
 * @author César Altamirano Menor
 * 06/05/2013 11:02:05
 */
public interface BaseHibernateDao<T, Id extends Serializable> extends Serializable {

	/**
     * Devuelve un Objeto Persistente según su clave primaria (no desde base de datos).
     * @param id La clave primaría.
     * @return El Objeto Persistente. Si el objeto no esta persistido se lanza excepción.
     */
    public abstract T load(Id id);

    /**
     * Devuelve un objeto persistente por clave primaria y siempre desde base de datos.
     * @param id La clave primaria.
     * @return El Objeto Persistente. Si el objeto no está devuelve null.
     */
    public abstract T get(Id id);

    /**
     * Inserta un objeto persistente en la base de datos.
     * @param entity El objeto a instertar.
     */
    public abstract void save(T entity);

    /**
     * Actualiza un objeto persistente no persistido en la base de datos.
     * @param entity El objeto a actualizar.
     */
    public abstract void update(T entity);

    /**
     * Actualiza un objecto persistente persistido en la base de datos.
     * @param entity El objeto persistente.
     * @return El Objeto actualizado.
     */
    public abstract T merge(T entity);
    
    /**
     * Elimina un objeto persistente de la base de datos.
     * @param entity
     */
    public abstract void delete(T entity);

    /**
     * Vuelve a cargar un objeto persistente con todos sus atributos y colecciones.
     * @param entity El Objeto Persistente a refrescar.
     * @return El Objeto Persistente con los datos que tiene la base de datos.
     */
    public abstract T refresh(T entity);

    /**
     * Inserta o actualiza un objeto persistente en base de datos.
     * @param entity El Objeto Persitente.
     */
    public abstract void saveOrUpdate(T entity);

    /**
     * Devuelve toda la lista de ocurrencias de un objetos persistentes.
     * @return La lista encontrada.
     */
    public abstract List<T> searAll();

    /**
     * Devuelve una lista de ocurrencias de un objeto persistente comprendido en
     * un rango delimitado por variables de primero y último.
     * @param first La primera ocurrencia (inicio).
     * @param max La última ocurrencia (fin).
     * @return La lista de ocurrencias encontradas.
     */
    public abstract List<T> search(final Integer first, final Integer max);

    /**
     * Devuelve una lista de ocurrencias de un objeto persistente, ordenado según
     * criterios de ordenación.
     *
     * @param sort El o los criterios de ordenación.
     * @return La lista de ocurrencias para el objeto buscado.
     *
     */
    public abstract List<T> searchOrder(SortCriteria sort);

    /**
     * Devuelve una lista de ocurrencias de un objeto persistente, filtrado
     * por un cojunto de criterios.
     *
     * @param filter El o los criterios filtración.
     * @return La lista de ocurrencias para el objeto buscado.
     *
     */
    public abstract List<T> searchFilter(FilterCriteria filter);
    
    /**
     * Devuelve una lista de ocurrencias de un objeto persistente con un límite de resultados y
     * filtrado por un conjunto de criterios.
     * @param filter El o los criterios de filtración.
     * @param maxResults El limite de la cantidad de resultados.
     * @return La lista de ocurrencias para el objeto buscado.
     */
    public abstract List<T> searchFilterLimit(FilterCriteria filter, int maxResults);

    /**
     * Devuelve una lista de ocurrencias de un objeto persistente, ordenado
     * según criterios de ordenación y filtrado por criterios de filtración.
     *
     * @param filter El o los criterios filtración.
     * @param sort El o los criterios de ordenación.
     * @return La lista de ocurrencias para el objeto buscado.
     *
     */
    public abstract List<T> searchFilterAndOrder(FilterCriteria filter, SortCriteria sort);

    /**
     * Devuelve una lista de ocurrencias de un objeto persistente, ordenado según
     * criterios de ordenación y filtrado por criterios de filtración y con limite de paginación.
     *
     * @param filter El o los criterios de filtración.
     * @param sort El o los criterios de ordenación.
     * @param first El registro inicial.
     * @param pageSize La cantidad de registros a retornar.
     * @return El wrapper con los resultados.
     */
    
    /**
     * Devuelve una lista de ocurrencias de un objeto persistente, ordenado según
     * criterios de ordenación y filtrado por criterios de filtración y con limite de paginación.
     * @param colFilters Los filtros de columna.
     * @param extFilters Los filtros de busquedas.
     * @param sort La ordenación.
     * @param first El registro inicial.
     * @param pageSize La cantidad de registros.
     * @return
     */
    public abstract WrappedData<T> searchFilterAndOrderPaginator(Map<String, String> colFilters,
            Map<String, Serializable> extFilters, SortCriteria sort, final int first, final int pageSize);
    
    /**
     * Devuelve el objeto persistente según la comparación hecha por un campo único.
     * @param clazz Objeto persistente
     * @param field El campo que debe ser único.
     * @param data El dato para comparar.
     * @return El objeto persistente encontrado.
     */
    public abstract T searchUnique(Class<T> clazz, String field, Serializable data);

    /**
     * Devuelve el objeto persistente según la comparación hecha por un campo único y su estado.
     * @param clazz Objeto persistente.
     * @param field El campo que debe ser único.
     * @param data El dato para comparar.
     * @param habilitado El estado para filtrar solo habilitados.
     * @return El Objeto Persistente encontrado.
     */
    public abstract T searchUnique(Class<T> clazz, String field, Serializable data, boolean habilitado);

    /**
     * Devuelve un lista de ocurrencias de un objeto persistente a traves de código
     * nativo.
     * @param nativeQuery El script en SQL nativo.
     * @param params El mapa de parametros.
     * @param entity El objeto persistente.
     * @param rt El objeto wrapper para transformar el resultado.
     * @param scalar El o los nombres de los campos.
     * @return La lista con los resultados encontrados.
     */
    @SuppressWarnings("rawtypes")
    public abstract List searchByNativeQuery(String nativeQuery, Map params, Class<?> entity,
            ResultTransformer rt, ScalarReturn scalar);
    
    /**
     * Devuelve el siguiente número de correlativo de una tabla maestra.
     * @param nomTabla El nombre de la tabla.
     * @return El siguiente correlativo.
     */
    public abstract long searchNextCorrelMae(String nomTabla);
    
    /**
     * Devuelve el siguiente número de correlativo de una tabla maestra en modo Merge.
     * @param nomTabla El nombre de la tabla.
     * @return El siguiente correlativo.
     */
    public abstract long searchNextCorrelMaeMerge(String nomTabla);
        
    
    
    
}
