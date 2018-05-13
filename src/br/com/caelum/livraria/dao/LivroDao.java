package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

//	private Banco banco = new Banco();
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
//		banco.save(livro);
		this.manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
//		return banco.listaLivros();
		return this.manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}
	
}
