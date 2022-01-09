<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Product"%>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp"></c:import>
<body>
<%--Header --%>
<c:import url="header.jsp"></c:import>

<!--Noi dung chinh-->
<div class="container">

	<c:set scope="page" var="pds" value='${requestScope["products"]}'></c:set>
	<%-- <c:out value="${pds.toString() }"></c:out> --%>
	
	<c:forEach var="product" items="${pds}">
		<c:if test="${pds.indexOf(product) % 4 == 0}">
			<div class="row">
		</c:if>
		<div class="col-md-3 item">
			<a href='<c:url value="InformationProductController?id=${product.getId()}"></c:url>' class="item-link">
				<div class="item-img">
					<img class="img-fluid rounded mx-auto d-block"
						src='<c:out value="${product.getSrc()}"></c:out>' alt="">
				</div>
				<p><c:out value="${product.getBrand()}"></c:out></p>
				<h3><c:out value="${product.getName()}"></c:out></h3> <strong class="price"><c:out value="${product.getPrice()}"></c:out></strong>
			</a>
		</div>
		
		<c:choose>
			<c:when test="${pds.indexOf(product) == pds.size()}">
				</div>
			</c:when>	
			<c:when test="${(pds.indexOf(product) + 1) % 4 == 0}">
				</div>
			</c:when>
					
		</c:choose>
			
			<%-- 
		<c:if test="${(pds.indexOf(product) + 1) % 4 == 0}">
			</div>
		</c:if>
		--%>
	</c:forEach>
</div>
</div>

<%-- Đây là chân trang --%>
 <c:import url="footer.jsp"></c:import>
 
 </body>

</html>