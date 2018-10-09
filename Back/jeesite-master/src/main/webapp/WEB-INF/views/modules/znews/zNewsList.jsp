<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>新闻表管理</title>
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
		<li class="active"><a href="${ctx}/znews/zNews/">新闻表列表</a></li>
		<shiro:hasPermission name="znews:zNews:edit"><li><a href="${ctx}/znews/zNews/form">新闻表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zNews" action="${ctx}/znews/zNews/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>新闻标题：</label>
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
				<th>新闻标题</th>
				<th>图片地址</th>
				<th>新闻详情</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="znews:zNews:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zNews">
			<tr>
				<td><a href="${ctx}/znews/zNews/form?id=${zNews.id}">
					${zNews.title}
				</a></td>
				<td>
					${zNews.picurl}
				</td>
				<td>
					${zNews.content}
				</td>
				<td>
					<fmt:formatDate value="${zNews.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zNews.remarks}
				</td>
				<shiro:hasPermission name="znews:zNews:edit"><td>
    				<a href="${ctx}/znews/zNews/form?id=${zNews.id}">修改</a>
					<a href="${ctx}/znews/zNews/delete?id=${zNews.id}" onclick="return confirmx('确认要删除该新闻表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>