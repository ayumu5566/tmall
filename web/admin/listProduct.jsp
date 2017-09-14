<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<script>
	$(function() {
		$("#addForm").submit(function() {
			if (checkEmpty("name", "产品名称"))
				return true;
			if (checkEmpty("subTitle", "产品小标题"))
				return true;
			if (checkNumber("orignalPrice", "原始价格"))
				return true;
			if (checkNumber("promotePrice", "优惠价格"))
				return true;
			if (checkInt("stock", "库存"))
				return true;
			return false;
		});
	});
</script>

<title>产品管理</title>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_product_list?cid=${category.id}">${category.name}</a></li>
		<li class="active">产品管理</li>
	</ol>
	
	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>图片</th>
					<th>产品名称</th>
					<th>产品小标题</th>
					<th>原始价格</th>
					<th>优惠价格</th>
					<th>库存数量</th>
					<th>图片管理</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
					<tr>
						<td>${p.id}</td>
						<td></td>
						<td>${p.name}</td>
						<td>${p.subTitle}</td>
						<td>${p.orignalPrice}</td>
						<td>${p.promotePrice}</td>
						<td>${p.stock}</td>
						<td>
							<a href="">
								<span class="glyphicon glyphicon-edit"></span>
							</a>
						</td>
						<td>
							<a href="admin_product_edit?id=${p.id}">
								<span class="glyphicon glyphicon-edit"></span>
							</a>
						</td>
						<td>
							<a deleteLink="true" href="admin_product_delete?id=${p.id}">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
        <%@include file="../include/adminPage.jsp" %>
    </div>

	<div class="panel panel-warning addDiv">
    	<div class="panel-heading">新增产品</div>
    	<div class="panel-body">
    		<form method="post" id="addForm" action="admin_product_add">
				<input type="hidden" name="cid" value="${category.id}"/>
    			<table class="addTable">
    				<tr>
    					<td>产品名称</td>
    					<td>
    						<input id="name" name="name" type="text" class="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td>产品小标题</td>
    					<td>
    						<input id="subTitle" name="subTitle" type="text" class="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td>原始价格</td>
    					<td>
    						<input id="orignalPrice" name="orignalPrice" type="text" class="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td>优惠价格</td>
    					<td>
    						<input id="promotePrice" name="promotePrice" type="text" class="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td>库存</td>
    					<td>
    						<input id="stock" name="stock" type="text" class="form-control"/>
    					</td>
    				</tr>
    				<tr class="submitTR">
    					<td colspan="2" align="center">
    						<button type="submit" class="btn btn-success">提 交</button>
    					</td>
    				</tr>
    			</table>
    		</form>
    	</div>
    </div>    
</div>


<%@include file="../include/adminFooter.jsp"%>