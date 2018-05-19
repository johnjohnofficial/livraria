package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<Livro> getLivrosPorTitulo(String titulo) {
		
		String jpql = "select l from Livro l where l.titulo like :pTitulo";
		
		TypedQuery<Livro> query = this.manager.createQuery(jpql, Livro.class);
		query.setParameter("pTitulo", "%" + titulo + "%");
		
		return query.getResultList();
	}
	
}
