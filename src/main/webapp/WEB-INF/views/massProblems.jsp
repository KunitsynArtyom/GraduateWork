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

    <h2>Mass Problems</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Mass Problem Id</th><th>Subject Domain Id</th><th>Mass Problem Name</th>
        </tr>
        <c:forEach items="${massProblemList}" var="massProblem">
            <tr>
                <td><a href="${massProblem.id}"/> <c:out value="${massProblem.id}" /></td>
                <td><a href="<spring:url value="/subjectDomain/${massProblem.subjectDomainId}"/>"><c:out value="${massProblem.subjectDomainId}" /></a></td>
                <td><c:out value="${massProblem.name}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>