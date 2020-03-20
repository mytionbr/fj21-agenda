
<%@page import="java.text.SimpleDateFormat"%>
<%@	page
	import="java.util.*,
		br.com.caelum.jdbc.dao.*,
		br.com.caelum.jdbc.modelo.*"%>

<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<table>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			Calendar dataNascimento = Calendar.getInstance();
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
			
			%>
			
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereço</td>
				<td>Data de Nascimento</td>
			</tr>
			<%
			for (Contato contato : contatos) {
				dataNascimento.setTime(contato.getDataNascimento().getTime());
				String data = dataFormatada.format(dataNascimento.getTime());
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=data%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>