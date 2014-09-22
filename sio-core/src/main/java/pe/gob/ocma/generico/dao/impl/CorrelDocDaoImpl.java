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
package pe.gob.ocma.generico.dao.impl;

import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.generico.Getcorreldoc;
import pe.gob.ocma.entities.generico.GetcorreldocId;
import pe.gob.ocma.generico.dao.CorrelDocDao;


/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 11/11/2013 11:02:37
 */

@Repository("correlDocDao")
public class CorrelDocDaoImpl extends BaseHibernateDaoImpl<Getcorreldoc, GetcorreldocId> implements CorrelDocDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public int searchNextCorrelQuejas(short codTip, int anio) {
		
		StringBuilder hql = new StringBuilder();		
		hql.append("select d.id.numDoc ");
		hql.append("from Getcorreldoc d ");
		hql.append("where d.id.anio = :anio and d.id.codTipDoc = :codTip");		
		Query query = this.getSession().createQuery(hql.toString());
		query.setParameter("anio", anio);
		query.setParameter("codTip", codTip);
		int num = query.list().size();
		if (num == 0) {			
			Getcorreldoc cd = new Getcorreldoc();
			GetcorreldocId id = new GetcorreldocId();
			id.setAnio(anio);
			id.setCodTipDoc(codTip);
			id.setNumDoc(1);
			cd.setId(id);
			cd.setHabilitado(true);
			cd.setNumDocAncho((short)5);
			this.save(cd);						
			return 1;
			
		} else {			
			int numDoc = (int)query.uniqueResult()+1;			
			StringBuilder hql1 = new StringBuilder("update Getcorreldoc u set u.id.numDoc = :numDoc ");
			hql1.append("where u.id.anio = :anio ");
			hql1.append("and u.id.codTipDoc = :codTipDoc ");
			Query query1 = super.getSession().createQuery(hql1.toString());
			query1.setParameter("numDoc", numDoc);
			query1.setParameter("anio", anio);
			query1.setParameter("codTipDoc", codTip);
			query1.executeUpdate();									
			return numDoc;
		}
		
	}
	
	

}
