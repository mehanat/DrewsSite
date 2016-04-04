<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<script src="../../resources/scripts/assortPage.js"></script>
<script src="../../resources/scripts/ajaxItemView.js"></script>

<div id="itemsWrap">
  <div id="sorting">
  <form action="/assortment-types/${category}" method="get">
    <select id="sort-select" name="sortMethod">
      <option value="name">имени</option>
      <option value="price-incr">цене-возрастающей</option>
      <option value="price-decr">цене-убывающей</option>
    </select>
  </form>
  <p>Сортировать по:</p>
</div>
  <ul>
  <c:forEach items="${items}" var="item">
    <li>
    <div class="div-item">
      <div class="item">
        <a href="/item/${item.itemId}">
          <img src="${item["imagePath"]}">
        </a>
        <div class="slider">
          <p ref="/getItem/${item['itemId']}">ПРОСМОТР</p>
        </div>
      </div>
      <div class="itemInfo">
        <div class="itemPrize">${item["cost"]}</div>
        <div class="itemName">${item["name"]}</div>
      </div>
    </div>
    </li>
  </c:forEach>
  </ul>
</div>