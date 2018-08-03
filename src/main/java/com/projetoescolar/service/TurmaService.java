package com.projetoescolar.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projetoescolar.model.Turma;
import com.projetoescolar.util.Transacional;

public class TurmaService implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	@Transacional
	public void salvar(Turma turma) {
		
		em.merge(turma);
	}
	
	@Transacional
	public void excluir(Turma turma) {
		
		em.remove(turma);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> turmas(){
		
		Query q = em.createNamedQuery("Todas.Turmas");
		
		return q.getResultList();
	}
}
