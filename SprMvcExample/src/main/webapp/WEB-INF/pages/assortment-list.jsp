
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="../../resources/scripts/assortListSpacing.js"></script>
<script src="../../resources/scripts/assortListChoosingOption.js"></script>

<div id="categoriesList">

  <form>
  <div>ФИЛЬТР ШОКОЛАДА</div>
  <div class="kind-wrap" id="1">
    <div class="kind">ЦВЕТ ШОКОЛАДА:</div>
      <input name="color" type="radio" class="selected-type" id="all-col"><label for="all-col"><div>-ВСЕ-<div>(${countByType["type"]})</div></div></label>
      <input name="color" type="radio" id="white"><label for="white"><div>БЕЛЫЙ<div>(0)</div></div></label>
      <input name="color" type="radio" id="milk"><label for="milk"><div>МОЛОЧНЫЙ<div>(0)</div></div></label>
      <input name="color" type="radio" id="dark"><label for="dark"><div>ТЁМНЫЙ<div>(0)</div></div></label>
  </div>
  <div class="kind-wrap" id="2">
  <div class="kind">ТИП НАЧИНКИ:</div>
    <input name="filling" type="radio" id="all-in"><label  for="all-in"><div>-ВСЕ-<div>(${countByType["type"]})</div></div></label>
    <input name="filling" type="radio" id="fruit"><label for="fruit"><div>ФРУКТЫ<div>(0)</div></div></label>
    <input name="filling" type="radio" id="flower"><label for="flower"><div>ЦВЕТЫ<div>(0)</div></div></label>
    <input name="filling" type="radio" id="topping"><label for="topping"><div>ПОСЫПКИ<div>(0)</div></div></label>
  </div>
  </form>
</div>
