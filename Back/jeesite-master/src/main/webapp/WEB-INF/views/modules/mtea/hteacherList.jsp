<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>班主任测试管理</title>
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
		<li class="active"><a href="${ctx}/mtea/hteacher/">班主任测试列表</a></li>
		<shiro:hasPermission name="mtea:hteacher:edit"><li><a href="${ctx}/mtea/hteacher/form">班主任测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="hteacher" action="${ctx}/mtea/hteacher/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>姓名</th>
				<shiro:hasPermission name="mtea:hteacher:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="hteacher">
			<tr>
				<td><a href="${ctx}/mtea/hteacher/form?id=${hteacher.id}">
					<fmt:formatDate value="${hteacher.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${hteacher.remarks}
				</td>
				<td>
					${hteacher.name}
				</td>
				<shiro:hasPermission name="mtea:hteacher:edit"><td>
    				<a href="${ctx}/mtea/hteacher/form?id=${hteacher.id}">修改</a>
					<a href="${ctx}/mtea/hteacher/delete?id=${hteacher.id}" onclick="return confirmx('确认要删除该班主任测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>