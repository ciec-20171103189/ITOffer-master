<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
</head>
<body>

<iframe src="top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
	<div class="content">
		<div class="page_name">注册</div>
		<div class="login_content">
			<form action = "ApplicantRegisterServlet" method = "post">
				<div class="login_l">
					<div class="span1">
						<label class="tn-form-label">邮箱：</label> 
						<input class="tn-textbox" name = "mail" type="text">
					</div>
					<div class="span1">
						<label class="tn-form-label">密码：</label> 
						<input class="tn-textbox" name = "password" type="password">
					</div>
					<div class="span1">
						<label class="tn-form-label">验证码：</label>
					 <input
							name ="verifyCode" class="tn-textbox-long" type="text"> <span> 
							<img src="http://localhost:8080/ITOffer/ValidateCodeServlet" title="点击换一换"> 
							<a href="javascript:;">看不清？</a>
						</span>
					</div>
					<div class="tn-form-row-button">
						<div class="span1">
							<input name="" type="submit" class="tn-button-text" value="立即注册">
							<p class="it-register-text">
								<input name="" id="" class="tn-checkbox" value="true"
									checked="checked" type="checkbox"> <label>
									同意本站服务条款</label> <a href="javascript:;">查看</a>
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</form>
			<div class="register_r">
				<p align="center">
					<b>还没有帐号？</b><a href="register.html">10秒钟快速注册</a>
				</p>

				<div>
					<img src="images/reg_pic.jpg">
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