<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Connection Instances</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="container">

    <h2>Connection Instances</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Connection Instance Id</th><th>Connection Id</th><th>Connection Instance Name</th>
        </tr>
        <c:forEach items="${connectionInstanceList}" var="connectionInstance">
            <tr>
                <td><a href="${connectionInstance.id}"/> <c:out value="${connectionInstance.id}" /></td>
                <td><a href="<spring:url value="/connection/${connectionInstance.connectionId}"/>"><c:out value="${connectionInstance.connectionId}" /></a></td>
                <td><c:out value="${connectionInstance.name}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>