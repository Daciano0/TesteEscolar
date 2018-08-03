package com.projetoescolar.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projetoescolar.model.Professor;
import com.projetoescolar.util.Transacional;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Transacional
	public void salvar(Professor professor) {

		em.merge(professor);

	}

	
	public Professor professorId(Professor professor) {

	long id = professor.getId();	
		
	
	Professor professor2 = em.find(Professor.class,id);
	
		System.out.println("Nome: "+professor2.getNome());
	
		return professor2;
	}

	@SuppressWarnings("unchecked")
	public List<Professor> listaProfessores() {

		Query q = em.createNamedQuery("Todos.Professores");

		return q.getResultList();
	}

}
