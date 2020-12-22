package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "Select Sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        BigDecimal somaDasMovimentacoes = query.getSingleResult();
        
        System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
        
        String jpql2 = "Select Avg(m.valor) from Movimentacao m";
        TypedQuery<Double> query2 = em.createQuery(jpql2, Double.class);
        Double mediaDasMovimentacoes = query2.getSingleResult();
        
        System.out.println("A média das movimentações é: " + mediaDasMovimentacoes);
        
	}

}
