<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 페이지</title>
</head>
<body>
	<c:if test="${!isProduct}">
		<table>
			<tr>
				<c:forEach items="${products }" var="p">
					<td><a href="product?action=detail&id=${p.productId }"> <img
							alt="${p.image }" src="./_images/_media/${p.image }">
					</a></td>
					<c:if test="${status.count%5 == 0 }">
			</tr>
			<tr>
				</c:if>

				</c:forEach>
			</tr>
		</table>
	</c:if>
	<c:if test="${isProduct}">
		<table>
			<tr>
				<td><img src="./_images/_media/${product.image }" width=400px;
					height="400px"></td>
			</tr>
			<tr>
				<td align="center">상품명 : ${product.product }</td>
			</tr>
			<tr>
				<td align="center">가격 : ${product.price }</td>
			</tr>
			<c:if test="${product.stock != 0 }">
				<tr>
					<td align="center">${product.stock }</td>
				</tr>
			</c:if>
			<tr>
				<td align="center">판매자 :${product.seller }</td>
			</tr>


		</table>
	</c:if>
</body>
</html>