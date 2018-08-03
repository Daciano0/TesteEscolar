package com.projetoescolar.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.projetoescolar.model.Aluno;
import com.projetoescolar.service.AlunoService;

@Named
@javax.faces.view.ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean showValue =  true;
	
	//@Inject
    private Aluno aluno;
    
    private List<Aluno> alunos;
	
	@Inject
	AlunoService service;
	
	public AlunoBean() {
		
		
		
		aluno = new Aluno();
		
		
	}
	
	public boolean exibir() {
		
		return showValue;
	}
	
	
	public void gerarLista() {
		
		showValue = false;
		
	}
    
	//@Transacional
	public void salvar() {
		
		if(aluno != null) {
		
			service.salvar(aluno);
			
			showValue = false;
			
						
		}
		
		//return "index";
			
	}
	
	public Aluno alunoId(Aluno aluno) {
		
		
		return service.alunoId(aluno);
	}
	
	
	public void excluir() {
		
		if(aluno != null) {
			
			service.excluir(aluno);
			
		}
			
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	

	public List<Aluno> getAlunos() {
		
		alunos = service.listaAluno();
		return alunos;
	}
	

}
