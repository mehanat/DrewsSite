<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="midLine">
	<div id="botLine">
		<div class="photo-category">
			<a href="">
				<div class="white-layer"></div>
				<div class="category-name"><p>ТЕМНЫЙ ШОКОЛАД</p></div>
			</a>
		</div>
		<div class="photo-category">
			<a href="">
			<div class="white-layer"></div>
			<div class="category-name"><p>МОЛОЧНЫЙ ШОКОЛАД</p></div>
			</a>
		</div>
		<div class="photo-category">
			<a href="">
			<div class="white-layer"></div>
			<div class="category-name"><p>БЕЛЫЙ ШОКОЛАД</p></div>
			</a>
		</div>
	</div>
	<div id="photos">

		<div id="switches">
		</div>
	</div>

</div>



<p class="sub-title">АССОРТИМЕНТ:</p>
<ul>
	<c:forEach items="${items}" var="item">
	<li>
		<div class="div-item">
			<div class="item">
				<a href="/item/${item.itemId}">
					<img src="${item.imagePath}">
				</a>
				<div class="slider">
					<p ref="/getItem/${item.itemId}">ПРОСМОТР</p>
				</div>
			</div>
			<div class="itemInfo">
				<div class="itemPrize">${item.cost} руб.</div>
				<div class="itemName">${item.name}</div>
			</div>
		</div>
	</li>
	</c:forEach>
</ul>



