<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../resources/styles/basketPage.css">


<div id="basket" class="clearfix">
  <h1>Корзина:</h1>
  <c:choose>
  <c:when test="${basket.items.size()>0}">
  <table>
    <tr>
      <td>ТОВАР</td>
      <td>ЦЕНА</td>
      <td>КОЛИЧЕСТВО</td>
      <td>ИТОГ</td>
    </tr>
    <c:forEach items="${basket['items']}" var="entry">
    <tr>
      <td>
        <div class="delete"><img src="../../resources/images/gtk-close.png" width="20" height="20" data-itemid="${entry.key['itemId']}"></div>
        <div><img src="${entry.key['imagePath']}" width="94" height="117"></div>
        <div class="name">${entry.key['name']}</div>
      </td>
      <td class="price-per-one">${entry.key['cost']} руб.</td>
      <td>
        <div class="choose-count">
          <input type="button" value="-" class="minus" data-itemid="${entry.key['itemId']}">
          <input type="number" value="${entry.value['amount']}" step="1" min="1" name="count" class="count">
          <input type="button" value="+" class="plus" data-itemid="${entry.key['itemId']}">
        </div>
      </td>
      <td class="price-per-stack" data-itemid="${entry.key['itemId']}">${entry.value['stackPrice']}</td>
    </tr>
    </c:forEach>
    </c:when>
    <c:otherwise>
      <h2>КОРЗИНА ПУСТА</h2>
    </c:otherwise>
    </c:choose>
  </table>


</div>
<div id="order-form">
  <form method="post" action="/basket/new-order">
    <p>Имя получателя: </p><input type="text" name="name">
    <p>Способ доставки: </p>
    <input type="radio" name="deliveryType" value="self"> Самовывоз <br>
    <input type="radio" name="deliveryType" value="deliver"> Доставка
    <p>Комментарии к заказу: </p><textarea name="comments" rows="8" cols="35"></textarea>
    <p><input type="submit" value="ЗАКАЗАТЬ"></p>
  </form>
</div>
