<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/zuser/zUser/">用户表列表</a></li>
		<shiro:hasPermission name="zuser:zUser:edit"><li><a href="${ctx}/zuser/zUser/form">用户表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zUser" action="${ctx}/zuser/zUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>name</th>
				<shiro:hasPermission name="zuser:zUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zUser">
			<tr>
				<td><a href="${ctx}/zuser/zUser/form?id=${zUser.id}">
					${zUser.name}
				</a></td>
				<shiro:hasPermission name="zuser:zUser:edit"><td>
    				<a href="${ctx}/zuser/zUser/form?id=${zUser.id}">修改</a>
					<a href="${ctx}/zuser/zUser/delete?id=${zUser.id}" onclick="return confirmx('确认要删除该用户表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>