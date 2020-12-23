package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	
	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "Select new br.com.alura.jpa.modelo.MediaComData( Avg(m.valor), day(m.data), month(m.data) ) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "Select Sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        return query.getSingleResult();
	}

}
