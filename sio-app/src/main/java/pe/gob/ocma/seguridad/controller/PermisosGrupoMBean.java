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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.primefaces.component.api.UIData;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.entities.seguridad.Setaplica;
import pe.gob.ocma.entities.seguridad.Setgrupo;
import pe.gob.ocma.entities.seguridad.Setopcgrupo;
import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.entities.seguridad.Setusugrupo;
import pe.gob.ocma.seguridad.dto.MenuModel;
import pe.gob.ocma.seguridad.service.GrupoService;
import pe.gob.ocma.seguridad.service.OpcGrupoService;
import pe.gob.ocma.seguridad.service.OpcionService;
import pe.gob.ocma.seguridad.service.UsuGrupoService;
import pe.gob.ocma.seguridad.service.UsuarioService;
import pe.gob.ocma.seguridad.util.ConstanteSe;

/**
 * Clase que controla las operaciones con la interfaz de usuario y
 * la lígica de negocio para manejar los permisos de un grupo o rol.
 * @author César Altamirano Menor
 * 26/06/2013 13:08:24
 */
@ManagedBean
@ViewScoped
public class PermisosGrupoMBean extends BaseMBean implements Serializable{

	private static final long serialVersionUID = -3584565270476350986L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	private Setaplica aplicacion;
	private Setgrupo grupo;
	
	private TreeNode root = new DefaultTreeNode("Root", null);
	private TreeNode[] node;
	private int numNode;
	private Map<Integer, Integer> auxNumNode = new HashMap<Integer, Integer>();
	private TreeNode[] selectedNodes;
	MenuModel rootMenu;
	private List<MenuModel> liChiMenu = new ArrayList<MenuModel>();
	
	private List<Setusugrupo> lisUsuariosGrupo = new ArrayList<Setusugrupo>();
	
	private LazyDataModel<Setusuario> lazyModelUsuarios;
	
	@ManagedProperty(value = "#{grupoService}")
	private GrupoService grupoService;
	@ManagedProperty(value = "#{opcionService}")
	private OpcionService opcionService;
	@ManagedProperty(value = "#{opcGrupoService}")
    private OpcGrupoService opcGrupoService;
	@ManagedProperty(value = "#{usuGrupoService}")
	private UsuGrupoService usuGrupoService;
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	public PermisosGrupoMBean(){
	}
	
