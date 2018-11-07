package br.com.livraria.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.impl.ServiceAutorImpl;

@FacesConverter(forClass = Autor.class)
public class ConverterAutor implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Autor autor = null;
		ServiceAutor serviceAutor = new ServiceAutorImpl();

		if (value != null) {
			autor = serviceAutor.buscaPorId(new Long(value));
			return autor;
		}

		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Autor) value).getId().toString();
		}
		return null;
	}

}
