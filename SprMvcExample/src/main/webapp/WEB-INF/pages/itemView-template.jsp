<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 16.11.2015
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="../../resources/styles/mainTheme.css">
  <link rel="stylesheet" href="../../resources/styles/assortPage.css">
  <script src="../../resources/scripts/jquery-2.1.4.js"></script>
  <script src="../../resources/scripts/itemPage.js"></script>
</head>
<body>
<div class="main">

  <div id="mainWrap" class="clearfix">
    <tiles:insertAttribute name="menuBar"/>
    <tiles:insertAttribute name="assortmenttList"/>
    <tiles:insertAttribute name="itemWindow" />
  </div>
</div>
</body>
</html>
