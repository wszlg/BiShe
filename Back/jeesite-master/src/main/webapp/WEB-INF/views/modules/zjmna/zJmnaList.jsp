<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经管表管理</title>
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
		<li class="active"><a href="${ctx}/zjmna/zJmna/">经管表列表</a></li>
		<shiro:hasPermission name="zjmna:zJmna:edit"><li><a href="${ctx}/zjmna/zJmna/form">经管表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zJmna" action="${ctx}/zjmna/zJmna/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>视频描述：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>视频描述</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="zjmna:zJmna:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zJmna">
			<tr>
				<td><a href="${ctx}/zjmna/zJmna/form?id=${zJmna.id}">
					${zJmna.title}
				</a></td>
				<td>
					<fmt:formatDate value="${zJmna.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zJmna.remarks}
				</td>
				<shiro:hasPermission name="zjmna:zJmna:edit"><td>
    				<a href="${ctx}/zjmna/zJmna/form?id=${zJmna.id}">修改</a>
					<a href="${ctx}/zjmna/zJmna/delete?id=${zJmna.id}" onclick="return confirmx('确认要删除该经管表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>