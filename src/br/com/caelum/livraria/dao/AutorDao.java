package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;


@Stateless
public class AutorDao {

	@Inject
	private Banco banco;

	public void salva(Autor autor) {
		
		System.out.println("Salvando o autor: " + autor.getNome());
		
//		try {
//			Thread.sleep(20000); //20s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
		
		banco.save(autor);
		
		System.out.println("Autor salvo: " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
	// Assim que o Container cria e inicializa o Session Bean, o método aposCriacao é executado.
	// Esse tipo de método ligado ao ciclo de vida do Session Bean também é chamado de Callback.
	@PostConstruct 
	protected void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}
	
}
