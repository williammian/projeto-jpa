package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
    private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
        String jpql = "Select new br.com.alura.jpa.modelo.MediaComData( Avg(m.valor), day(m.data), month(m.data) ) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {        
        String jpql = "Select Sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        return query.getSingleResult();
	}
	
	public List<MediaComData> getMediaDiariaDasMovimentacoesNamedQuery() {
        TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
        return query.getResultList();
	}

}
