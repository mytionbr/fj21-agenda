<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<h2>${mensagem }</h2>

	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td><c:choose>
						<c:when test="${ not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							Email não foi cadastrado!
						</c:otherwise>
					</c:choose></td>
				<td><c:if test="${ not empty contato.endereco}">
						${contato.endereco}
					</c:if> <c:if test="${ empty contato.endereco}">
						Endereço não cadastrado!
					</c:if></td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
				<td><a href="mvc?logica=ContatoLogic&id=${contato.id}">Alterar</a>
				</td>
			</tr>

		</c:forEach>
	</table>
	<h3><a href="mvc?logica=ContatoLogic">Adicione um novo contato</a> </h3>
	<c:import url="rodape.jsp" />
</body>
</html>