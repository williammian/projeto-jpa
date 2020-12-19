package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldoManaged {
	
	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Juliano");
        conta.setNumero(12345);
        conta.setAgencia(54321);
        conta.setSaldo(new BigDecimal(500.0));

        em.getTransaction().begin();

        em.persist(conta);

        conta.setSaldo(new BigDecimal(1000.0));

        em.getTransaction().commit();
    }

}
