package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaMediaDiariaDasMovimentacoes {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "Select Avg(m.valor) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        List<Double> mediaDasMovimentacoes = query.getResultList();
        
        for (Double media : mediaDasMovimentacoes) {
        	System.out.println("A m�dia das movimenta��es �: " + media);
		}
        
	}

}
