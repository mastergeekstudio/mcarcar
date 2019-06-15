<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<title>home</title>
</head>

<body>
	<div id="menu">
		<ul>
			<li>品牌</li>
			<li>价格</li>
			<li>级别</li>
			<li>筛选</li>
		</ul>
	</div>



	<div id="main">
		<!-- <div class="item">
				<img class="carImg" src="carimg/1.jpg" />
				<ul>
					<li>
						<h3>奔驰GLK级2012款GLK300 4MATIC动感型</h3>
					</li>
					<li>六速手自一体/ 2012 / 欧<span class="car_home">天津</span></li>
					<li>6.4万公里</li>
					<li><span class="price">7.05 万</span><span class="count">浏览
							：180次</span></li>

				</ul>
			</div> -->


		<c:forEach items="${clist }" var="item">
			<div class="item">
				<img class="carImg" src="carimg/${item.coverimg}" />
				<ul>
					<li>
						<h3>${item.ver.brand}${item.ver.model}</h3>
					</li>
					<li>${item.ver.gearbox }/${item.ver.ver }/${item.emission_level}<span
						class="car_home">${item.car_home}</span></li>
					<li>${item.mileage }万公里</li>
					<li><span class="price">${item.price } 万</span><span
						class="count">浏览 ：${item.viewcount }次</span></li>

				</ul>
			</div>
		</c:forEach>


		<div class="add_button_left">
			<a href="inputPro.do">+</a>
		</div>
		<div class="add_button_right">
			<a href="inputPro.do">+</a>
		</div>
		
	</div>
	
<button  class="tempdiv"><a href="listShow.do">测试临时跳转按钮</a></button>
</body>

	
</html>