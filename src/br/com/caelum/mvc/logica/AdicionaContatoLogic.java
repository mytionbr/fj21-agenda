package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		try {
			Date dataPruta = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
			String dataFormatada  = new SimpleDateFormat("dd/MM/yyyy").format(dataPruta);
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada);
			
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			
		} catch (Exception e) {
			new RuntimeException(e);
			return "adiciona-contato.jsp";
		}
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection =(Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		req.setAttribute("mensagem","O contato do " + contato.getNome() + " foi cadastrado com sucesso!!!");
		return "mvc?logica=ListaContatosLogic";
	}
	

}
