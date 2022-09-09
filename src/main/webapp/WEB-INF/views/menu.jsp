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
<title>メニュー</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<% String mem = (String)session.getAttribute("member_number");%>
<script type="text/javascript">
function logout() {
	var logoutflg = true;
	if (logoutflg) {
		location.href= "/logout"
	} else {
		return false;
	}
}

function start() {

	 var gn = '<%=(String)session.getAttribute(mem+"game_number")%>';
	 var date = '<%=(String)session.getAttribute(mem+"game_rec_create_date")%>';

	 var dateday = date.substr(8, 2);
	 
	 var today = new Date();
	 var day = ('0' + today.getDate()).slice(-2);
	  
	 var finish = '<%=(String)session.getAttribute(mem+"game_finish_flag")%>';
	 var log = '<%=(String)session.getAttribute(mem+"logical_del_flag")%>';
	if (day == dateday && finish == 1 ) {
		alert("今日のゲームはもう完了しました。");
		location.href= "/start"
	} else if (day == dateday && gn) {
		alert("進行していたゲームがあります。 ゲームを続けます。");
		location.href= "/start"
	} else if (day != dateday && gn && finish ==0) {
		alert("日付が変更になりました。 新しいゲームを始めます。");
		location.href= "/start"
	} else  {
		alert("新しいゲームを始めます。");
		location.href= "/start"
	}

}

</script>
</head>
<body class="pt-5">

<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand centered" href="/menu">数当てゲーム</a>
			
		</div>
	</nav>


<div class="container h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
  <div class="col-lg-2">
    </div>
			
			<div class="col-lg-8">
				<form:form  name="startForm" id="startForm" action="start" method="get" onsubmit="return false;" >
					<button type="button"  onclick= "start();" class="btn btn-dark btn-sm btn-block">
						ゲーム スタート</button>
						<div>&nbsp; &nbsp; </div>
				</form:form>		
				<form:form  name="logoutForm" id="logoutForm" action="logout" method="get" onsubmit="return false;">			
						<button type="button" onclick="logout();" class="btn btn-dark btn-sm btn-block">
						ログアウト</button>
			</form:form>
			
				
			</div>

			<!-- 그림 넣을 그리드 -->
			 <div class="col-lg-2"></div>
		</div> 
	</div>
	


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js">
	</script>
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