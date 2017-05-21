<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Connection States</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="container">

    <h2>Connection States</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Connection State Id</th><th>Subject Domain State Id</th><th>Connection Instance Id</th><th>Connection State Name</th>
        </tr>
        <c:forEach items="${connectionStateList}" var="connectionState">
            <tr>
                <td><a href="${connectionState.id}"/> <c:out value="${connectionState.id}" /></td>
                <td><a href="<spring:url value="/subjectDomainState/${connectionState.subjectDomainStateId}"/>"><c:out value="${connectionState.subjectDomainStateId}" /></a></td>
                <td><c:out value="${connectionState.connectionInstanceId}" /></td>
                <td><c:out value="${connectionState.name}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>