package br.com.livraria.service;

import java.io.Serializable;

import br.com.livraria.model.Usuario;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public interface ServiceEfetuaLogin extends Serializable{

	boolean efetuaLogin(Usuario usuario) throws NegocioException, ManipulationException;

}
