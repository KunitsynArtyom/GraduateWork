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
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="container">

    <h2>Parameters</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Parameter Id</th><th>Mass Problem Id</th><th>Parameter Name</th>
        </tr>
        <c:forEach items="${parameterList}" var="parameter">
            <tr>
                <td><a href="${parameter.id}"/> <c:out value="${parameter.id}" /></td>
                <td><a href="<spring:url value="/massProblem/${parameter.massProblemId}"/>"><c:out value="${parameter.massProblemId}" /></a></td>
                <td><c:out value="${parameter.name}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>