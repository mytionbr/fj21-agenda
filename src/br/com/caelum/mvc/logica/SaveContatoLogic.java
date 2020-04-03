package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class SaveContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		String id = req.getParameter("id");
		
		Calendar dataNascimento = null;
		
		try {
			Date dataPruta = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
			String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataPruta);
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada);
			
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (Exception e) {
			new RuntimeException(e);
			return "contato.jsp";
		}
		
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		
		if(id == null || id == ""){
			dao.adiciona(contato);
			req.setAttribute("mensagem", "Adicionando o contato " + contato.getNome());
		}else{
			contato.setId(Long.parseLong(id));
			dao.altera(contato);
			req.setAttribute("mensagem", "Alterando o contato " + contato.getNome());
		}
		
		return "mvc?logica=ListaContatosLogic";
	}

}
