package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoesDao {
	
	public static void main(String[] args) {
        BigDecimal somaDasMovimentacoes = new MovimentacaoDao().getSomaDasMovimentacoes();
        
        System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
	}

}
