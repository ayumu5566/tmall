<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<title>编辑属性</title>

<div class="workingArea">
	<ol class="breadcrumb">
      <li><a href="admin_category_list">所有分类</a></li>
      <li><a href="admin_property_list?cid=${category.id}">${category.name}</a></li>
      <li class="active">编辑属性</li>
    </ol>
	<div class="panel panel-warning addDiv">
	   	<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_property_update">
				<input type="hidden" name="id" value="${property.id}">
				<table class="editTable">
	   				<tr>
	   					<td>属性名称</td>
	   					<td>
							<input id="name" name="name" value="${property.name}" type="text" class="form-control">
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