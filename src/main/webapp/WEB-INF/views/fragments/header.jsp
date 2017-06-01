<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <ul class="nav nav-pills" role="tablist">
            <li class="active"><a href="/">Home</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    Elements <span class="caret"></span></a>

                <ul class="dropdown-menu" role="menu">
                    <li><a href="<spring:url value="/subjectDomain/all"/>">Subject Domains</a></li>
                    <li><a href="<spring:url value="/subjectDomainState/all"/>">Subject Domain States</a></li>
                    <li><a href="<spring:url value="/object/all"/>">Objects</a></li>
                    <li><a href="<spring:url value="/objectInstance/all"/>">Object Instances</a></li>
                    <li><a href="<spring:url value="/objectList/all"/>">Object Lists</a></li>
                    <li><a href="<spring:url value="/objectState/all"/>">Object States</a></li>
                    <li><a href="<spring:url value="/objectInstanceList/all"/>">Object Instance List</a></li>
                    <li><a href="<spring:url value="/connection/all"/>">Connections</a></li>
                    <li><a href="<spring:url value="/connectionState/all"/>">Connection States</a></li>
                    <li><a href="<spring:url value="/connectionInstance/all"/>">Connection Instances</a></li>
                    <li><a href="<spring:url value="/massProblem/all"/>">Mass Problems</a></li>
                    <li><a href="<spring:url value="/attribute/all"/>">Attributes</a></li>
                    <li><a href="<spring:url value="/attributeValue/all"/>">Attribute Values</a></li>
                    <li><a href="<spring:url value="/parameter/all"/>">Parameters</a></li>
                    <li><a href="<spring:url value="/individualTask/all"/>">Individual Tasks</a></li>
                    <li><a href="<spring:url value="/parameterValue/all"/>">Parameter Values</a></li>
                </ul>

            </li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    XML Upload <span class="caret"></span></a>

                <ul class="dropdown-menu" role="menu">
                    <li><a href="<spring:url value="/file/fileUpload"/>">Upload Functions Text File</a></li>
                </ul>

            </li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    Statistic <span class="caret"></span></a>

                <ul class="dropdown-menu" role="menu">
                    <li><a href="<spring:url value="/stat/all"/>">Show statistic</a></li>
                </ul>

            </li>

        </ul>

    </div>
</nav>