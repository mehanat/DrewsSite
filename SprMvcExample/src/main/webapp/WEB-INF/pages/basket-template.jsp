<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 21.11.2015
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="../../resources/styles/mainTheme.css">
  <link rel="stylesheet" href="../../resources/styles/itemWindow.css">
  <script src="../../resources/scripts/jquery-2.1.4.js"></script>
  <script src="../../resources/scripts/basketPage.js"></script>
</head>
<body>
<div class="main">
  <div id="mainWrap">
    <tiles:insertAttribute name="menuBar"/>
    <tiles:insertAttribute name="basket-content"/>
  </div>
</div>
</body>
</html>
