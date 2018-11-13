package br.com.livraria.repository;

import java.io.Serializable;

import br.com.livraria.model.Usuario;

public interface RepositoryLogin extends Serializable{
	
	Usuario efetuaLogin(Usuario usuario);
}
