<%--
  Created by IntelliJ IDEA.
  User: bogdan
  Date: 1/6/2017
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>mylie home</title>

    <%@include file="/WEB-INF/parts/links.jsp"%>

</head>
<body  ng-app="homeApp" ng-controller="HomeController">

<%@include file="navbar.jsp"%>

<div layout="row" style="background-color: white">
<%@include file="sidenav.jsp"%>

    <div ng-show="getTab('events_page')" class="container" ng-cloak flex>
        <%@include file="ivents.jsp"%>
    </div>
    <div ng-show="getTab('about_page')" class="container" ng-cloak flex>
        <%@include file="about.jsp"%>
    </div>
</div>
</body>

</html>