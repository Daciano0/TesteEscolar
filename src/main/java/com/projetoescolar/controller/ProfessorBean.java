package com.projetoescolar.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.projetoescolar.model.Professor;
import com.projetoescolar.service.ProfessorService;

@Named
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Professor> professores;

	private Professor professor;

	@Inject
	private ProfessorService professorService;

	private boolean status = true;

	public ProfessorBean() {

		professor = new Professor();

	}

	public boolean exibir() {

		return status;
	}

	public Professor professorId(Professor professor) {

		return professorService.professorId(professor);
	}
	
	public void gerarLista() {

		status = false;
	}

	public void salvar() {

		if (professor != null) {

			professorService.salvar(professor);
		}

		status = false;
	}

	public List<Professor> getProfessores() {

		professores = professorService.listaProfessores();

		return professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
