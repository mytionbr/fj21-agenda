package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaInsere {
	
	public static void main(String[] args) {
		Contato	contato	=	new	Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R.	Vergueiro	3185	cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Contato gravado");
	// funcionario	
		Funcionario	funcionario	=	new	Funcionario();
		funcionario.setNome("Luan");
		funcionario.setUsuario("Luan2019");
		funcionario.setSenha("123");
		
		
		FuncionarioDAO daoFuncinario = new FuncionarioDAO();
		
		daoFuncinario.adiciona(funcionario);
		
		System.out.println("Funcionario gravado");
	}
}
