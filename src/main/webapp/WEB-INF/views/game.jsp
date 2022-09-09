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
<title>数当てゲーム</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<script src="resources/js/login.js"></script>
<script src="resources/js/messageId.js"></script>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/jquery.form.min.js"></script>
<script src="resources/js/jquery.contextMenu.min.js"></script>
<% String mem = (String)session.getAttribute("member_number");
String finish = (String)session.getAttribute(mem+"game_finish_flag");
%>	
<script type="text/javascript">
function rule() {
	var url = "rule.jsp";
	var name = "rule";
	window.open(url,name,"width=1000,height=1000,toolbar=yes,status=no,menumar=no")
}

function number_check() {
	var flg = true;
	var input_number0 = $("#input_number0").val();
	var input_number1 = $("#input_number1").val();
	var input_number2 = $("#input_number2").val();
	var input_number = input_number0 + input_number1 + input_number2;
	
	if (!(3 == input_number.length) ) {
		alert("入力数字に空白があってはなりません。");
		flg = false;
	}
	
	if (3 == input_number.length && input_number0 == input_number1 || input_number0 == input_number2 ||input_number1 == input_number2  ) {
		alert("入力数字の重複をなくしてください。");
		flg = false;
	}
	
	if (flg) {
		flg = checkIsNumber(input_number,'入力数字');
	}
	
	
	
	if (flg) {
		document.gameForm.submit();
	} else {
		return false;
	}
}

function input_info(num) {
	var en = '<%=(String)session.getAttribute(mem+"entered_number")%>';
	 
	  var enSplit = en.split('/');
     if(num <= enSplit.length){
	  return enSplit[num-1];
     } else {
    	 return "";
     }
}

function result(num, chance) {
	 var hn = '<%=(String)session.getAttribute(mem+"hidden_number")%>';
	
	 var countStrike = 0;
	 var countBall 	= 0;
	 var point = 0;
	 
	 if (chance <= 5) {
		 point = 1000;
	 } else if (chance <= 7) {
		 point = 800;
	 } else if (chance <= 10) {
		 point = 500;
	 }
	 
	 var bcnt = ball(hn, num, countBall);
	 var scnt = strike(hn, num, countStrike);
	 
	 if (scnt == 3) {
		var resultText = "当たり"	;

			alert( chance + "回に当たりになってゲームが終わりました。 ゲームの結果、" + point + "ポイントを獲得しました。");
		
	 } else if (scnt == 0 && bcnt == 0) {
		var resultText = "外れ";
	 } else if (scnt == 0 && bcnt != 0) {
		var resultText =  bcnt + "B" ; 
	 } else if (scnt != 0 && bcnt == 0) {
		var resultText =  scnt + "S" ;
	 } else {
		var resultText =  scnt + "S" + bcnt + "B" ;
	 }
	 
	 if (chance == 10 && !(scnt == 3) && num) {

			 alert("挑戦に失敗してゲームが終わりました。 ゲームの結果、ポイント獲得に失敗しました。");
		
		 
	 }  
	 
	 if(num){
		 return document.writeln(resultText); 
	 } else {
		 return "";
	 }

}

function strike(resultNum, tryNum, countStrike){ 
	for(var i=0; i<resultNum.length; i++) {
		if(resultNum.charAt(i)==tryNum.charAt(i)) {
			countStrike += 1;
		}
	}
	return countStrike;
}

function ball(resultNum, tryNum, countBall){
	for(var i=0; i<resultNum.length; i++) {
		for( var j=0; j<resultNum.length; j++) {
			if(!(i==j)){
				if(resultNum.charAt(i)==tryNum.charAt(j)) {
					countBall += 1;
				}
			}
		}
	}
	return countBall;
}

function rule() {
	location.href = "/rule"
}

function menubt() {
	location.href = "/menubt"
}


/**
 * 入力値が数字の場合trueを返却する。
 */
 function isNumber(p_id) {
	
	var chars = "0123456789";

	return containsCharsOnly2(p_id, chars);
}
 /**
  * 入力値に特定文字だけ許容したい時使う。
  */
  function containsCharsOnly2(input, chars) {
 	for (var i = 0; i < input.length; i++) {
 		if (chars.indexOf(input.charAt(i)) == -1) {
 			return false;
 		}
 	}
 	return true;
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
<body class="pt-5">

<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand centered" href="/game">数当てゲーム </a>
			
		</div>
	</nav>
<div class="container">
	<button type="submit" class="btn btn-dark "  onclick= "menubt();" style="float:left">
						メニュー</button>
										
	<span class="input-group-text" id="basic-addon1" style="float:right">現在のポイント　： ${point}　</span>
						
</div>

<div class="container h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
  <div class="col-lg-2">
    </div>
			
			<div class="col-lg-8">
			<form:form modelAttribute="GameInfoVO" name="gameForm" id="gameForm" action="game" method="post">
					<% 
					if (finish.equals("1")) {
						%>	
						<div class="input-group mt-3 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">
							今日のゲームは終了しました。 明日また来てください。
							</span>
						</div>
					</div>
					
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">入力</span>
						</div>
						<input type="text" 	id="input_number0" value="${input_number0}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number0"   maxlength="1" class="form-control" aria-label="Input number"
							aria-describedby="basic-addon1" readonly>
							<input type="text" id="input_number1"  value="${input_number1}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number1" class="form-control" maxlength="1" aria-label="Input number"
							aria-describedby="basic-addon1" readonly>
							<input type="text" id="input_number2"  value="${input_number2}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number2" class="form-control  mr-5" maxlength="1" aria-label="Input number"
							aria-describedby="basic-addon1" readonly>
							
						
						<button type="button" onclick="rule();" class="btn btn-dark ">
						ルール</button>
					</div>	
						
					<%} else { %> 
					<div class="input-group mt-3 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">隠れ数字</span>
						</div>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
						<span class="input-group-text  mr-3" id="basic-addon1">*</span>
					</div>
					
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text  mr-3" id="basic-addon1">入力</span>
						</div>
						<input type="text" 	id="input_number0" value="${input_number0}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number0"   maxlength="1" class="form-control" aria-label="Input number"
							aria-describedby="basic-addon1" required>
							<input type="text" id="input_number1"  value="${input_number1}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number1" class="form-control" maxlength="1" aria-label="Input number"
							aria-describedby="basic-addon1" required>
							<input type="text" id="input_number2"  value="${input_number2}" placeholder="0-9" oninput='handleOnInput(this, 1)' name="input_number2" class="form-control  mr-5" maxlength="1" aria-label="Input number"
							aria-describedby="basic-addon1" required>
							
							<button type="button" onclick="number_check();"  class="btn btn-dark  mr-5 ">
						確認</button>
						
						<button type="button" onclick="rule();" class="btn btn-dark ">
						ルール</button>
					</div>
					<% } %>
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
  <c:forEach var="chance" begin="1" end="10" step="1">
    <tr>
      <th scope="row">${chance}回目</th>
      <td><script>document.writeln(input_info(${chance}));</script></td>
      <td><script>result(input_info(${chance}), ${chance})</script></td>
    </tr>
    	</c:forEach>
  </tbody>
</table>
				</form:form>
			
			</div>

			<!-- 그림 넣을 그리드 -->
			 <div class="col-lg-2"></div>
		</div> 
	</div>
	

<!-- <script>
$(document).ready(function() {
	var formObj = $("form[role='form']");
	$('#ruleBtn').on("click", function() {
		var make_date = $('#make_date').val();
		window.open("/rule?make_date="+make_date,"_blank", "toolbar=yes,menubar=yes,width=700,height=500").focus();
	});
});
</script> -->
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