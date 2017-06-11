<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.dto.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h2>list.jsp</h2>

	<div class="container">
		<h2>게시판 페이징 처리</h2>
		<table class="table table-bordered">
			<thead>
				<tr class="info">
					<th width="10%">NO</th>
					<th width="55%">제목</th>
					<th width="10%">작성자</th>
					<th width="15%">작성시간</th>
					<th width="10%">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="b">
					<tr>
						<td><c:out value="${b.bno}" /></td>
						<td><a href="board?action=view&bno=<c:out value="${b.bno}"/>"><c:out
									value="${b.title}" /></a></td>
						<td><c:out value="${b.writer}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${b.wdate}" /></td>
						<td>${b.vcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="center">
			<c:if test="${cp > 1 }">
				<a class="btn btn-info" href="board?p=${cp-1 }">이전</a>
			</c:if>
			

			
			<c:set var="i" value="1" />
			<c:forEach var="i" begin="1" end="${tp}" step="1">
				<c:if test="${i == cp}">
					<c:out value="[${i}]" />
				</c:if>
				<c:if test="${i != cp}">
                    &nbsp;<a href="board?p=${i}">${i}</a>&nbsp;
                    </c:if>
			</c:forEach>



			<c:if test="${cp < tp }">
				<a class="btn btn-info" href="board?p=${cp+1 }">다음</a>
			</c:if>
		</div>
	</div>
		<!--  -->
		<hr>
		<hr>
<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}"/>
   <c:set var="endPage" value="${startPage + pageGroupSize-1}"/>
   
   <c:if test="${endPage > pageCount}" >
     <c:set var="endPage" value="${pageCount}" />
   </c:if>
          
   <c:if test="${numPageGroup > 1}">
        <a href="board?p=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
   </c:if>
   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="board?p=${i}">
          <c:if test="${currentPage == i}">
        </c:if>
        [${i}]
       </a>
   </c:forEach>
   <c:if test="${numPageGroup < pageGroupCount}">
        <a href="board?p=${numPageGroup*pageGroupSize+1}">[다음]</a>
   </c:if>
</c:if>

</body>
</html>