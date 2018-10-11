<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经管表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/zjmna/zJmna/">经管表列表</a></li>
		<li class="active"><a href="${ctx}/zjmna/zJmna/form?id=${zJmna.id}">经管表<shiro:hasPermission name="zjmna:zJmna:edit">${not empty zJmna.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zjmna:zJmna:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zJmna" action="${ctx}/zjmna/zJmna/save" method="post" class="form-horizontal" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">视频描述：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>

		<div class="control-group">
		<label class="control-label">上传图片：</label>
		<div class="controls">
			<input type="file" name="picfile" class="required">
			<%--<form:input path="picfile" class="required"/>--%>
		</div>
		</div>

		<div class="control-group">
			<label class="control-label">上传视频：</label>
			<div class="controls">
				<input type="file" name="videofile" class="required">
			</div>
		</div>

		<%--<div class="control-group">--%>
			<%--<label class="control-label">图片地址：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="picurl" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">视频地址：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="videourl" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zjmna:zJmna:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>