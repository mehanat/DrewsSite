<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 10.11.2015
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel="stylesheet" href="../../resources/styles/mainTheme.css">
  <link rel="stylesheet" href="../../resources/styles/assortPage.css">

</head>
<body>
<div class="main" >
  <div id="mainWrap" class="clearfix">
      <tiles:insertAttribute name="menuBar"/>
    <div id="assortment">
      <tiles:insertAttribute name="assortmentList"/>
      <tiles:insertAttribute name="assortmentTypes"/>

    </div>
  </div>
</div>
</body>
</html>
