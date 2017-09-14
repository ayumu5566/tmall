<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<title>编辑分类</title>

<div class="workingArea">
	<ol class="breadcrumb">
      <li><a href="admin_category_list">所有分类</a></li>
      <li><a href="admin_category_edit?id=${category.id}">${category.name}</a></li>
      <li class="active">编辑分类</li>
    </ol>
	<div class="panel panel-warning addDiv">
	   	<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_category_update" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${category.id}">
				<table class="editTable">
	   				<tr>
	   					<td>分类名称</td>
	   					<td>
							<input id="name" name="name" value="${category.name}" type="text" class="form-control">
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>分类图片</td>
	   					<td>
	   						<input id="categoryPic" accept="image/*" type="file" name="filepath" />
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