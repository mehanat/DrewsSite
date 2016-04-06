<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../../resources/styles/mainPage.css">

<script src="../../../resources/scripts/jquery-2.1.4.js"></script>
<script src="../../../resources/scripts/menuBasket.js"></script>
<div id="menuLine" class="clearfix">
  <a href="/"><img src="../../resources/images/wolf-logo.png" width="120" height="120"></a>


  <div class="menu-icon" id="about-shop"><a><img src="../../../resources/images/car.jpg" width="40"><span>ДОСТАВКА БЕСПЛАТНО <br>(ПРИ ЗАКАЗЕ ОТ 2000 РУБ.)</span></a></div>
  <div class="menu-icon" id="contacts"><a><img src="../../../resources/images/phone.png" width="40"><span>8(228)666-14-88</span></a></div>

  <div class="menu-icon">
    <a href="/basket">
      <div><img src="../../../resources/images/bin.png" width="30" height="30"></div>
      <div id="final-cost">(<span>${sessionScope.get("basket")["totalCost"]}</span> руб.)</div>
      <div id="basket-list"></div>
    </a>
  </div>
</div>
<div class="category-menu">
  <a href=""><div>ФРУКТЫ</div></a>
  <a href=""><div>ЦВЕТЫ</div></a>
  <a href=""><div>ПОСЫПКИ</div></a>
</div>