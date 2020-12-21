package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
	    EntityManager em = emf.createEntityManager();
	    
	    Movimentacao movimentacao = em.find(Movimentacao.class, 2L);
	    Conta conta = movimentacao.getConta();
	    
	    int qtdeDeMovimentacoes = conta.getMovimentacoes().size();
	    System.out.println("Quantidade de movimentações: " + qtdeDeMovimentacoes);
	    System.out.println("Titula da conta: " + conta.getTitular());
	}

}
