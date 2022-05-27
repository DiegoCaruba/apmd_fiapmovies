package br.com.fiap.movies.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.movies.model.Filme;

public class FilmeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
	EntityManager manager = factory.createEntityManager();
	
	public void inserir(Filme filme) {
		
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
		System.out.println("===> Comitado com sucesso! <===");
	}
	
	public void apagar(Filme filme) {
		
		manager.getTransaction().begin();
		manager.remove(filme);
		manager.getTransaction().commit();
		System.out.println("===> Apagado com sucesso! <====");
	}
	
	public Filme selecionar(String id) {
		String jpql = "SELECT f FROM Filme f WHERE id=" + id;
		TypedQuery<Filme> query = manager.createQuery(jpql, Filme.class);
		return (Filme) query.getSingleResult();
	}
	
	public List<Filme> listarTodos() {
		String jpql = "SELECT f FROM Filme f";
		TypedQuery<Filme> query = manager.createQuery(jpql, Filme.class);
		
		return query.getResultList();
	}
	
	public List<Filme> listarOrdenacao() {
		String jpql = "SELECT f FROM Filme f WHERE avaliacao>2 ORDER BY avaliacao DESC";
		TypedQuery<Filme> query = manager.createQuery(jpql, Filme.class);
		
		return query.getResultList();
	}
	
}
