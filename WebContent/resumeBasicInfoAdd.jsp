<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/my_resume.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<iframe src="top.jsp" width="100%" height="100" scrolling="no"
		frameborder="0"></iframe>
		
	<div class="resume_con">
		<!--tab设置-->
		<div class="user_operate">
			<ul style="float: left">
				<li><a href="resume.jsp" class="active">我的简历</a></li>
				<li><a href="jobApply.jsp">我的申请</a></li>
				<div class="clear"></div>
			</ul>
			<div class="clear"></div>
		</div>
		<!--主体部分-->
		<div class="resume_main">
			<!--左边-->
			<div class="resume_left">
				<div class="resume_title">
					<div style="float: left">基本信息</div>
				</div>
				<form action="ResumeBasicinfoServlet?type=add"   method="post">
				<div class="all_resume">
					<div class="table_style">
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
								<td bgcolor="#F8F8F8"><input type="text" id="realname" name="realName"
									value="Sunny"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
								<td bgcolor="#F8F8F8"><input type="radio" name="gender" checked="checked" value="男">男<input
									type="radio" name="gender" value="女">女</td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
								<td bgcolor="#F8F8F8">
								<input type="date" name="birthday" id="birthday" onclick="SelectDate(this)" value="2019-04-16"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width = "110" align="right" bgcolor="#f8f8f8">当前所在地;</th>
								<td bgcolor = "#f8f8f8" align="left">
								<input type = "text" name="currentLoc"  value="和林格尔县 内蒙古师范大学"></td>
							</tr>
						</table>
							<div class="he"></div>
							<table width="350" border="0" cellpadding="3" cellspacing="1">
							<tr>
								<th width="110" align="right" bgcolor="#f8f8f8" >户口所在地</th>
								<td bgcolor = "#f8f8f8" align="left">
								<input type = "text" name="residentLoc" value="和林格尔县 内蒙古师范大学"></td>
							</tr><table>
							<table width="350" border="0" cellpadding="3" cellspacing="1" bgcolor = "#EEEEEE">
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">手机：</th>
								<td bgcolor="#F8F8F8"><input type="text" id="telephone" name="telephone"
									value="4008208820"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">邮件：</th>
								<td bgcolor="#F8F8F8"><input type="text" id="email" name="email"
									value="764152162@QAQ.com"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">求职意向：</th>
								<td bgcolor="#F8F8F8"><input type="text" name="jobIntension"
									value="17软件工程"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="350" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<td width="110" align="right" bgcolor="#F8F8F8">工作经验：</td>
								<td bgcolor="#F8F8F8" align = "left">
									<select name = "jobExperience">
										<option value = "0">请选择</option>
										<option value = "刚刚参加工作">刚刚参加工作</option>
										<option value = "已工作一年">已工作一年</option>
										<option value = "已工作两年">已工作两年</option>
										<option value = "已工作三年">已工作三年</option>
										<option value = "已工作三年以上">已工作三年以上</option>
									</select>
								</td>
							</tr>
						</table>
						<div class="he"></div>
						<div style="margin-left: 100px;">
							<input name="" type="submit" class="save1"   value="保存"> 
							<input name="" type="submit" class="cancel2" value="取消">
						</div>
					</div>
					<div style="float: right" class="uploade">
						<img src="images/person_img.jpg">
						<div align="center">
							<a href="resumeBasicInfoPicUpload.jsp" class="uploade_btn">更换照片</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			</form>
			<!--右边-->
			<iframe src="resume_right.jsp" width="290" height="650"
				scrolling="no" frameborder="0"></iframe>
			<div style="clear: both"></div>
		</div>
	</div>

	<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>