package com.projetoescolar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({@NamedQuery(name = "Todos.alunos", query = "select a from Aluno a")})
public class Aluno implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private boolean pago;
	
	@OneToMany(mappedBy="aluno")
	private List<Turma> turmas;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int idade;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public List<Turma> getturmas() {
		return turmas;
	}

	public void setturmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	
	@Override
	public String toString() {
		
		return String.valueOf(getId());
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
