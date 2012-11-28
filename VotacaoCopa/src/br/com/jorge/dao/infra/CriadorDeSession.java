package br.com.jorge.dao.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * Classe responsavel pela criação de sessions.
 * @author Jorge
 * @since 27/11/2012
 */
@Component
@RequestScoped
public class CriadorDeSession implements ComponentFactory<Session> {
	private final SessionFactory factory;
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void abre() {
		this.session = factory.openSession();
	}
	
	@PreDestroy
	public void fecha() {
		this.session.close();
	}

	public Session getInstance() {
		return this.session;
	}


}