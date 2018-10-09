<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>老师测试管理</title>
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
		<li class="active"><a href="${ctx}/tea/teacher/">老师测试列表</a></li>
		<shiro:hasPermission name="tea:teacher:edit"><li><a href="${ctx}/tea/teacher/form">老师测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="teacher" action="${ctx}/tea/teacher/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>age：</label>
				<form:input path="age" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>sex：</label>
				<form:input path="sex" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>score：</label>
				<form:input path="score" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>age</th>
				<th>sex</th>
				<th>score</th>
				<shiro:hasPermission name="tea:teacher:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="teacher">
			<tr>
				<td><a href="${ctx}/tea/teacher/form?id=${teacher.id}">
					${teacher.name}
				</a></td>
				<td>
					${teacher.age}
				</td>
				<td>
					${teacher.sex}
				</td>
				<td>
					${teacher.score}
				</td>
				<shiro:hasPermission name="tea:teacher:edit"><td>
    				<a href="${ctx}/tea/teacher/form?id=${teacher.id}">修改</a>
					<a href="${ctx}/tea/teacher/delete?id=${teacher.id}" onclick="return confirmx('确认要删除该老师测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>