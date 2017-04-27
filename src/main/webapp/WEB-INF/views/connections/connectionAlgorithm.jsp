<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Google Chart - Servlet 3</title>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>

    <h2>CreateProbability</h2>
    <table class="table table-hover">
<body>
<tr>
    <th>Mass Problem</th><th>Connection</th><th>Value</th>
</tr>
<c:forEach items="${map}" var="entry">
    <c:forEach items="${entry.value}" var="innerEntry">
        <tr>
            <td> <c:out value="${entry.key}" /></td>
            <td><c:out value="${innerEntry.key}" /></td>
            <td><c:out value="${innerEntry.value}" /></td>
        </tr>
    </c:forEach>
</c:forEach>
</body>
</table>


<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawStuff);

    function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
            ['', 'Measure:'],

            <c:forEach items="${createProbabilityMap}" var="entry">
                <c:forEach items="${entry.value}" var="innerEntry">
                ['${entry.key} ${innerEntry.key}', ${innerEntry.value}],
                </c:forEach>
            </c:forEach>
        ]);

        var options = {
            title: '',
            width: 900,
            legend: { position: 'none' },
            chart: { title: 'Attribute Measures:',
                subtitle: '' },
            bars: 'horizontal',
            axes: {
                x: {
                    0: { side: 'top', label: ''}
                }
            },
            bar: { groupWidth: "90%" }
        };

        var chart = new google.charts.Bar(document.getElementById('top_x_div'));
        chart.draw(data, options);
    };
</script>


<body>
<div id="top_x_div" style="width: 900px; height: 500px;"></div>
</body>

</head>
</body>
</html>