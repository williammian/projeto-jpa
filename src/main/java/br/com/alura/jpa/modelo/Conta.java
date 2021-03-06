package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "conta", 
	uniqueConstraints = {@UniqueConstraint(name = "uk_conta_agencia_numero", columnNames= {"agencia", "numero"})})
public class Conta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String titular;
    
    private Integer agencia;
    
    private Integer numero;
    
    private BigDecimal saldo;
    
    //@OneToMany(mappedBy = "conta") //relacionamento bidirecional, padr�o lazy
    @OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacoes;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
