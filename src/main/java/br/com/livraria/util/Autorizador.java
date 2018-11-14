package br.com.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.livraria.model.Usuario;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		/* recuperando a pagina na raiz dos componentes */
		String pagina = context.getViewRoot().getViewId();
		
		System.out.println(pagina);
		
		/* se o usuario esta na pagina de login, deixe que ele efetue seu login */
		if("/login.xhtml".equals(pagina)) {
			return;
		}
		
		/* recupera um objeto de usuario logado via chave na coleção, se não houver usuario logado, encaminhar o usuario para a pagina de login */
		Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		if(usuario != null) {
			return;
		}
		
		/* configuração de redirecionamento de usuario não logado no sistema para página de login */
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	
	
}
