package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Movimentacao;

public class TesteNativeQuery {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        Query sqlQuery = em.createNativeQuery("SELECT * FROM Movimentacao WHERE conta_id = :id", Movimentacao.class);
        sqlQuery.setParameter("id", 2L);
        List<Movimentacao> movimentacoes = sqlQuery.getResultList();
        
        for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getValor());
		}
	}

}
