package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaLista {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de nascimeto: " + contato.getDataNascimento().getTime());
		}

		// funcionario

		FuncionarioDAO daoFuncionario = new FuncionarioDAO();

		List<Funcionario> funcionarios = daoFuncionario.getLista();
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Usuário: " + funcionario.getUsuario());
			System.out.println("Senha: " + funcionario.getSenha());
			System.out.println("ID: " + funcionario.getId());
		}
	}
}
