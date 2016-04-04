
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../resources/styles/itemWindow.css">

<div class="item-window">
  <div class="item-info">
    <div class="item-photo">
      <img src="${item.imagePath}">
    </div>
    <div class="info">
      <div class="item-name">${item.name}</div>
      <div class="item-price">${item.cost} руб.</div>
      <div class="description">${item.description}</div>
      <div class="to-basket">
        <form>
          <button data-itemid="${item.itemId}" type="button">В КОРЗИНУ</button>
          <div class="choose-count">
            <input type="button" value="-" class="minus">
            <input id="amount" type="number" value="1" step="1" min="1" name="count" class="count">
            <input type="button" value="+" class="plus">
          </div>
        </form>
      </div>
    </div>
  </div>
  <div id="more-info">
  <div class="info-title features selected-title">
    ПОДРОБНЕЕ
  </div>
  <div class="info-title comments">
    ОТЗЫВЫ
  </div>
  <div id="info-window">
    <table>
      <tr>
        <td>Масса:</td>
        <td>${item.itemFeatures.weight} гр.</td>
      </tr>
      <tr>
        <td>Белки:</td>
        <td>${item.itemFeatures.protein} гр.</td>
      </tr>
      <tr>
        <td>Углеводы:</td>
        <td>${item.itemFeatures.carbohydrates} гр.</td>
      </tr>
      <tr>
        <td>Энергетическая ценность:</td>
        <td>${item.itemFeatures.energy_value} дж.</td>
      </tr>
      <tr>
        <td>Каллорийность:</td>
        <td>${item.itemFeatures.calories} кл.</td>
      </tr>
    </table>
  </div>
  <div id="comment-window">
    <div id="new-comment">
      <form action="/item/${item.itemId}/add-comment" method="post">
        <input id="author-name" name="name" type="text"><label for="author-name"> - ВАШЕ ИМЯ</label><br>
        <textarea id="comment-text" name="text" required></textarea><br>
        <input type="submit" value="ОТПРАВИТЬ">
      </form>
    </div>
    <div id="comments-list">
      <div class="comment">
        <p class="title"><span>Анатолий, </span><span>02.09.2012</span></p>
        <p class="text">Годный шоколад!</p>
      </div>
    </div>
  </div>

</div>
</div>

