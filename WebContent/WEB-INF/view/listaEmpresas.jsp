<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas - Java Standard Taglib </title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>

    Usuario Logado: ${usuarioLogado.login }

    <br>
    <br>
    <br>
    <c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>

    Lista de empresas: <br />

    <ul>
        <c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> 
					<a href="entrada?acao=MostraEmpresa&id=${empresa.id}"> editar </a>&nbsp;
					<a href="entrada?acao=RemoveEmpresa&id=${empresa.id}"> remover </a>
			</li>
		</c:forEach>
    </ul>
    <br>
	<a href="entrada?acao=NovaEmpresaForm"> - Nova -</a>
</body>
</html>