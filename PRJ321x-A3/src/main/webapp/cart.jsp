<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp"></c:import>
<body>
	<c:import url="header.jsp"></c:import>



	<div class="container">
		<div class="cart">
			<!--chứa thông tin về giỏ hàng-->
			<div class="cart-table">
				<c:set scope="session" var="cart" value='${sessionScope["cart"]}'></c:set>
				<c:set scope="session" var="list" value="${cart.getItems() }"></c:set>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Sản phẩm: <c:out value="${list.size()}"></c:out></th>
							<th>Giá</th>
							<th>Số lượng</th>
							<th>Tổng giá</th>
						</tr>
					</thead>
					<c:forEach var="product" items="${list }">
						<tbody>
							<tr>
								<td><c:out value="${product.getName() }"></c:out></td>
								<td><c:out value="${product.getPrice() }"></c:out>$</td>
								<td><c:out value="${ product.getNumber() }"></c:out></td>
								<td><c:out value="${product.getPrice() * product.getNumber() }"></c:out>$</td>
							</tr>
						</tbody>
					</c:forEach>
					<tbody >
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><c:out value="${cart.getAmount()}"></c:out>$</td>
                        </tr>
                    </tbody>
				</table>
			</div>

			<!--form tiến hành đặt hàng-->
			<form class="was-validated" action="PayController" method="get">
				<div class="form-group">
					<label for="uname">Tên mail bạn</label> <input type="text"
						class="form-control" id="uname" placeholder="Nhập email của bạn"
						name="name" required>
					<div class="valid-feedback">Ok</div>
					<div class="invalid-feedback">Tên của bạn</div>
				</div>
				<div class="form-group">
					<label for="address">Địa chỉ</label> <input type="text"
						class="form-control" id="address" placeholder="Địa chỉ của bạn"
						name="address" required>
					<div class="valid-feedback">Ok</div>
					<div class="invalid-feedback">Làm ơn hãy nhập địa chỉ để có
						thể nhận hàng</div>
				</div>
				<div class="form-group">
					<label for="date">Ngày nhận hàng</label> <input type="date"
						class="form-control" id="date" placeholder="nhập ngày nhận hàng"
						name="receivedDate" required>
					<div class="valid-feedback">Ok</div>
					<div class="invalid-feedback">Làm ơn hãy nhập ngày thể nhận
						hàng</div>
				</div>
				<div class="form-group">
					<label for="date">Số điện thoại</label> <input type="number"
						class="form-control" id="date" placeholder="nhập số điện thoại tại đây"
						name="phonenumber" required>
					<div class="valid-feedback">Ok</div>
					<div class="invalid-feedback">Làm ơn hãy nhập số điện thoại nhận
						hàng</div>
				</div>

				<button type="submit" class="btn btn-primary">Đặt hàng</button>
			</form>

		</div>

	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>