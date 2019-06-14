<%@page import="cn.edu.imnu.ITOffer.DButil.CookieEncryptTool"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%
	String applicantEmail = "";
	String applicantPwd = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie: cookies){
			if("COOKIE_APPLICANTEMAIL".equals(cookie.getName())){
				applicantEmail = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
			if("COOKIE_APPLICANTPWD".equals(cookie.getName())){
				applicantPwd = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
		}
	}
	%>
	<iframe src="top.jsp" width="100%" height="100" scrolling="no"
		frameborder="0"></iframe>
	<div class="content">
		<form action="ApplicantLoginServlet" method="post">
		<div class="page_name">登陆</div>
		<div class="login_content">
			<div class="login_l">
				<p class="font14">使用注册邮箱登录</p>
				<div class="span1">
					<label class="tn-form-label">邮箱：</label> <input class="tn-textbox"
						type="text" name="email" id="email" value="<%=applicantEmail%>">
				</div>
				<div class="span1">
					<label class="tn-form-label">密码：</label> <input class="tn-textbox"
						type="password" name="password" id="password" value="<%=applicantPwd%>">
				</div>
				<div class="tn-form-row-button">
					<div class="span1">
						<input name="" type="submit" class="tn-button-text" value="登   录">
						<span class="it-register-text">
							<input checked="checked" name="rememberMe" id="rememberMe" class="tn-checkbox" value="true" type="checkbox"> 
							<label for="RememberPassword"> 记住密码</label>
						</span>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			</form>
			<div class="login_r">
				<p align="center">
					<b>还没有帐号？</b><a href="register.jsp">10秒钟快速注册</a>
				</p>

				<div>
					<img src="images/login_pic.jpg">
				</div>

				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>