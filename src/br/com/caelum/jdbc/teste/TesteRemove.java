package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteRemove {
	public static void main(String[] args) {
//		Contato contato = new Contato();
//		contato.setId((long) 1);
//		
//		ContatoDao dao = new ContatoDao();
//		dao.remove(contato);
//		System.out.println("Contato removido com sucesso!!!!");
		
		//funcionario
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId((long) 1);
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		funcionarioDao.remove(funcionario);
		System.out.println("Funcionario removido com sucesso!!!!");
	}
}
