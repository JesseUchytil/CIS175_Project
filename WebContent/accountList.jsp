<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "editAccountServlet">
	<table>
	<c:forEach items="${requestScope.allAccounts}" var = "currentAccount">
		<tr>
			<td><input type = "radio" name="id" value="${currentAccount.id}"></td>
			<td>${currentAccount.account_name}</td>
			<td>${currentAccount.account_balance}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Edit Selected Account" name = "doThisToAccount">
	<input type = "submit" value = "Delete Selected Account" name = "doThisToAccount">
	<input type = "submit" value = "Add New Account" name = "doThisToAccount">
	</form>
</body>
</html>