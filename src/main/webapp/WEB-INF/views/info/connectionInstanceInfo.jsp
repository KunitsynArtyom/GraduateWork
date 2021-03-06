<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Connection Instance Info</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
    <h1>Info</h1>
    <div class="list-group">
        <a href="#" class="list-group-item active">
            <h4 class="list-group-item-heading">Type</h4>
            <h2 class="list-group-item-text">Connection Instance</h2>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Connection Instance ID</h4>
            <p class="list-group-item-text">${connectionInstance.id}</p>
        </a>
        <a href="/connection/${connectionInstance.connectionId}" class="list-group-item">
            <h4 class="list-group-item-heading">Connection ID</h4>
            <p class="list-group-item-text">${connectionInstance.connectionId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Connection Instance Name</h4>
            <p class="list-group-item-text">${connectionInstance.name}</p>
        </a>
    </div>
</div>