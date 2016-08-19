<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<meta name="keywords"
	content="Ensaluto Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${pageContext.request.contextPath}/css/login.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
    <h2>11010 张建</h2> 
	<h1>电影租赁管理系统</h1>
	<div class="registration">
		<div class="form-info">
			<form:form action="${pageContext.request.contextPath}/loginHandler/doLogin" method="post">
				<input name="first_name" class="text" placeholder="Username"/>

				<input name="password" class="text" placeholder="Password" type="password"/>
	
				<div class="btn">
					<input type="submit" value="登陆"/>
				</div>
				<div class="roundedOne">
					<input type="checkbox" value="None" id="roundedOne" name="check" />
					<label for="roundedOne"> </label>
					<p>Remember me</p>
				</div>
			</form:form>

			<div class="clear"></div>
		</div>
		<div class="strip">
			<span>OR</span>
		</div>
		<ul class="bottom-sc-icons">
			<li><a href="#" class="forgpass">忘记密码</a></li>
			<li><a href="LogingAction-goRegist">注&nbsp;&nbsp;册</a></li>

		</ul>
	</div>

</body>
</html>