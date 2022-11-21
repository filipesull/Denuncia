
package br.projetodenunciaweb.repositorio;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.projetodenunciaweb.entidade.Crime;
import br.projetodenunciaweb.interfacee.repositorio.ICrimeRepositorio;

public class CrimeRepositorio extends RepositorioGeral<Crime> implements ICrimeRepositorio {

	@Override
	public void salvar(Crime crime) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			tran = em.getTransaction();
			tran.begin();
			em.persist(crime);
			System.out.println("ID DO CRIME: " + crime.getId());
			System.out.println("SALVANDO... ");

			tran.commit();

			System.out.println("SALVO COM SUCESSO!!!!");

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR CRIME... " + e.toString());
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
		
	}

	@Override
	public ArrayList<Crime> listarTodos() {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Crime> cq = cb.createQuery(Crime.class);
			Root<Crime> rootEntry = cq.from(Crime.class);
			CriteriaQuery<Crime> all = cq.select(rootEntry);
			TypedQuery<Crime> allQuery = em.createQuery(all);
			System.out.println("LISTANDO... ");
			return new ArrayList<Crime>(allQuery.getResultList());

		} catch (RuntimeException e) {
			System.out.println("erro" + e.toString());

			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
	}

	@Override
	public boolean alterar(Crime crime) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			tran = em.getTransaction();
			tran.begin();
			em.merge(crime);
			System.out.println("ID do crime: " + crime.getId());
			System.out.println("SALVANDO ALTERAÇÕES NO CRIME... ");

			tran.commit();

			System.out.println("ALTERACOES SALVAS!!!!!");

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR ALTERAÇÕES... " + e.toString());
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
		return false;
	}
	
	@Override
	public Crime buscar(long id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			 
			 CriteriaBuilder builder = emf.getCriteriaBuilder();
			 CriteriaQuery<Crime> crit = builder.createQuery(Crime.class);
			 Crime crime = (Crime) em.createQuery("FROM br.projetodenunciaweb.entidade.Crime c WHERE c.id = :id")
					 .setParameter("id", id).getSingleResult();				 
			return crime;
			
		 
		} catch (RuntimeException e) {
			System.out.println("CONSULTAR CRIME POR ID... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
			
		 
	}

}
