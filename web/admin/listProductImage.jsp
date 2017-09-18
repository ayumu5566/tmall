<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<script>
	$(function() {
		$(".addFormSingle").submit(function() {
			if (checkEmpty("filepathSingle", "图片文件")) {
				$("#filepathSingle").value("");
				return true;
			}
			return false;
		});
		$(".addFormDetail").submit(function() {
			if (checkEmpty("filepathDetail", "图片文件"))
				return true;
			return false;
		});
	});
</script>

<title>产品图片管理</title>

<div class="workingArea">
	<ol class="breadcrumb">
      <li><a href="admin_category_list">所有分类</a></li>
      <li><a href="admin_product_list?cid=${product.category.id}">${product.category.name}</a></li>
      <li class="active">${product.name}</li>
      <li class="active">产品图片管理</li>
    </ol>

	<table class="addPictureTable" align="center">
		<tr>
			<td class="addPictureTableTD">
				<div>
					<div class="panel panel-warning addPictureDiv">
						<div class="panel-heading">新增产品<b class="text-primary"> 单个 </b>图片</div>
						<div class="panel-body">
							<form method="post" class="addFormSingle" action="admin_productImage_add" enctype="multipart/form-data">
								<table class="addTable">
									<tr>
										<td>请选择本地图片 尺寸400X400 为佳</td>
									</tr>
									<tr>
										<td>
											<input id="filepathSingle" type="file" name="filepath"/>
										</td>
									</tr>
									<tr class="sumbitTR">
										<td align="center">
                                            <input type="hidden" name="type" value="type_single" />
                                            <input type="hidden" name="pid" value="${product.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<table class="table table-striped table-bordered table-hover  table-condensed">
						<thead>
							<tr class="success">
								<td>ID</td>
								<td>产品单个图片缩略图</td>
								<td>删除</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${singleImages}" var="si">
								<tr>
									<td>${si.id}</td>
									<td>
										<a title="点击查看原图" href="img/productSingle/${si.id}.jpg" target="_blank">
											<img height="50px" src="img/productSingle/${si.id}.jpg">
										</a>
									</td>
									<td>
										<a deleteLink="true" href="admin_productImage_delete?id=${si.id}">
											<span class="glyphicon glyphicon-trash"></span>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</td>
			<td class="addPictureTableTD">
				<div>
					<div class="panel panel-warning addPictureDiv">
						<div class="panel-heading">新增产品<b class="text-primary"> 详情 </b>图片</div>
						<div class="panel-body">
							<form method="post" class="addFormDetail" action="admin_productImage_add" enctype="multipart/form-data">
								<table class="addTable">
									<tr>
										<td>请选择本地图片 宽度790 为佳</td>
									</tr>
									<tr>
										<td>
											<input id="filepathDetail" type="file" name="filepath"/>
										</td>
									</tr>
									<tr class="sumbitTR">
										<td align="center">
                                            <input type="hidden" name="type" value="type_detail" />
                                            <input type="hidden" name="pid" value="${product.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<table class="table table-striped table-bordered table-hover  table-condensed">
						<thead>
							<tr class="success">
								<td>ID</td>
								<td>产品详情图片缩略图</td>
								<td>删除</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${detailImages}" var="di">
								<tr>
									<td>${di.id}</td>
									<td>
										<a title="点击查看原图" href="img/productDetail/${di.id}.jpg" target="_blank">
											<img height="50px" src="img/productDetail/${di.id}.jpg">
										</a>
									</td>
									<td>
										<a deleteLink="true" href="admin_productImage_delete?id=${di.id}">
											<span class="glyphicon glyphicon-trash"></span>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>

<%@include file="../include/adminFooter.jsp"%>