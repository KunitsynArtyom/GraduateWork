<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Subject Domains</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="container">
    <h2>Connections</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Connection Id</th><th>Subject Domain Id</th><th>Connection Name</th>
        </tr>
        <c:forEach items="${connectionList}" var="connection">
            <tr>
                <td><a href="${connection.id}"/> <c:out value="${connection.id}" /></td>
                <td><a href="<spring:url value="/subjectDomain/${connection.subjectDomainId}"/>"><c:out value="${connection.subjectDomainId}" /></a></td>
                <td><c:out value="${connection.name}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>