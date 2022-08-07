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
<title>会員認証</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="pt-5">

<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand centered" href="/etc">数当てゲーム</a>
			
		</div>
	</nav>


<div class="container h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
  <div class="col-lg-2">
    </div>
			
			<div class="col-lg-8">
				<form action="loginAsk" method="post">
				<!-- ID입력 -->
					<div class="input-group mt-3 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">　会員　ID</span>
						</div>
						<input type="text" name="userID" class="form-control"
							placeholder="ID入力" aria-label="Input ID"
							aria-describedby="basic-addon1" required>
					</div>
					<!-- PW입력 -->
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">パスワード</span>
						</div>
						<input type="password" name="userID" class="form-control"
							placeholder="パスワード入力" aria-label="Input Password"
							aria-describedby="basic-addon1" required>
					</div>
				
					<button type="submit" class="btn btn-dark btn-sm btn-block">
						ログイン</button>
						
					<div class="alert alert-danger text-center" role="alert">エラーメッセージ</div>		
						
			
				
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