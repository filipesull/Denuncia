
package br.projetodenunciaweb.repositorio;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.projetodenunciaweb.entidade.Cliente;
import br.projetodenunciaweb.entidade.enumm.AlturaAgressorEnum;
import br.projetodenunciaweb.entidade.enumm.EtniaAgressorEnum;
import br.projetodenunciaweb.entidade.enumm.GrauProximidadeAgressorEnum;
import br.projetodenunciaweb.entidade.enumm.TipoViolenciaEnum;

public abstract class RepositorioGeral<Entidade> {

	private Class<Entidade> classeEntidade;

	public RepositorioGeral() {
		System.out.println("CLASSS" + getClass().getGenericSuperclass().toString());
		this.classeEntidade = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public List<Entidade> listar() {

		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			CriteriaBuilder critBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Entidade> critQuery = critBuilder.createQuery(classeEntidade);
			Root<Entidade> rootEntry = critQuery.from(classeEntidade);
			CriteriaQuery<Entidade> all = critQuery.select(rootEntry);

			TypedQuery<Entidade> allQuery = em.createQuery(all);
			return allQuery.getResultList();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO LISTAR... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void salvar(Cliente cliente, Entidade entidade, AlturaAgressorEnum altura, TipoViolenciaEnum tipoViolencia, GrauProximidadeAgressorEnum grauProximidadeAgressor, String data, String local, String hora, EtniaAgressorEnum etnia) {

		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.persist(entidade);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR... " + e.toString());
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

	public Entidade buscar(long id) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();

			System.out.println("ID: " + id);
			Entidade result = (Entidade) em.find(getClass(), id);
			return result;

		} catch (RuntimeException e) {
			System.out.println("ERRO AO BUSCAR... (" + getClass().toString() + "):" + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void excluir(Entidade entidade) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.remove(entidade);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO DELETAR... " + e.toString());
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

	public void a(Entidade entidade) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.merge(entidade);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO EDITAR... " + e.toString());
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
}