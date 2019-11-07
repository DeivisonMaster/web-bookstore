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
	
	@Inject
	private FacesContext context;
	
	public ControllerLogin() {
		this.usuario = new Usuario();
	}
	
	public int dividePorZero() {
		return "hello";
	}
	
	
	public String efetuaLogin() {
		try {
			boolean buscaPorUsuario = false;
			buscaPorUsuario = this.serviceEfetuaLogin.efetuaLogin(this.usuario);
			
			if(buscaPorUsuario) {
				tornaUsuarioAutenticadoComoUsuarioLogado(this.context);
				this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Olá, Seja bem-vindo!", ""));
				return "index?faces-redirect=true";
			}
		} catch (NegocioException e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), ""));
		} catch (ManipulationException e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return null;
	}
	
	private void tornaUsuarioAutenticadoComoUsuarioLogado(FacesContext context) {
		/* caso o usuario esteja autenticado, obtem um mapa de sessões e inclui o objeto usuario autenticado anteriormente no mapa */
		Map<String, Object> sessaoDoUsuario = context.getExternalContext().getSessionMap();
		sessaoDoUsuario.put("usuarioLogado", this.usuario);
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
	
	public String index() {
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String deslogar() {
		this.context.getExternalContext().getSessionMap().remove("usuarioLogado");
		
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
