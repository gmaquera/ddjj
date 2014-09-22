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
package pe.gob.ocma.seguridad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.seguridad.dto.MenuModel;
import pe.gob.ocma.seguridad.service.OpcGrupoService;
import pe.gob.ocma.seguridad.util.ConstanteSe;

/**
 * Clase para controlar la navegación del sistema.
 * @author César Altamirano Menor
 * 05/06/2013 15:04:30
 */
@ManagedBean
@SessionScoped
public class TreeMenuMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 2768973209277645281L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private TreeNode root = new DefaultTreeNode("root", null);
	private TreeNode[] node;
	private int numNode;
	private Map<Integer, Integer> auxNumNode = new HashMap<Integer, Integer>();
	private List<MenuModel> liRooMenu = new ArrayList<MenuModel>();
	private List<MenuModel> liChiMenu = new ArrayList<MenuModel>();
	
	@ManagedProperty(value = "#{opcGrupoService}")
    private OpcGrupoService opcGrupoService;
	
	public TreeMenuMBean(){
	}
	
	@PostConstruct
    private void inicialize(){
		try {
            char tipo = ConstanteSe.OPCION_MENU_VERTICAL;
            if(super.getSesionMBean().getTipoUsuario().equals(ConstanteSe.TIPO_USU_SUPER)){
            	liRooMenu = opcGrupoService.buscarMenuSoloPadres(tipo);
                liChiMenu = opcGrupoService.buscarMenuHijosPadres(tipo);
            } else {
            	liRooMenu = opcGrupoService.buscarMenuSoloPadres(super.getSesionMBean().getCodUsuario(), tipo);
                liChiMenu = opcGrupoService.buscarMenuHijosPadres(super.getSesionMBean().getCodUsuario(), tipo);
            }
            int max = liRooMenu.size() + liChiMenu.size();
            if (max > 0) {
                node = new TreeNode[max];
                for(MenuModel me : liRooMenu){
                    node[numNode] = new DefaultTreeNode(me, root);
                    auxNumNode.put(me.getMenuId(), numNode);
                    numNode++;
                    assignChildren(me);
                }
            } else {
                super.addWarnMessage(super.getMessage("warn.navegacionCargarArbol"));
            }
        } catch (Exception ex) {
            logger.error("Ha fallado la creación del arbol de navegación para el usuario logeado", ex);
            super.addErrorMessage(super.getMessage("error.navegacionCargarArbol"));
        }
	}
	
	/**
     * Establece los nodos hijos a un árbol menu de forma recursiva.
     *
     * @param father El nodo padre.
     */
    private void assignChildren(MenuModel father) {
        List<MenuModel> children = new ArrayList<MenuModel>();
        children = getMenuByFather(father);
        Iterator<MenuModel> iter = children.iterator();
        while (iter.hasNext()) {
            MenuModel child = iter.next();
            if (child.getUrl().equals("--")) {
                node[numNode] = new DefaultTreeNode(child, node[auxNumNode.get(father.getMenuId())]);
            } else {
                node[numNode] = new DefaultTreeNode("document", child, node[auxNumNode.get(father.getMenuId())]);
            }
            auxNumNode.put(child.getMenuId(), numNode);
            numNode++;
            assignChildren(child);
        }
    }

    /**
     * Devuelve una lista de nodos según su padre.
     *
     * @param father El nodo padre.
     * @return La lista de nodos.
     */
    private List<MenuModel> getMenuByFather(MenuModel father) {
        List<MenuModel> listR = new ArrayList<MenuModel>();
        Iterator<MenuModel> it = liChiMenu.iterator();
        while(it.hasNext()){
            MenuModel me = it.next();
            if(me.getPadreId().intValue() == father.getMenuId()){
                listR.add(me);
                it.remove();
            }
        }
        return listR;
    }

	public TreeNode getRoot() {
		return root;
	}

	public void setOpcGrupoService(OpcGrupoService opcGrupoService) {
		this.opcGrupoService = opcGrupoService;
	}
}
