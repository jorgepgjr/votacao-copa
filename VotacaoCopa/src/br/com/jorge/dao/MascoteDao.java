package br.com.jorge.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.jorge.entity.Mascote;


/**
 *Dao da entidade Mascote. Se tivéssemos mais de um DAO poderiamos criar um GenericHibernateDao com os metodos padrão para todos os DAOs (ex: findById)  
 * @author Jorge
 * @since 27/11/2012
 */
@Component
public class MascoteDao{
	
	private Session session;
	
	
	public MascoteDao(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Mascote> findAll() {
		return this.session.createCriteria(Mascote.class).list();
	}
	
	public void save(Mascote mascote){
		Transaction tx = session.beginTransaction();
		this.session.saveOrUpdate(mascote);
		tx.commit();
	}
	
	public Mascote findById(Long id){
		 Criteria c = getCriteria();
		 c.add(Restrictions.idEq(id));
		 return (Mascote) c.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mascote> findByNome(String nome){
		 Criteria c = getCriteria();
		 c.add(Restrictions.eq("nome", nome));
		 return c.list();
	}

	private Criteria getCriteria() {
		return this.session.createCriteria(Mascote.class);
	}
	
}
