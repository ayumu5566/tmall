<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<title>编辑产品</title>

<div class="workingArea">
	<ol class="breadcrumb">
      <li><a href="admin_category_list">所有产品</a></li>
      <li><a href="admin_property_list?cid=${category.id}">${category.name}</a></li>
      <li class="active">${product.name}</li>
      <li class="active">编辑产品</li>
    </ol>
	<div class="panel panel-warning addDiv">
	   	<div class="panel-heading">编辑产品</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_product_update">
				<input type="hidden" name="id" value="${product.id}">
				<table class="editTable">
	   				<tr>
	   					<td>产品名称</td>
	   					<td>
							<input id="name" name="name" value="${product.name}" type="text" class="form-control">
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>产品小标题</td>
	   					<td>
							<input id="name" name="name" value="${product.subTitle}" type="text" class="form-control">
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>原始价格</td>
	   					<td>
							<input id="name" name="name" value="${product.orignalPrice}" type="text" class="form-control">
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>优惠价格</td>
	   					<td>
							<input id="name" name="name" value="${product.promotePrice}" type="text" class="form-control">
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>库存</td>
	   					<td>
							<input id="stock" name="stock" value="${product.stock}" type="text" class="form-control">
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