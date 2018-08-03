package com.projetoescolar.service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.projetoescolar.controller.AlunoBean;
import com.projetoescolar.model.Aluno;

@FacesConverter(forClass = Aluno.class)
public class ConverterAluno implements Converter {

	
	@Inject
	AlunoBean alunoBean;
	
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null && value.toString().length() > 0) {
			
			System.out.println("Classe: "+value);
			
			long id = Long.valueOf(value);
			
			Aluno aluno = new Aluno();
			
			aluno.setId(id);

			return alunoBean.alunoId(aluno);
		}
		
		return null;
	}
			
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null ) {
			
			
			return value.toString();
			
		}
		
		
		return null;
	}

}
