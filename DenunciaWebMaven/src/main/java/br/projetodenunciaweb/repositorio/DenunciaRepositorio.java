
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

import br.projetodenunciaweb.entidade.Denuncia;

import br.projetodenunciaweb.excecoes.ExcecaoDenuncia;
import br.projetodenunciaweb.interfacee.repositorio.IDenunciaRepositorio;

public class DenunciaRepositorio extends RepositorioGeral<Denuncia> implements IDenunciaRepositorio {

	@Override
	public ArrayList<Denuncia> consultarPorIdCliente(long idCliente) throws ExcecaoDenuncia {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			
			CriteriaBuilder b = emf.getCriteriaBuilder();
			CriteriaQuery<Denuncia> crit = b.createQuery(Denuncia.class);
			Root<Denuncia> denunRoot = crit.from(Denuncia.class);
			crit.select(denunRoot);
			
			crit.where(b.equal(denunRoot.get("ID do cliente"), idCliente));
			ArrayList<Denuncia> denuncias = (ArrayList<Denuncia>) ((EntityManager) emf).createQuery(crit).getResultList();			 
			return denuncias;
		} catch (RuntimeException e) {
			System.out.println("ERRO AO CONSULTAR A DENUNCIA PELO ID... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}

	@Override
	public boolean alterar(Denuncia denuncia) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			tran = em.getTransaction();
			tran.begin();
			em.merge(denuncia);
			System.out.println("SALVANDO ALTERAÇÕES EM DENUNCIA... ");

			tran.commit();

			System.out.println("ALTERACOES SALVAS!!!!!");

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR ALTERACOES... " + e.toString());
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
	public void salvar(Denuncia denuncia) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			tran = em.getTransaction();
			tran.begin();
			em.persist(denuncia);
			System.out.println("ID DA DENUNCIA: " + denuncia.getId());
			System.out.println("SALVANDO... ");

			tran.commit();

			System.out.println("SALVO COM SUCESSO!!!!");

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR DENUNCIA... " + e.toString());
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
		
	}

	@Override
	public boolean cadastrar(String altura, String proximidade, String etnia, String dataHora, String local,
			String tipoViolencia) {
		
		return false;
	}

	@Override
		public ArrayList<Denuncia> listarDenuncaPorCliente(String idCliente) {
			EntityManagerFactory entityManagerFactory = null;
			EntityManager entityManager = null;
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("persistenciaweb");
				entityManager = entityManagerFactory.createEntityManager();
				
				CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
				CriteriaQuery<Denuncia> criteria = builder.createQuery(Denuncia.class);
				Root<Denuncia> denunciaRoot = criteria.from(Denuncia.class);
				criteria.select(denunciaRoot);
							
				criteria.where(builder.equal(denunciaRoot.get("id"), idCliente));
				
				TypedQuery<Denuncia> allQuery = entityManager.createQuery(criteria);
				
				return new ArrayList<Denuncia>(allQuery.getResultList());

			} catch (RuntimeException e) {
				
				throw e;
			} finally {
				// sessao.close();
				if (entityManager != null) {
					entityManager.close();
					entityManagerFactory.close();
				}
			}
		}
	
	@Override
	public ArrayList<Denuncia> listarTodas() {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Denuncia> cq = cb.createQuery(Denuncia.class);
			Root<Denuncia> rootEntry = cq.from(Denuncia.class);
			CriteriaQuery<Denuncia> all = cq.select(rootEntry);
			TypedQuery<Denuncia> allQuery = em.createQuery(all);
			System.out.println("LISTANDO... ");
			return new ArrayList<Denuncia>(allQuery.getResultList());

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
	public Denuncia buscar(long id) {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("persistenciaweb");
		em = emf.createEntityManager();
		 
		 CriteriaBuilder builder = emf.getCriteriaBuilder();
		 CriteriaQuery<Denuncia> crit = builder.createQuery(Denuncia.class);
		 Denuncia denuncia = (Denuncia) em.createQuery("FROM br.projetodenunciaweb.entidade.Denuncia d WHERE d.id = :id")
				 .setParameter("id", id).getSingleResult();		 
		return denuncia;
		
	 
	} catch (RuntimeException e) {
		System.out.println("CONSULTAR DENUNCIA POR ID... " + e.toString());
		throw e;
	} finally {
		em.close();
		emf.close();
	}	 
}
	
}
