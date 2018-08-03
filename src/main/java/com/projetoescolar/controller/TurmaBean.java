package com.projetoescolar.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.projetoescolar.model.Aluno;
import com.projetoescolar.model.Professor;
import com.projetoescolar.model.Turma;
import com.projetoescolar.service.AlunoService;
import com.projetoescolar.service.ProfessorService;
import com.projetoescolar.service.TurmaService;

@Named
@ViewScoped
public class TurmaBean implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private Turma turma;
	private List<Turma> turmas;
	
	@Inject
	private TurmaService turmaService;
	@Inject
	private AlunoService alunoService;
	@Inject
	private ProfessorService professorService;
	
	private boolean status = true; 
	
	public TurmaBean() {
		
		turma = new Turma();
		
	}
	

	public List<Aluno> Alunos(){
		return alunoService.listaAluno();
	}
	
	
	public List<Professor> Professores(){
		return professorService.listaProfessores();
	}
	
	public void salvar() {
		
		if(turma != null) {
			
			turmaService.salvar(turma);
		}
		status = true;
	}
	
	public void gerarLista() {
		
		status = false;
	}
	
	public boolean exibir() {
		
		return status;
	}
	

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		
		turmas = turmaService.turmas();
		
		return turmas;
	}

	
	
}
