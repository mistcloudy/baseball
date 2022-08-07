<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>数当てゲーム</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="pt-5">

<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand centered" href="/etc">数当てゲーム</a>
			
		</div>
	</nav>
<div class="container">
	<button type="submit" class="btn btn-dark " style="float:left">
						メニュー</button>
										
	<span class="input-group-text" id="basic-addon1" style="float:right">現在のポイント　：　</span>
						
</div>

<div class="container h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
  <div class="col-lg-2">
    </div>
			
			<div class="col-lg-8">
				<form action="loginAsk" method="post">
					<!-- ID입력 -->
					<div class="input-group mt-3 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">隠れ数字</span>
						</div>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
					</div>
					<!-- PW입력 -->
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">入力</span>
						</div>
						<input type="password" name="userPW" class="form-control" aria-label="Input Password"
							aria-describedby="basic-addon1" required>
							<input type="password" name="userPW" class="form-control" aria-label="Input Password"
							aria-describedby="basic-addon1" required>
							<input type="password" name="userPW" class="form-control  mr-5" aria-label="Input Password"
							aria-describedby="basic-addon1" required>
							
							<button type="submit" class="btn btn-dark  mr-5 ">
						確認</button>
						
						<button type="submit" class="btn btn-dark ">
						ルール</button>
					</div>
					<!-- 로그인 버튼 -->
					<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">入力回数</th>
      <th scope="col">入力情報</th>
      <th scope="col">判定結果</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">２回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">3回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
       <th scope="row">4回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">5回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
        <th scope="row">6回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
        <th scope="row">7回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
       <th scope="row">8回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">9回目</th>
      <td></td>
      <td></td>
    </tr>
    <tr>
        <th scope="row">10回目</th>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>
				</form>
			
			</div>

			<!-- 그림 넣을 그리드 -->
			 <div class="col-lg-2"></div>
		</div> 
	</div>
	


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<style type="text/css">
html,body {
  height: 100%;
}

.centered {
        left: 50%; 
        margin-left: 420px;
      }
</style>
</body>
</html>