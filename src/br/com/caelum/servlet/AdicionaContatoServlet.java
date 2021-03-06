package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	busca	o	writer
		PrintWriter	out	=	response.getWriter();
		//	buscando	os	par?metros	no	request
		String	nome = request.getParameter("nome");
		String	endereco = request.getParameter("endereco");
		String	email = request.getParameter("email");
		String	dataEmTexto	= request.getParameter("dataNascimento");
		System.out.println(dataEmTexto);
		Calendar dataNascimento	= null;
		SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");
		//	fazendo	a	convers?o	da	data
		try	{
			Date date = new	SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
			String dataFormatadaString = conversor.format(date);
			Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatadaString);
			System.out.println(dataFormatada);
			dataNascimento	=	Calendar.getInstance();
			dataNascimento.setTime(dataFormatada);
		}catch(ParseException e) {
			out.println("Erro	de	convers?o	da	data" + e);
			return;	//para	a	execu??o	do	m?todo
		}
		//	monta	um	objeto	contato
		Contato	contato	=	new	Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		//	salva	o	contato
		ContatoDao	dao	=	new	ContatoDao();
		dao.adiciona(contato);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
//		//	imprime	o	nome	do	contato	que	foi	adicionado
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Contato	"	+	contato.getNome() + "	adicionado	com	sucesso");
//		out.println("</body>");
//		out.println("</html>");
}


}


