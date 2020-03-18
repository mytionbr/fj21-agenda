package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteProcura {
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.pesquisaContato(1);
		System.out.println(contato.getNome()+" "+contato.getEmail());
		
		// funcionario
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId((long) 1);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionario = funcionarioDAO.find(funcionario);
		
		System.out.println(funcionario.getNome());
	}
}
