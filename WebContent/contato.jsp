<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contato</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<form action="mvc?logica=AlteraContatoLogic&id=${contato.id }" method="post">
			<label>Nome</label><input type="text" value="${contato.nome }" name="nome"><br/>
			<label>Email</label><input type="text" value="${contato.email }" name="email"><br/>
			<label>Endereço</label><input type="text" value="${contato.endereco }" name="endereco"><br/>
			<label>Data de Nascimento</label><input type="text" value='<fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy"/>' name="dataNascimento"><br/>
			<input type="submit" value="Alterar">
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>