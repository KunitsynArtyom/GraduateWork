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

    <h2>Parameter Values</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Parameter Value Id</th><th>Individual Task Id</th><th>Parameter Id</th><th>Parameter Value</th>
        </tr>
        <c:forEach items="${parameterValueList}" var="parameterValue">
            <tr>
                <td><a href="${parameterValue.id}"/> <c:out value="${parameterValue.id}" /></td>
<%--                <td><a href="<spring:url value="/massProblem/${parameter.massProblemId}"/>"><c:out value="${parameter.massProblemId}" /></a></td>--%>
                <td><c:out value="${parameterValue.individualTaskId}" /></td>
                <td><c:out value="${parameterValue.parameterId}" /></td>
                <td><c:out value="${parameterValue.parameterValue}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>