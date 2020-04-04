package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idString = req.getParameter("id");  
		
		Contato contato = new Contato();
		
		Connection connection =(Connection) req.getAttribute("conexao");
		
		if(idString != null){
			long id = Long.parseLong(idString);
			ContatoDao dao = new ContatoDao(connection);
		    contato = dao.pesquisaContato(id);
		}
				
		req.setAttribute("contato", contato);
		return "/WEB-INF/jsp/contato.jsp";
	}

}
