<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>我的简历 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/my_resume.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function validate() {
		var headShot = document.getElementById("headShot");
		if (headShot.value == "") {
			alert("请选择要上传的头像！");
			headShot.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	
	<iframe src="top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>

	<!-- 简历照片上传页面 开始 -->
	<div class="resume_con">
		<!--tab设置-->
		<div class="user_operate">
			<ul style="float: left">
			  <li> <a href="resume.jsp">我的简历</a></li>
              <li class="tn-tabs-selected"> <a href="jobApply.jsp">我的申请</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<!--主体部分-->
		<div class="resume_main">
			<!--左边-->
			<div class="resume_left">
				<div class="resume_title">
					<div style="float: left">简历照片</div>
				</div>
				<div class="all_resume">
					<!--------------------- 简历照片修改------------------------->
					<form action="ResumePicUploadServlet" method="post"
						enctype="multipart/form-data" onsubmit="return validate();">
						<div class="table_style" style="margin-left: 150px;">
							<div class="uploade">
								<div align="center">
									<img src="images/person_img.jpg" width="150" height="150">
									<p>&nbsp;</p>
									<input name="headShot" id="headShot" type="file" value="上传照片">
								</div>
							</div>
							<div class="clear"></div>
							<div class="he"></div>
							<div align="center">
								<input name="submit" type="submit" class="save1" value="保存"> 
								<input name="reset" type="reset" class="cancel2" value="取消">
							</div>
						</div>
					</form>
					<!--------------------- 简历照片修改 结束---------------------->
				</div>
			</div>
			<!--右边-->
		<iframe src="resume_right.jsp" width="290" height="650"  scrolling="no" frameborder="0"></iframe>
		<div style="clear:both"></div>
		</div>
	</div>
	<!-- 我的简历页面结束 -->
	<!-- 网站公共尾部 -->
	<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>