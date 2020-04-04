package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		long id = Long.parseLong(req.getParameter("id"));
		
		Calendar dataNascimento = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			new RuntimeException(e);
			return "contato.jsp";
		}
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		contato.setId(id);
		
		Connection connection =(Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		System.out.println("Contato alterado com sucesso!!!!");
		req.setAttribute("mensagem","O contato do " + contato.getNome() + " foi  alterado com sucesso!!!");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
