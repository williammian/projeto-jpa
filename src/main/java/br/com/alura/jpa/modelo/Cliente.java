package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cliente", 
	uniqueConstraints = {@UniqueConstraint(name = "uk_cliente_nome", columnNames= {"nome"}),
			@UniqueConstraint(name = "uk_cliente_conta", columnNames= {"conta_id"})})
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nome;
    
    private String profissao;
    
    private String endereco;
    
    @JoinColumn(name = "conta_id", foreignKey = @ForeignKey(name = "fk_cliente_conta"))
    @OneToOne
    private Conta conta;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
