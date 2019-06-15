<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入信息</title>
<link rel="stylesheet" href="css/inputCar.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<h1>车辆信息录入</h1>
	<form action="insertPro.do" method="post">
		<div class="primary_info">
			<div>
				<label for="">车型信息</label><input type="text" id="modelInfo"
					readonly="readonly" />

				<div class="hideinput" id="modelInfoInput">
					<label for="brand">品牌</label><input type="text" name="brand" /> <label
						for="family">系列</label><input type="text" name="family" /> <label
						for="ver">版本</label><input type="text" name="ver" />
						<label
						for="ver">排量</label><input type="text" name="displacement_str" />

				</div>
			</div>
			<!-- <div>
				<label for="sellerid">卖主</label><input type="text" name="sellerid" />

			</div>
			<div class="hideinput">
				<label for="brand">姓名</label><input type="text" name="brand" />
				<label for="family">电话</label><input type="text" name="family" />

			</div> 

			<div>
				<label>牌照</label><input type="text" name="license_plate" />
			</div>-->
			<div>
				<label>属地</label><input type="text" name="car_home" />
			</div>
			<div>
				<label>上牌时间</label><input type="date" name="license_date" />
			</div>
			<div>
				<label>过户次数</label><input type="text" name="transfor_times" />
			</div>
			<div>
				<label>环保排放</label><input type="text" name="emission_level" />
			</div>
			<div>
				<label>表显里程</label><input type="text" name="mileage" />
			</div>
			<div>
				<label>成交价</label><input type="text" name="actual_price" />
			</div>
			<div>
				<label>成本价</label><input type="text" name="cost" />
			</div>
			<div>
				<label>交易状态</label><input type="text" name="status_trans" />
			</div>
			<div class="titlecondition">
				<lable>车 况：</lable>
			</div>

			<div id="condition">
				<br>
				<c:forEach items="${ccList }" var="cc">
					<span><input type="checkbox" name="car_condition_array"
						value="${cc.cond_car }" />${cc.cond_car }</span>
				</c:forEach>

			</div>

		</div>
		<div>
			<input type="submit" value="提交">
		</div>
	</form>
	
	
	<!-- 上传图上预览 -->
	
	<iframe name="uploadfrm" id="uploadfrm" style="display: none;"></iframe>  
    <form name="formHead" method="post" action="" id="formHead" enctype="multipart/form-data" target="uploadfrm">  
  
        <div>  
            <div>  
                <input type="file" name="file_head" id="file_head" onchange="javascript:setImagePreview();" />  
            </div>  
            <div>  
                <div id="DivUp" style="display: none">  
                    <input type="submit" data-inline="true" id="BtnUp" value="确认上传" data-mini="true" />  
                </div>  
            </div>  
        </div>  
    </form>  
    <div data-role="fieldcontain">  
        <div id="localImag">  
            <img id="preview" width="-1" height="-1" style="display: none" />  
        </div>  
    </div>  
	<script type="text/javascript">
		$(function() {

			$("#modelInfo").on("click", function() {
				if ($("#modelInfoInput").is(":hidden")) {
					$("#modelInfoInput").show()
				}
			})

			$(":input").on("focus", function() {
				if ($(this).parent().attr("id") != "modelInfoInput") {
					$("#modelInfoInput").hide();
				}
			});

			$(":input").on("change", function() {
				if ($(this).parent().attr("id") == "modelInfoInput") {
					var val1 = "";
					$("#modelInfoInput input").each(function() {
						val1=val1+" "+$(this).val();
					})
					$("#modelInfo").val(val1);
				}
			})

		})
		//下面是图片上传------
        function setImagePreview() {  
            var preview, img_txt, localImag, file_head = document.getElementById("file_head"),  
            picture = file_head.value;  
            if (!picture.match(/.jpg|.gif|.png|.bmp/i)) return alert("您上传的图片格式不正确，请重新选择！"),  
            !1;  
            if (preview = document.getElementById("preview"), file_head.files && file_head.files[0]) preview.style.display = "block",  
                preview.style.width = "63px",  
                preview.style.height = "63px",  
                preview.src = window.navigator.userAgent.indexOf("Chrome") >= 1 || window.navigator.userAgent.indexOf("Safari") >= 1 ? window.webkitURL.createObjectURL(file_head.files[0]) : window.URL.createObjectURL(file_head.files[0]);  
            else {  
                file_head.select(),  
                file_head.blur(),  
                img_txt = document.selection.createRange().text,  
                localImag = document.getElementById("localImag"),  
                localImag.style.width = "63px",  
                localImag.style.height = "63px";  
                try {  
                    localImag.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)",  
                    localImag.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = img_txt  
                } catch(f) {  
                    return alert("您上传的图片格式不正确，请重新选择！"),  
                    !1  
                }  
                preview.style.display = "none",  
                document.selection.empty()  
            }  
            return document.getElementById("DivUp").style.display = "block",  
            !0  
        }  

	</script>
</body>

</html>