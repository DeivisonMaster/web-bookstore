package br.com.livraria.service;

import java.io.Serializable;

import br.com.livraria.model.Usuario;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public interface ServiceLogin extends Serializable{
	
	Usuario efetuaLogin(Usuario usuario) throws ManipulationException;
}
