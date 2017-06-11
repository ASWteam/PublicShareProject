<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="paging">
		<div class="element">
			<c:set var="page" value="${cp}" />

			<!-- page maxpage를 넘었을 경우 제한 -->
			<c:if test="${page > maxpage}">
				<c:set var="page" value="${maxpage}" />
			</c:if>

			<!-- 페이지를 8개씩 나누기 위해 현재 페이지에 보여줄 max값 설정 -->
			<fmt:formatNumber value="${page/8 - (page/8 % 1)}" type="pattern"
				pattern="0" var="full" />
			<c:set var="full" value="${full * 8}" />

			<!-- prev(전페이지), next(다음페이지) 개수 설정 -->
			<c:set var="scope" value="${page%8}" />
			<c:choose>
				<c:when test="${scope == 0}">
					<c:set var="prev" value="8" />
					<c:set var="next" value="1" />
				</c:when>
				<c:when test="${scope < 9}">
					<c:set var="prev" value="${scope}" />
					<c:set var="next" value="${9-scope}" />
				</c:when>
			</c:choose>

			<!-- prev 버튼 -->
			<c:if test="${page > 8}">
				<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}"
					type="pattern" pattern="0" var="prevb" />
				<c:set value="${(prevb-1)*8 + 1}" var="prevb" />
				<span id="prevBtn" class="prev button" value="${prevb}"></span>
			</c:if>

			<!-- 전 페이지 -->
			<c:if test="${page != 1}">
				<c:set var="j" value="${prev}" />
				<c:forEach var="i" begin="1" end="${prev-1}">
					<c:set var="j" value="${j - 1}" />
					<c:if test="${(page - j) > 0}">
						<span class="no">${page - j}</span>
					</c:if>
				</c:forEach>
			</c:if>

			<!-- 현재 페이지 -->
			<span class="no selected">${page}</span>

			<!-- 다음 페이지 -->
			<c:if test="${page != maxpage}">
				<c:forEach var="i" begin="1" end="${next-1}">
					<c:if test="${maxpage >= page+i}">
						<span class="no">${page+i}</span>
					</c:if>
				</c:forEach>
			</c:if>

			<!-- next 버튼 -->
			<c:if test="${maxpage >= page + next}">
				<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}"
					type="pattern" pattern="0" var="nextb" />
				<c:set value="${(nextb+1)*8 + 1}" var="nextb" />
				<span id="nextBtn" class="next button" value="${nextb}"></span>
			</c:if>
		</div>
	</div>
</body>
</html>