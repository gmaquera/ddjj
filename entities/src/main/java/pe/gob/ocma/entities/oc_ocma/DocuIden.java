package pe.gob.ocma.entities.oc_ocma;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCU_IDEN", schema = "OC_OCMA")
public class DocuIden {
	private int codDocIde;
	private String desDocIde;
	private int flaEstado;
	private Set<ExpeDque> docuIden = new HashSet<ExpeDque>(0);
	
	public DocuIden() {
		super();
	}

	@Id
	@Column(name = "cod_docide", nullable = false)
	public int getCodDocIde() {
		return codDocIde;
	}

	public void setCodDocIde(int codDocIde) {
		this.codDocIde = codDocIde;
	}

	@Column(name = "des_docide", length = 20)
	public String getDesDocIde() {
		return desDocIde;
	}

	public void setDesDocIde(String desDocIde) {
		this.desDocIde = desDocIde;
	}

	@Column(name = "fla_estado", nullable = false)
	public int getFlaEstado() {
		return flaEstado;
	}

	public void setFlaEstado(int flaEstado) {
		this.flaEstado = flaEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuIden")
	public Set<ExpeDque> getDocuIden() {
		return docuIden;
	}

	public void setDocuIden(Set<ExpeDque> docuIden) {
		this.docuIden = docuIden;
	}
	

}
