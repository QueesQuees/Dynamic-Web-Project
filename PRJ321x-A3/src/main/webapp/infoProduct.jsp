<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<%-- Head --%>
<c:import url="head.jsp"></c:import>
<body>
<%--Header and navbar --%>
<c:import url="header.jsp"></c:import>

<%--Noi dung chinh --%>

<c:set scope="page" var="product" value='${requestScope["product"] }'></c:set>

<div class="container jumbotron-fluid">
        <div class="product">
            <div class="product-name">
                <h3><c:out value="${product.getName() }"></c:out></h3>
            </div>
            <div class="product-info row">
                <div class="product-img col-md-4">
                    <img class="img-fluid" src='<c:out value="${product.getSrc()}"></c:out>' alt="">
                </div>
                <div class="col-md-8">
                    <h2><c:out value="${product.getPrice() }"></c:out>đ</h2>
                    <p>Màn hình: 6.5", Retina XDR <br/>   HĐH: iOS 13 <br/>   CPU: Apple A13 Bionic 6 nhân <br/>  RAM: 4 GB, ROM: 512 GB <br/>  Camera: 3 camera 12 MP, <br/> Selfie: 12 MP</p>
                    <p><c:out value="${product.getDescription() }"></c:out></p>
                    
                    
                    <div class="addcart">
                        <a href="AddToCartController?id=${product.getId()}&action=add">
                            <button type="button" class="btn btn-success">Add to cart</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
</div>


<c:import url="footer.jsp"></c:import>
</body>
</html>