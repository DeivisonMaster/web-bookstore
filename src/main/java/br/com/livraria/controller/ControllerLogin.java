package br.com.livraria.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.model.Usuario;
import br.com.livraria.service.ServiceEfetuaLogin;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

@Named
@ViewScoped
public class ControllerLogin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	@Inject
	private ServiceEfetuaLogin serviceEfetuaLogin;
	
	public ControllerLogin() {
		this.usuario = new Usuario();
	}
	
	
	public String efetuaLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			boolean buscaPorUsuario = false;
			buscaPorUsuario = this.serviceEfetuaLogin.efetuaLogin(this.usuario);
			
			if(buscaPorUsuario) {
				/* caso o usuario esteja autenticado, obtem um mapa de sessões e inclui o objeto usuario autenticado anteriormente no mapa */
				Map<String, Object> sessaoDoUsuario = context.getExternalContext().getSessionMap();
				sessaoDoUsuario.put("usuarioLogado", this.usuario);
				
				
				return "index?faces-redirect=true";
			}
		} catch (NegocioException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), ""));
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return null;
	}
	
	public String cadastrarAutor() {
		return "/cadastro/cadastroAutor.xhtml?faces-redirect=true";
	}
	
	public String consultaVendas() {
		return "/cadastro/vendas.xhtml?faces-redirect=true";
	}
	
	public String cadastrarLivro() {
		return "/cadastro/cadastroLivro.xhtml?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		ControllerTema tema = new ControllerTema();
		tema.setTema("afterdark");
		return "/login.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}