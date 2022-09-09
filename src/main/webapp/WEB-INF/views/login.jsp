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
<title>会員認証</title>
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

function submitForm() {
	var submitFlg = true;
	submitFlg = checkIsNull('member_number','ID');
	
	console.log(submitFlg);
	
	if(submitFlg) {
		submitFlg = checkIsNumber('member_number','ID');	
	}
	
	console.log(submitFlg);
	
	if(submitFlg) {
		submitFlg = checkIsNull('member_password','パスワード');
	}

	
	if(submitFlg) {
		submitFlg = checkIsAlphaNum('member_password');	
	}
	
	if(submitFlg) {
		submitFlg = checkCharLength('member_number', '6', '6', 'ID');
	}
	
	if(submitFlg) {
		submitFlg = checkCharLength('member_password', '4', '20', 'パスワード');
	}
	
	if (submitFlg) {
		document.loginForm.submit();
		
	} else {
		return false;
	}
}



/**
 * 入力値が数字の場合trueを返却する。
 */
 function isNumber(p_id) {
	var input = document.getElementById(p_id);
	var chars = "0123456789";

	return containsCharsOnly(input, chars);
}

/**
 * 入力値が数字かチェックする。
 */
 function checkIsNumber(p_id, label) {
	var msgStr = [ label ];

	if (!isNumber(p_id)) {
		sendMessage("KS_FMSYS_ERRMSG_004_JS", msgStr);
		setFocus(p_id);
		return false;
	} else {
		return true;
	}
}
</script>	
</head>

<body class="pt-5">

<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand centered" href="/login">数当てゲーム</a>
			
		</div>
	</nav>


<div class="container h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
  <div class="col-lg-2">
    </div>
			
			<div class="col-lg-8">
					<form:form modelAttribute="LoginInputDto" name="loginForm" action="login" method="post" onsubmit="return false;">
				<!-- ID입력 -->
					<div class="input-group mt-3 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">　会員　ID</span>
						</div>
						<input type="text" id="member_number" name="member_number" maxlength="6" class="form-control"
							placeholder="ID入力" aria-label="Input ID"
							aria-describedby="basic-addon1" required>
					</div>
					<!-- PW입력 -->
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">パスワード </span>
						</div>
						<input type="password" id="member_password"
					name="member_password"  maxlength="20" class="form-control"
							placeholder="パスワード入力" aria-label="Input Password"
							aria-describedby="basic-addon1" required>
					</div>
				
					<button id="loginBtn" onclick="submitForm()" type="button" class="btn btn-dark btn-sm btn-block" >
						ログイン</button>
						<c:if test= "${not empty exception.message}">   
						<div id="msgArea" class="alert alert-danger text-center" role="alert">${exception.message}</div>
						 
						 </c:if>

					 		
						
			</form:form>
				
			</div>

			<!-- 그림 넣을 그리드 -->
			 <div class="col-lg-2"></div>
		</div> 
	</div>
	



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