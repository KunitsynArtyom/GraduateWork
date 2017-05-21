<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Subject Domain States</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="container">

    <h2>Subject Domain States</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Subject Domain State Id</th><th>Subject Domain Id</th><th>Time Stamp</th>
        </tr>
        <c:forEach items="${subjectDomainStateList}" var="subjectDomainState">
            <tr>
                <td><a href="${subjectDomainState.id}"/> <c:out value="${subjectDomainState.id}" /></td>
                <td><a href="<spring:url value="/subjectDomain/${subjectDomainState.subjectDomainId}"/>"><c:out value="${subjectDomainState.subjectDomainId}" /></a></td>
                <td><c:out value="${subjectDomainState.timeStamp}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</body>
</html>