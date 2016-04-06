<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 11.11.2015
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../../resources/styles/mainTheme.css">
    <link rel="stylesheet" href="../../resources/styles/assortPage.css">
    <link rel="stylesheet" href="../../resources/styles/items.css">
    <link rel="stylesheet" href="../../resources/styles/itemWindow.css">
</head>
<body>
<div id="blackout"></div>
<div class="main">

<div id="mainWrap" class="clearfix">
    <tiles:insertAttribute name="menuBar"/>
    <%--<tiles:insertAttribute name="assortmenttList"/>--%>
    <tiles:insertAttribute name="assortment" />
</div>
</div>
<div id="item-preview"></div>
</body>
</html>
