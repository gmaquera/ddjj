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
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.api.UIData;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.common.enums.Accion;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.common.util.ConstanteWeb;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.generico.Gettabmae;
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.entities.persona.Pettipdoc;
import pe.gob.ocma.entities.seguridad.Setgrupo;
import pe.gob.ocma.entities.seguridad.Setnivseguri;
import pe.gob.ocma.entities.seguridad.Settema;
import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.entities.ubigeojud.Ujtdisjud;
import pe.gob.ocma.exception.OcmaException;
import pe.gob.ocma.generico.service.MaestraMaestrasService;
import pe.gob.ocma.persona.service.DocumentoIdentidadService;
import pe.gob.ocma.persona.service.PersonaNaturalService;
import pe.gob.ocma.seguridad.model.UsuarioDataModel;
import pe.gob.ocma.seguridad.service.GrupoService;
import pe.gob.ocma.seguridad.service.UsuGrupoService;
import pe.gob.ocma.seguridad.service.UsuarioService;
import pe.gob.ocma.seguridad.util.ConstanteSe;
import pe.gob.ocma.seguridad.util.Encriptador;

/**
 * Clase de control para manejar los usuarios del sistema.
 * @author César Altamirano Menor
 * 19/06/2013 16:15:39
 */
@ManagedBean
@ViewScoped
public class UsuarioMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = -441320127115576663L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<Ujtdisjud> listaDisJudiciales = new ArrayList<Ujtdisjud>();
	private short selectedDisJudicial;
	
	private Accion accion;
	private LazyDataModel<Setusuario> lazyModel;
	private Setusuario usuario;
	private Setusuario usuarioAux;
	private SelectItem[] estados = new SelectItem[3];
	
	private Petpernatu perNatural;
	private List<Petpernatu> lisPerNaturales;
	private Petpernatu selectedPerNatural;
	private List<Pettipdoc> lisDocIden;
	private Short selectedDocIden;
	private String numDocumento;
	private String generoPersona;
	private List<Setgrupo> lisGrupos;
	private List<String> selectedGrupos;
	private String tipoUsuario;
	private boolean existeUsuario = false;
	private boolean editarContrase;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	@ManagedProperty(value = "#{personaNaturalService}")
	private PersonaNaturalService perNatuService;
	@ManagedProperty(value = "#{documentoIdentidadService}")
	private DocumentoIdentidadService docIdenService;
	@ManagedProperty(value = "#{grupoService}")
	private GrupoService grupoService;
	@ManagedProperty(value = "#{usuGrupoService}")
	private UsuGrupoService usuGrupoService;
	@ManagedProperty(value = "#{maestraMaestrasService}")
	private MaestraMaestrasService maeService;
	
	
	public UsuarioMBean(){
		estados[0] = new SelectItem("",super.getMessage("msgTodosLineas"));
		estados[1] = new SelectItem("true", super.getMessage("msgHabilitados"));
		estados[2] = new SelectItem("false", super.getMessage("msgNoHabilitados"));
	}
	
	@PostConstruct
	private void inicializar(){
		this.inicializarLista();
		this.lisDocIden = docIdenService.buscarTiposDoc(Tablas.PETTIPO, Tablas.PETTIPO_CODCOLUMNA_PERNATURAL, ConstanteCore.HABILITADO_TRUE);
	}
	
	private void inicializarLista(){		
		Map<String, Serializable> extFilters = new HashMap<String, Serializable>();		
		this.lazyModel = new UsuarioDataModel(usuarioService, extFilters);
	}
	
	public void cambiarDisJudicial() {
		Map<String, Serializable> extFilters = new HashMap<String, Serializable>();
		if(selectedDisJudicial != 0) {
			extFilters.put("codDisJud", selectedDisJudicial);
		}
		this.lazyModel = new UsuarioDataModel(usuarioService, extFilters);
	}
	
	public void nuevo(ActionEvent ev){
		this.lisGrupos = grupoService.listarGrupos(ConstanteCore.HABILITADO_TRUE);
		this.usuario = new Setusuario();
		this.usuario.setHabilitado(true);
		this.perNatural = new Petpernatu();
		this.selectedDocIden = docIdenService.buscarTipoDocPorDefecto().getCodTipDoc();
		this.numDocumento = "";
		this.generoPersona = "M";
		this.selectedGrupos = new ArrayList<String>();
		this.lisPerNaturales = new ArrayList<Petpernatu>();
		this.selectedPerNatural = null;
		this.tipoUsuario = ConstanteSe.TIPO_USU_NORMAL;
		this.existeUsuario = false;
		accion = Accion.NUEVO;
	}
	
	public void editar(ActionEvent ev){
		this.lisGrupos = grupoService.listarGrupos(ConstanteCore.HABILITADO_TRUE);
		try {
			UIComponent ui = ev.getComponent().getParent().getParent();
			if(ui != null){
				UIData dt =(UIData) ui;
				this.usuario = (Setusuario) dt.getRowData();
				this.usuarioAux = this.usuario;
				this.perNatural = perNatuService.buscarPersonaNatural(usuario.getCodPerNatu());
				this.selectedDocIden = perNatural.getPetpersona().getPettipdoc().getCodTipDoc();
				this.numDocumento = perNatural.getPetpersona().getNumDocumento();
				Gettabmae gp = maeService.buscar(perNatural.getCodTabMae());
				this.generoPersona = gp.getCodColumna();
				this.selectedGrupos = usuGrupoService.buscarCodGruposUsuario(this.usuario.getCodUsuario());
				this.tipoUsuario = Encriptador.desencriptar(usuario.getTipo());
				this.editarContrase = false;
			}
			accion = Accion.EDITAR;
		} catch(Exception ex) {
			addErrorMessage(ex.getMessage());
			logger.error(ex.getMessage(), ex);
		}
	}
	
	public void buscarPersona() {
		if(perNatural.getApellido() != null && perNatural.getNombre() != null) {
			this.lisPerNaturales = perNatuService.buscarPersonaNatural(perNatural.getApellido(), perNatural.getNombre());
		}
	}
	
	public void seleccionarPerNatural(){
		this.selectedPerNatural = this.perNatural;
		this.selectedDocIden = this.perNatural.getPetpersona().getPettipdoc().getCodTipDoc();
		this.numDocumento = this.perNatural.getPetpersona().getNumDocumento();
		this.usuario = this.perNatural.getSetusuario();
		if(usuario == null) {
			usuario = new Setusuario();
			this.usuario.setHabilitado(true);
			this.existeUsuario = false;
		} else {
			try{
				this.tipoUsuario = Encriptador.desencriptar(usuario.getTipo());
				this.existeUsuario = true;
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			}
		}
	}
	
	public void guardar(ActionEvent ev){
		try{
			if(this.lisPerNaturales.size() == 0){
				perNatural.setNombre(perNatural.getNombre().toUpperCase());
				perNatural.setApellido(perNatural.getApellido().toUpperCase());
				Petpersona pe = new Petpersona();
				StringBuilder nom = new StringBuilder();
				nom.append(perNatural.getNombre().trim());
				nom.append(" ");
				nom.append(perNatural.getApellido().trim());
				pe.setNombre(nom.toString());
				Pettipdoc td = new Pettipdoc();
				td.setCodTipDoc(selectedDocIden);
				pe.setPettipdoc(td);
				pe.setNumDocumento(numDocumento);
				pe.setDireccion(ConstanteCore.REMPLASA_NULL);
				pe.setTelefono(ConstanteCore.REMPLASA_NULL);
				pe.setCorreo(ConstanteCore.REMPLASA_NULL);
				usuario.setTipo(Encriptador.encriptar(tipoUsuario));
				usuario.setEnvCorreo(ConstanteCore.HABILITADO_FALSE);
				usuario.setEnvFax(ConstanteCore.HABILITADO_FALSE);
				Settema tm = new Settema(ConstanteWeb.TEMA_INTERFAZ, null);
				usuario.setSettema(tm);
				Setnivseguri ns = new Setnivseguri();
				ns.setCodNivSeguri(ConstanteSe.COD_NIVSEGURI_NINGUNO);
				usuario.setSetnivseguri(ns);				
				usuario.setHabilitado(ConstanteCore.HABILITADO_TRUE);
				usuarioService.guardarUsuario(usuario, perNatural, pe, generoPersona, selectedGrupos, false);
				super.addCallbackParam("save", true);
				super.addInfoMessage(super.getMessage("msgOperacionRealizadaExito"));
			} else {
				Petpersona pe = this.selectedPerNatural.getPetpersona();
				if(selectedDocIden != selectedPerNatural.getPetpersona().getPettipdoc().getCodTipDoc() ||
						!numDocumento.equals(selectedPerNatural.getPetpersona().getNumDocumento())) {
					Pettipdoc td = new Pettipdoc();
					td.setCodTipDoc(selectedDocIden);
					pe.setPettipdoc(td);
					pe.setNumDocumento(numDocumento);
				}
				usuario.setTipo(Encriptador.encriptar(tipoUsuario));
				usuario.setEnvCorreo(ConstanteCore.HABILITADO_FALSE);
				usuario.setEnvFax(ConstanteCore.HABILITADO_FALSE);
				Settema tm = new Settema(ConstanteWeb.TEMA_INTERFAZ, null);
				usuario.setSettema(tm);
				Setnivseguri ns = new Setnivseguri();
				ns.setCodNivSeguri(ConstanteSe.COD_NIVSEGURI_NINGUNO);
				usuario.setSetnivseguri(ns);				
				usuario.setHabilitado(ConstanteCore.HABILITADO_TRUE);
				usuarioService.guardarUsuario(usuario, perNatural, pe, generoPersona, selectedGrupos, true);
				super.addCallbackParam("save", true);
				super.addInfoMessage(super.getMessage("msgOperacionRealizadaExito"));
			}
		} catch(OcmaException ex){
			addErrorMessage(ex.getMessage());
			super.addCallbackParam("save", false);
		}catch(Exception ex){
			addErrorMessage(ex.getMessage());
			logger.error(ex.getMessage(), ex);
			super.addCallbackParam("save", false);
		}
	}
	
	public void actualizar(ActionEvent ev){
		if(!editarContrase){
			this.usuario.setContrasenia(null);
		}
		try{
			usuario.setTipo(Encriptador.encriptar(tipoUsuario));
			usuarioService.actualizarDatosUsuario(usuario, selectedGrupos);
			super.addInfoMessage(super.getMessage("msgDatosGuardadosExito"));
			super.addCallbackParam("save", true);
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			addErrorMessage(ex.getMessage());
			super.addCallbackParam("save", false);
			this.usuario = this.usuarioAux;
		}
	}
	
	public Accion getAccion() {
		return accion;
	}

	public LazyDataModel<Setusuario> getLazyModel() {
		return lazyModel;
	}

	public Setusuario getUsuario() {
		if(usuario == null){
			usuario = new Setusuario();
		}
		return usuario;
	}

	public void setUsuario(Setusuario usuario) {
		this.usuario = usuario;
	}

	public SelectItem[] getEstados() {
		return estados;
	}

	public void setEstados(SelectItem[] estados) {
		this.estados = estados;
	}

	public Petpernatu getPerNatural() {
		return perNatural;
	}

	public void setPerNatural(Petpernatu perNatural) {
		this.perNatural = perNatural;
	}

	public List<Petpernatu> getLisPerNaturales() {
		return lisPerNaturales;
	}

	public Petpernatu getSelectedPerNatural() {
		return selectedPerNatural;
	}

	public void setSelectedPerNatural(Petpernatu selectedPerNatural) {
		this.selectedPerNatural = selectedPerNatural;
	}

	public List<Pettipdoc> getLisDocIden() {
		return lisDocIden;
	}

	public Short getSelectedDocIden() {
		return selectedDocIden;
	}

	public void setSelectedDocIden(Short selectedDocIden) {
		this.selectedDocIden = selectedDocIden;
	}
	
	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getGeneroPersona() {
		return generoPersona;
	}

	public void setGeneroPersona(String generoPersona) {
		this.generoPersona = generoPersona;
	}

	public List<Setgrupo> getLisGrupos() {
		return lisGrupos;
	}

	public List<String> getSelectedGrupos() {
		return selectedGrupos;
	}
	
	public void setSelectedGrupos(List<String> selectedGrupos) {
		this.selectedGrupos = selectedGrupos;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean isExisteUsuario() {
		return existeUsuario;
	}
	
	public boolean isEditarContrase() {
		return editarContrase;
	}

	public void setEditarContrase(boolean editarContrase) {
		this.editarContrase = editarContrase;
	}

	public short getSelectedDisJudicial() {
		return selectedDisJudicial;
	}

	public void setSelectedDisJudicial(short selectedDisJudicial) {
		this.selectedDisJudicial = selectedDisJudicial;
	}

	public List<Ujtdisjud> getListaDisJudiciales() {
		return listaDisJudiciales;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setPerNatuService(PersonaNaturalService perNatuService) {
		this.perNatuService = perNatuService;
	}

	public void setDocIdenService(DocumentoIdentidadService docIdenService) {
		this.docIdenService = docIdenService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	public void setUsuGrupoService(UsuGrupoService usuGrupoService) {
		this.usuGrupoService = usuGrupoService;
	}

	public void setMaeService(MaestraMaestrasService maeService) {
		this.maeService = maeService;
	}

	
}
