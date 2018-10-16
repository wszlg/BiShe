<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推荐表管理</title>
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
		<li class="active"><a href="${ctx}/zrec/zRec/">推荐表列表</a></li>
		<shiro:hasPermission name="zrec:zRec:edit"><li><a href="${ctx}/zrec/zRec/form">推荐表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zRec" action="${ctx}/zrec/zRec/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户id：</label>
				<form:input path="userid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>类型：</label>
				<form:input path="type" htmlEscape="false" maxlength="1" class="input-medium"/>
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
				<shiro:hasPermission name="zrec:zRec:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zRec">
			<tr>
				<td><a href="${ctx}/zrec/zRec/form?id=${zRec.id}">
					<fmt:formatDate value="${zRec.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zRec.remarks}
				</td>
				<shiro:hasPermission name="zrec:zRec:edit"><td>
    				<a href="${ctx}/zrec/zRec/form?id=${zRec.id}">修改</a>
					<a href="${ctx}/zrec/zRec/delete?id=${zRec.id}" onclick="return confirmx('确认要删除该推荐表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>