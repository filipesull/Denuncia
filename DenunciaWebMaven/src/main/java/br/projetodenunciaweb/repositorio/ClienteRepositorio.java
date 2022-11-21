
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

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.interfacee.repositorio.IClienteRepositorio;

public class ClienteRepositorio extends RepositorioGeral<Cliente> implements IClienteRepositorio {

	@Override
	public void salvar(Cliente cliente) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			tran = em.getTransaction();
			tran.begin();
			em.persist(cliente);
			System.out.println("ID DO CLIENTE: " + cliente.getId());
			System.out.println("SALVANDO... ");

			tran.commit();

			System.out.println("SALVO COM SUCESSO!!!!");

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR CLIENTE... " + e.toString());
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
	}
	
	@Override
	public boolean alterar(Cliente cliente) {
			EntityTransaction tran = null;
			EntityManagerFactory emf = null;
			EntityManager em = null;
			try {
				emf = Persistence.createEntityManagerFactory("persistenciaweb");
				em = emf.createEntityManager();

				tran = em.getTransaction();
				tran.begin();
				em.merge(cliente);
				System.out.println("ID do cliente: " + cliente.getId());
				System.out.println("SALVANDO ALTERAÇÕES EM CLIENTE... ");

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
	public void remover(Cliente cliente) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.remove(cliente);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO DELETAR O CLIENTE... " + e.toString());
			if (tran != null)
				tran.rollback();
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
	}

	@Override
	public Cliente buscar(long id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			 
			 CriteriaBuilder builder = emf.getCriteriaBuilder();
			 CriteriaQuery<Cliente> crit = builder.createQuery(Cliente.class);
			 Cliente cliente= (Cliente) em.createQuery("FROM br.projetodenunciaweb.entidade.Cliente c WHERE c.id = :id")
					 .setParameter("id", id).getSingleResult();				 
			return cliente;
			
		 
		} catch (RuntimeException e) {
			System.out.println("CONSULTAR CLIENTE POR ID... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
			
		 
	}

	@Override
	public ArrayList<Cliente> listarTodos() {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
			Root<Cliente> rootEntry = cq.from(Cliente.class);
			CriteriaQuery<Cliente> all = cq.select(rootEntry);
			TypedQuery<Cliente> allQuery = em.createQuery(all);
			System.out.println("LISTANDO... ");
			return new ArrayList<Cliente>(allQuery.getResultList());

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

}
