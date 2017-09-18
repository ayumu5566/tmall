<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<script>
	$(function() {
		$("input.pvValue").keyup(function() {
			var value = $(this).val();
			var page = "admin_product_updatePropertyValue";
			var pvid = $(this).attr("pvid");
			var parentSpan = $(this).parent("span");
			parentSpan.css("border", "1px solid yellow");
			$.post(page, {
				"value" : value,
				"pvid" : pvid
			}, function(result) {
				if ("success" == result) {
					parentSpan.css("border", "1px solid green");
				} else {
					parentSpan.css("border", "1px solid red");
				}
			});
		})
	});
</script>

<title>编辑产品属性值</title>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_product_list?cid=${category.id}">${category.name}</a></li>
		<li class="active">${product.name}</li>
		<li class="active">编辑产品属性</li>
	</ol>

	<div class="editPVDiv">
		<c:forEach items="${pvs}" var="p">
			<div class="eachPV">
				<span class="pvName">${p.property.name}</span>
				<span class="pvValue"><input class="pvValue" pvid="${p.id}" type="text" value="${p.value}" /></span>
			</div>
		</c:forEach>
	</div>
</div>

<%@include file="../include/adminFooter.jsp"%>