<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Connections</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
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

<div class="container">
    <div class="row">

        <spring:url value="/connection/all" var="formUrl"/>
        <form:form modelAttribute="request" action="${formUrl}" method="post"
                   cssClass="col-md-8 col-md-offset-2">

            <div class="form-group">
                <label for="subjectDomainSelect">Select SD mass problems to parse</label>
                <select class="form-control form-control-inline" id="subjectDomainSelect" name="request">
                    <c:forEach items="${connectionDistinctList}" var="string">
                        <option><c:out value="${string}"/></option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-default">Parse</button>

        </form:form>

    </div>
</div>

</body>
</html>