
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 09.11.2015
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>



<html>
<head>
  <meta charset="UTF-8">
  <title>mainPage</title>
  <link rel="stylesheet" href="../../resources/styles/mainTheme.css"/>
  <link rel="stylesheet" href="../../resources/styles/mainPage.css"/>
  <link rel="stylesheet" href="../../resources/styles/assortPage.css"/>
  <link rel="stylesheet" href="../../resources/styles/items.css"/>
  <link rel="stylesheet" href="../../resources/styles/itemWindow.css">

  <script src="../../resources/scripts/jquery-2.1.4.js"></script>
  <script src="../../resources/scripts/mainPage.js"></script>
  <script src="../../resources/scripts/ajaxItemView.js"></script>
  <script src="../../resources/scripts/assortPage.js"></script>


</head>
<body>
<div id="blackout"></div>

<div class="main">
  <div id="mainWrap">
    <tiles:insertAttribute name="menu-bar"/>
    <tiles:insertAttribute name="home-content"/>
  </div>
</div>
<div id="item-preview"></div>
</body>
</html>