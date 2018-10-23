<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>话题表管理</title>
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
		<li class="active"><a href="${ctx}/zchat/zChat/">话题表列表</a></li>
		<shiro:hasPermission name="zchat:zChat:edit"><li><a href="${ctx}/zchat/zChat/form">话题表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zChat" action="${ctx}/zchat/zChat/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户id：</label>
				<form:input path="userid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户昵称：</label>
				<form:input path="username" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>编号：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>话题内容</th>
				<th>用户昵称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="zchat:zChat:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zChat">
			<tr>
				<td><a href="${ctx}/zchat/zChat/form?id=${zChat.id}">
					${zChat.content}
				</a></td>
				<td>
					${zChat.username}
				</td>
				<td>
					<fmt:formatDate value="${zChat.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zChat.remarks}
				</td>
				<shiro:hasPermission name="zchat:zChat:edit"><td>
    				<a href="${ctx}/zchat/zChat/form?id=${zChat.id}">修改</a>
					<a href="${ctx}/zchat/zChat/delete?id=${zChat.id}" onclick="return confirmx('确认要删除该话题表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>