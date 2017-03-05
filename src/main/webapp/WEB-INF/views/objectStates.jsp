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

    <h2>Object States</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Object Instance Id</th><th>Attribute Value Id</th><th>Subject Domain State Id</th>
        </tr>
        <c:forEach items="${objectStateList}" var="objectState">
            <tr>
                <td><a href="${objectState.objectInstanceId}"/> <c:out value="${objectState.objectInstanceId}" /></td>
                <td><a href="${objectState.attributeValueId}"/> <c:out value="${objectState.attributeValueId}" /></td>
                <td><a href="${objectState.subjectDonainStateId}"/> <c:out value="${objectState.subjectDonainStateId}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>