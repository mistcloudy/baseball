<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>ルール</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script> -->
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script src="resources/js/login.js"></script>
<script src="resources/js/messageId.js"></script>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/jquery.form.min.js"></script>
<script src="resources/js/jquery.contextMenu.min.js"></script>
<script type="text/javascript">

function main_return(){
	
	location.href = "/game"
	
}

</script>
</head>

<body class="pt-5">

<div class = "container">
	<h2>ルール</h2>
	<br> 隠された数字3つを当てるゲーム
	<br> 1日1回挑戦ができ、1ゲームにつき10回のチャンス。
	<br><br><h5>入力した数字の判定結果</h5>
	<br> すべて間違えた場合 → 外れ
	<br> すべて合った場合 → 当たり
	<br> 数字は合っているが位置が違う場合 → B (Ball)
	<br> 数字も位置も合っている場合 → S (Strike))
	
	<br><br>
	
	<div id = "gameEx">
	隠れ数字：123
	<br>
	<table class = "table table-bordered">
		<thead >
			<td >入力回数</td>
			<td>入力</td>
			<td>判定</td>
			
		</thead>
		<tbody>
		<tr>
			<td>1回目</td>
			<td>4  --   5  --   6
			<br>(X)  (X)  (X)</td>
			<td>外れ</td>
			
		</tr>
		<tr>
			<td>2回目</td>
			<td>4  --   5  --   1
			<br>(X)  (X)  (B)</td>
			<td>1B</td>
			
		</tr>
		<tr>
			<td>3回目</td>
			<td>1  --   3  --   6
			<br>(S)  (B)  (X)</td>
			<td>1S1B</td>
			
		</tr>
		<tr>
			<td>4回目</td>
			<td>1  --   3  --   2
			<br>(S)  (B)  (B)</td>
			<td>1S2B</td>
			
		</tr>
		<tr>
			<td>5回目</td>
			<td>1  --   2  --   3
			<br>(S)  (S)  (S)</td>
			<td>当たり</td>
			
		</tr>
		</tbody>
	</table>
</div>
<br><h5>ポイント支給</h5>
入力回数 : 1回目～5回目 = 1,000ポイント
<br>入力回数 : 6回目～7回目 = 800ポイント
<br>入力回数 : 8回目～10回目 = 500ポイント


<br><br>
<button id = "btn_return" onclick = "main_return();" class = "btn btn-outline-secondary">戻る</button>
</div>




<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<style type="text/css">

.container{
	width : 70%;
	margin : auto;
	background-color: #f9f9f9;
	border: 1px solid gray;
	border-radius: 4px;
	padding : 10px;
}

#gameEx{
	margin:auto;
}


#btn_return{
display: block; 
 margin : auto;
 width : 300px
}


</style>
</body>
</html>