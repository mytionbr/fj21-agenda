
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<html>
<head>
	<link href="jquery-ui-1.12.1.custom/jquery-ui.css" rel="stylesheet">
	<script src="jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
</head>
<body>
<body>
	<c:import url="cabecalho.jsp" />
	<h1>Adiciona Contatos</h1>
	<hr />
	<form action="adicionaContato">
		<label>Nome: </label><input type="text" name="nome" /><br />
	    <label>E-mail:</label><input type="text" name="email" /><br /> 
	    <label>Endereço: </label> <input type="text" name="endereco" /><br /> 
	    <label>Data	Nascimento: </label> <caelum:campoData id="dataNascimentos"/><br /> 
	    <input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>