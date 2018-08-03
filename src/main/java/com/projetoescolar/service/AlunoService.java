package com.projetoescolar.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projetoescolar.model.Aluno;
import com.projetoescolar.util.Transacional;

public class AlunoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	public EntityManager em;   
	
	@Transacional
	public void salvar(Aluno aluno) {
		
		em.merge(aluno);
		
	
	}
	
	
	@Transacional
	public void excluir(Aluno aluno) {
		
		em.remove(aluno);
		
	}
	
	public Aluno alunoId(Aluno aluno) {
	
		long id = aluno.getId();
		
		return em.find(Aluno.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listaAluno() {
			
		
		Query q = em.createNamedQuery("Todos.alunos");
		
		return q.getResultList();
		
	}
	
	
}
