<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Stat</title>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <%--<script type="text/javascript">--%>
        <%--google.load('visualization', '1.0', {--%>
            <%--'packages' : [ 'corechart' ]--%>
        <%--});--%>

        <%--google.setOnLoadCallback(drawChart);--%>

        <%--function drawChart() {--%>

            <%--var data = google.visualization.arrayToDataTable([--%>
                <%--['Object', 'Count'],--%>
                <%--<c:forEach items="${pieDataList}" var="entry">--%>
                    <%--[ '${entry.key}', ${entry.value} ],--%>
                <%--</c:forEach>--%>
            <%--]);--%>

            <%--var options = {--%>
                <%--'title' : '',--%>
                <%--is3D : true,--%>
                <%--pieSliceText: 'label',--%>
                <%--tooltip :  {showColorCode: true},--%>
                <%--'width' : 900,--%>
                <%--'height' : 500--%>
            <%--};--%>

            <%--var chart = new google.visualization.PieChart(document.getElementById('chart_div'));--%>
            <%--chart.draw(data, options);--%>
        <%--}--%>
    <%--</script>--%>
</head>

<jsp:include page="../fragments/header.jsp"></jsp:include>

<%--<body>--%>
<%--<div style="width: 600px;">--%>
    <%--<div id="chart_div"></div>--%>
<%--</div>--%>
<%--</body>--%>
<div class="container">

    <h2>Defining Attribute Algorithm Statistic</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Attribute</th><th>Value</th>
        </tr>
        <c:forEach items="${definingAttributesStatList}" var="definingAttributeStat">
            <tr>
                <td><c:out value="${definingAttributeStat.getStatName()}" /></td>
                <td><c:out value="${definingAttributeStat.getStatValue()}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>

<div class="container">

    <h2>Connection Algorithm Statistic</h2>
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Attribute</th><th>Value</th><th>Connection Stat Type</th>
        </tr>
        <c:forEach items="${connectionsStatList}" var="connectionStat">
            <tr>
                <td><c:out value="${connectionStat.getStatName()}" /></td>
                <td><c:out value="${connectionStat.getStatValue()}" /></td>
                <td><c:out value="${connectionStat.getAdditionalInfo()}" /></td>
            </tr>
        </c:forEach>
        </body>
    </table>

</div>
</html>