package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

/*
 * Existe outros session bean além do Singleton e Stateless(SBSL) são eles:
 * Stateful(SBSF) => É um objeto exclusivo de um cliente, apenas um cliente usará este objeto.
 * 	O Session Bean Stateful (SBSF) tem uma funcionalidade muito parecida com a do objeto HttpSession: 
 * 	representa um objeto para o cliente. Ideal para guardar informações que só dizem respeito ao cliente.
 */
@Stateless
//@Stateful
public class AutorDao {

//	@Inject
//	private Banco banco;
	
	@PersistenceContext
	private EntityManager manager;
	
	// Assim que o Container cria e inicializa o Session Bean, o método aposCriacao é executado.
	// Esse tipo de método ligado ao ciclo de vida do Session Bean também é chamado de Callback.
	@PostConstruct 
	protected void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		
		System.out.println("Salvando o autor: " + autor.getNome());
		
//		try {
//			Thread.sleep(20000); //20s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
		
//		banco.save(autor);
		this.manager.persist(autor);
		
		System.out.println("Autor salvo: " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
//		return banco.listaAutores();
		return this.manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
//		Autor autor = this.banco.buscaPelaId(autorId);
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
	
}
