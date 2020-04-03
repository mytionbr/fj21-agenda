package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idString = req.getParameter("id");  
		
		Contato contato = new Contato();
		
		if(idString != null){
			long id = Long.parseLong(idString);
			ContatoDao dao = new ContatoDao();
		    contato = dao.pesquisaContato(id);
		}
				
		req.setAttribute("contato", contato);
		return "contato.jsp";
	}

}
