<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	response.setHeader("Pragma", "No-cache");

	response.setHeader("Cache-Control", "no-cache");

	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/listShow.css" />
<title>列表浏览</title>
</head>
<body>
	<ul>
		<li class="chart"><canvas id="chart"></canvas></li>
		<c:choose>
			<c:when test="${!empty plist}">
				<c:forEach items="${plist }" var="item">
			--------------------------
			
			<li class="list_item" value="${item.ver.verid }"><span
						class="title">【${item.car_home}】${item.ver.brand}${item.ver.model}${item.ver.displacement}</span>
						<span class="right">${item.cost }万/<label name="price">${item.actual_price}万</label></span><br>
						<span class="left"><fmt:formatDate
								value="${item.license_date}" type="date" dateStyle="long" />/<fmt:formatDate
								value="${item.date_reg_car}" type="date" dateStyle="long" /></span> <span
						name="mileage">${item.mileage }万公里</span><span class="right">浏览次数：<label
							id="level">${item.viewcount}</label></span></li>



				</c:forEach>
			</c:when>
			<c:otherwise>
				<li><div class="alert">没有查询到记录</div></li>
			</c:otherwise>
		</c:choose>


	</ul>

	<script src="js/sChart.js"></script>


	<script type="text/javascript">
		//为每个li添加事件touch和click事件，以verid从pro表中查询统计数据 生成data1和data2

		$(".list_item").on("click", function() {

			//data1查询当年每月销量
			//data2查询当年价格走最高价走势

			/* alert($(this).val()); */
			$.ajax({
				type : "post",
				url : "chartData.do",
				data : {
					verid : $(this).val()
				},
				dataType : "json",
				success : function(data) {
					//遍历，DOM操作生成标签

					data1 = data[0];
					data2 = data[1];
					new sChart('chart', 'bar', data2, data2, {
						autoWidth : true, // 设置宽高自适应
						showValue : false,
						fillColor : '#D93600',
						titleColor : '#D93600',
						contentColor : 'rgba(46,199,201,0.3)',
						yEqual : 7
					});
					new sChart('chart', 'line', data1, data2, {
						title : '【天津】大众 迈腾 1.8T <${sessionScope.year}年>',
						autoWidth : true, // 设置宽高自适应
						showValue : true,
						bgColor : '#ffffff',
						titleColor : '#D93600',
						fillColor : 'D93600',
						contentColor : '#D93600'
					});

				}

			});
		});

		$(function() {
			if ($(".list_item").length != 0) {
				$(".list_item:first").click();
			} else {
				var data1 = [ {
					"name" : 1,
					"value" : 0
				},{
					"name" : 2,
					"value" : 0
				}, {
					"name" : 3,
					"value" : 0
				}, {
					"name" : 4,
					"value" : 0
				}, {
					"name" : 5,
					"value" : 0
				}, {
					"name" : 6,
					"value" : 0
				}, {
					"name" : 7,
					"value" : 0
				}, {
					"name" : 8,
					"value" : 0
				}, {
					"name" : 9,
					"value" : 0
				}, {
					"name" : 10,
					"value" : 0
				}, {
					"name" : 11,
					"value" : 0
				}, {
					"name" : 12,
					"value" : 0
				}, ];
				
				var data2 = [ {
					"name" : 1,
					"value" : 0
				},{
					"name" : 2,
					"value" : 0
				}, {
					"name" : 3,
					"value" : 0
				}, {
					"name" : 4,
					"value" : 0
				}, {
					"name" : 5,
					"value" : 0
				}, {
					"name" : 6,
					"value" : 0
				}, {
					"name" : 7,
					"value" : 0
				}, {
					"name" : 8,
					"value" : 0
				}, {
					"name" : 9,
					"value" : 0
				}, {
					"name" : 10,
					"value" : 0
				}, {
					"name" : 11,
					"value" : 0
				}, {
					"name" : 12,
					"value" : 0
				}, ]


				new sChart('chart', 'line', data1, data2, {
					title : '【天津】大众 迈腾 1.8T <${sessionScope.year}年>',
					autoWidth : true, // 设置宽高自适应
					showValue : true,
					bgColor : '#ffffff',
					titleColor : '#D93600',
					fillColor : 'D93600',
					contentColor : '#D93600'
				});

			}
		});

		$(".chart").on("click", function(e) {
			e = e || event;
			var x = e.clientX - $(".chart")[0].offsetLeft;//获取点击后x的坐标
			var y = e.clientY - $(".chart")[0].offsetTop;//获取点击后y的坐标

			if (x > 550 & x < 700) {
				$.ajax({
					type : "post",
					async : false,
					url : "changeSessionYear.do",
					data : {
						pOrd : -1
					},

				})
			}
			if (x > 700 & x < 850) {
				$.ajax({
					type : "post",
					async : false,
					url : "changeSessionYear.do",
					data : {
						pOrd : 1
					},

				})
			}

			window.location.reload();

		});

		/* $('body').on('touchstart', function(e) {
			//touchstart事件
			var $tb = $(this);
			var startX = e.touches[0].clientX, //手指触碰屏幕的x坐标
			pullDeltaX = 0;
			$tb.on('touchmove', function(e) {
				//touchmove事件
				var x = e.touches[0].clientX;//手指移动后所在的坐标
				pullDeltaX = x - startX;//移动后的位移
				if (!pullDeltaX) {
					return;
				}
				e.preventDefault();//阻止手机浏览器默认事件
			});
			$tb.on('touchend', function(e) {
				//touchend事件
				$tb.off('touchmove touchend');//解除touchmove和touchend事件
				//所要执行的代码
				e.stopPropagation();

				//判断移动距离是否大于30像素
				if (pullDeltaX > 30 && that.pagerNum > 1) {

					//右滑，往前翻所执行的代码
					$.ajax({
						type : "post",
						url : "changeSessionYear.do",
						data : {
							pOrd : 1
						},

					})
				}

				//判断当前页面是否为最后一页
				else if (pullDeltaX < -30
						&& that.pagerNum < that.$boxToggle.find('i').length) {

					//左滑，往后翻所执行的代码
					
					
					$.ajax({
						type : "post",
						url : "changeSessionYear.do",
						data : {
							pOrd : -1
						},

					})
				}
			});
		}); */
	</script>

</body>

</html>