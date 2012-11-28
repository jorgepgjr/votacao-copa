package br.com.jorge.dao.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


/**
 * Factory que vai gerenciar a criação de sessoes.
 * 
 * ApplicationScoped - só queremos um factory por aplicação.
 * Usado as anotações de postConstruct e preDestroy para gerenciar o contrução delegado para o Vraptor 
 * @author Jorge
 * @since 27/11/2012
 */
@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory> {

	private SessionFactory factory;
	
	@PostConstruct
	public void open() {
		AnnotationConfiguration configuration =	new AnnotationConfiguration();
		configuration.configure();
		this.factory = configuration.buildSessionFactory();;
	}
	
	@PreDestroy
	public void close() {
		this.factory.close();
	}
	
	public SessionFactory getInstance() {
		return this.factory;
	}
  

}