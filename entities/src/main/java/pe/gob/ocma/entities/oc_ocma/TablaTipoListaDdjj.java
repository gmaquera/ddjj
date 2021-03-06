package pe.gob.ocma.entities.oc_ocma;

// Generated 21/08/2014 08:40:05 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TablaTipoListaDdjj generated by hbm2java
 */
@Entity
@Table(name = "TABLA_TIPO_LISTA_DDJJ", schema = "OC_OCMA")
public class TablaTipoListaDdjj implements java.io.Serializable {

	private int codTipoLista;
	private String desTipoLista;
	private char flaEstado;

	public TablaTipoListaDdjj() {
	}

	public TablaTipoListaDdjj(int codTipoLista, String desTipoLista,
			char flaEstado) {
		this.codTipoLista = codTipoLista;
		this.desTipoLista = desTipoLista;
		this.flaEstado = flaEstado;
	}

	@Id
	@Column(name = "COD_TIPO_LISTA", nullable = false)
	public int getCodTipoLista() {
		return this.codTipoLista;
	}

	public void setCodTipoLista(int codTipoLista) {
		this.codTipoLista = codTipoLista;
	}

	@Column(name = "DES_TIPO_LISTA", nullable = false, length = 100)
	public String getDesTipoLista() {
		return this.desTipoLista;
	}

	public void setDesTipoLista(String desTipoLista) {
		this.desTipoLista = desTipoLista;
	}

	@Column(name = "FLA_ESTADO", nullable = false, length = 1)
	public char getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(char flaEstado) {
		this.flaEstado = flaEstado;
	}

}
