package com.projetoescolar.service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.projetoescolar.controller.ProfessorBean;
import com.projetoescolar.model.Professor;

@FacesConverter(value="professorId",forClass = Professor.class)
public class ConverterProfessor implements Converter {

	
	@Inject
	ProfessorBean professorBean;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value != null && value.toString().length() > 0) {

			System.out.println("Valor da String: "+value);
						
			Professor professor = new Professor();

			long idProfessor = Long.parseLong(value);
			
			professor.setId(idProfessor);

			
			return professorBean.professorId(professor);

		}

		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			System.out.println("Valor do Object: "+value);
			
			return value.toString();
		}

		return null;
	}

}