	@PostConstruct
	private void inicializar(){
		Integer codGrupo = (Integer) Faces.getFlash().get("codGrupoUsuarios");
		if(codGrupo == null) {
			try{
				StringBuilder outcome = new StringBuilder();
				outcome.append(Faces.getRequestContextPath());
				outcome.append("/sistema/seguridad/grupUsuarios.xhtml");
				Faces.redirect(outcome.toString(), "");
			} catch(IOException ex){
				logger.error(ex.getMessage(), ex);
			}
		} else {
			Faces.getFlash().put("codGrupoUsuarios", codGrupo);
			this.grupo = grupoService.buscarGrupo(codGrupo);
			this.aplicacion = grupo.getSetaplica();
			try{
				if(super.getSesionMBean().getTipoUsuario().equals(ConstanteSe.TIPO_USU_SUPER) 
						|| super.getSesionMBean().getTipoUsuario().equals(ConstanteSe.TIPO_USU_ADMIN)){
					this.rootMenu = opcionService.buscarPadreAplicacion(this.grupo.getCodAplica());
					liChiMenu = opcionService.buscarOpcionesAplicacion(this.grupo.getCodAplica());
					node = new TreeNode[liChiMenu.size() + 1];
					node[numNode] = new DefaultTreeNode(rootMenu, root);
                    auxNumNode.put(rootMenu.getMenuId(), numNode);
                    numNode++;
                    assignChildren(rootMenu);
                    this.aplicarSeleccionados();
                    this.lisUsuariosGrupo = usuGrupoService.buscarUsuariosGrupo(codGrupo);    
				}
			} catch (Exception ex){
				logger.error("Ha ocurrido un problema cargando el arbol de permisos", ex);
				super.addErrorMessage(super.getMessage("error.navegacionCargarArbol"));
			}
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
    		if(child.getUrl().equals("--")) {
    			node[numNode] = new DefaultTreeNode(child, node[auxNumNode.get(father.getMenuId())]);
    		} else if(child.getUrl().isEmpty()) {
    			node[numNode] = new DefaultTreeNode("button", child, node[auxNumNode.get(father.getMenuId())]);
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
    
    private void aplicarSeleccionados(){
    	for(int i=0; i<node.length; i++){
    		node[i].setSelected(false);
    	}
		List<Setopcgrupo> lista = opcGrupoService.buscarOpcGrupo(grupo.getCodGrupo());
		Iterator<Setopcgrupo> it = lista.iterator();
		while(it.hasNext()){
			Setopcgrupo og = it.next();
			for(int i=0; i<node.length; i++){
				MenuModel mm = (MenuModel) node[i].getData();
				if(node[i].isLeaf() && mm.getMenuId() == og.getId().getCodOpcion()){
					node[i].setSelected(true);
					it.remove();
					break;
				}
			}
		}
    }
    
    public void eliminarSelectedNodesDuplicados() {
    	if(selectedNodes != null && selectedNodes.length > 0){
    		Set<TreeNode> nodes = new HashSet<TreeNode>();
        	for(TreeNode n : selectedNodes){
        		nodes.add(n);
        	}
        	this.selectedNodes = nodes.toArray(new TreeNode[nodes.size()]);
    	}
    }
    
    public void guardarPermisos(ActionEvent ev){
    	this.eliminarSelectedNodesDuplicados();
		if(selectedNodes == null || selectedNodes.length == 0){
			super.addWarnMessage(super.getMessage("warn.seleccioneOpcioenes"));
			return;
		}
		Map<Integer, Integer> opciones = new HashMap<Integer, Integer>();
    	for(int i=0; i< selectedNodes.length; i++){
    		TreeNode n = selectedNodes[i];
    		MenuModel m = (MenuModel) n.getData();
    		Integer id = opciones.get(m.getMenuId());
    		if(id == null) {
    			opciones.put(m.getMenuId(), m.getMenuId());
    		} 
			while(m.getPadreId() != 0) {
				id = opciones.get(m.getPadreId());
				if(id == null){
					opciones.put(m.getPadreId(), m.getPadreId());
				}
				n = n.getParent();
				m = (MenuModel) n.getData();
			}
    	}
    	try{
    		opcGrupoService.guardarPermisosGrupo(this.grupo.getCodGrupo(), opciones.values(), super.getSesionMBean().getCodUsuario(), super.getSesionMBean().getTerminal());
    		super.addInfoMessage(super.getMessage("msgCambiosGuardadosExito"));
    	}catch(Exception ex){
    		logger.error("Error guardando los permisos", ex);
    		super.addErrorMessage(ex.getMessage());
    	}
    }
    
    public void agregarUsuarioAGrupo(ActionEvent ev) {
    	UIComponent ui = ev.getComponent().getParent().getParent();
		if(ui != null){
			UIData dt =(UIData) ui;
			Setusuario usu = (Setusuario) dt.getRowData();
			Setusugrupo usuGrupo = new Setusugrupo();
			usuGrupo.setSetgrupo(this.grupo);
			usuGrupo.setSetusuario(usu);
			this.usuGrupoService.guardarUsuGrupo(usuGrupo);
			this.lisUsuariosGrupo = usuGrupoService.buscarUsuariosGrupo(this.grupo.getCodGrupo());
		}
    }
    
    public void eliminarUsuarioDeGrupo(ActionEvent ev) {
    	UIComponent ui = ev.getComponent().getParent().getParent();
		if(ui != null){
			UIData dt =(UIData) ui;
			Setusugrupo ug = (Setusugrupo) dt.getRowData();
			this.usuGrupoService.desactivarUsuGrupo(ug);
			this.lisUsuariosGrupo = usuGrupoService.buscarUsuariosGrupo(this.grupo.getCodGrupo());
		}
    }

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}
	
	public Setaplica getAplicacion() {
		return aplicacion;
	}

	public Setgrupo getGrupo() {
		return grupo;
	}

	public List<Setusugrupo> getLisUsuariosGrupo() {
		return lisUsuariosGrupo;
	}

	public LazyDataModel<Setusuario> getLazyModelUsuarios() {
		return lazyModelUsuarios;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	public void setOpcGrupoService(OpcGrupoService opcGrupoService) {
		this.opcGrupoService = opcGrupoService;
	}

	public void setUsuGrupoService(UsuGrupoService usuGrupoService) {
		this.usuGrupoService = usuGrupoService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
