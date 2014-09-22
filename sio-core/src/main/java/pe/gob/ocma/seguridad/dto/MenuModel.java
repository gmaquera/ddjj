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
package pe.gob.ocma.seguridad.dto;

import java.io.Serializable;

/**
 * Clase con la estructura del menu de navegación.
 * @author César Altamirano Menor
 * 06/05/2013 13:10:27
 */
public class MenuModel implements Serializable{
	
	private static final long serialVersionUID = -5790091535385715105L;
	
	private int menuId;
    private Integer padreId;
    private String nombre;
    private String url;
    private char tipo;
    private int orden;
    
    public MenuModel(){
    }

	/**
	 * @param menuId La clave primaria.
	 * @param padreId El padre de la opción (menuId).
	 * @param nombre El nombre que muestra la opción.
	 * @param url La url de la página.
	 */
	public MenuModel(int menuId, Integer padreId, String nombre, String url) {
		super();
		this.menuId = menuId;
		this.padreId = padreId;
		this.nombre = nombre;
		this.url = url;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public Integer getPadreId() {
		return padreId;
	}

	public void setPadreId(Integer padreId) {
		this.padreId = padreId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
