<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp"></c:import>

<body>
	<c:import url="header.jsp"></c:import>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center login-top">
				<div class="col-md-6 text-center mb-5 ">
					<h2>Sign up</h2>
				</div>
			</div>
			<div class="row justify-content-center login-bottom">
				<div class="col-md-7 col-lg-5">
					<div class="wrap">
						<div class="img" style='background-image: url("${pageContext.request.contextPath}/anh.jpg");'></div>

						<div class="login-wrap p-4 p-md-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Register</h3>
								</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
										<a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-facebook"></span></a> <a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-twitter"></span></a>
									</p>
								</div>
							</div>
							<form action="Login" class="signin-form" method="get">
								<input type="hidden" name="action" value="doregister">
								<div class="form-group mt-3">
									<input type="text" class="form-control" required name="email"> <label
										class="form-control-placeholder" for="username">Email</label>
								</div>
								<div class="form-group mt-3">
									<input type="text" class="form-control" required name="username"> <label
										class="form-control-placeholder" for="username">User Name</label>
								</div>
								<div class="form-group">
									<input id="password-field" name="password" type="password" class="form-control"
										required> <label class="form-control-placeholder"
										for="password">Password</label> <span toggle="#password-field"
										class="fa fa-fw fa-eye field-icon toggle-password"></span>
								</div>
								<div class="form-group">
									<input id="password-field" name="repeatpassword" type="password" class="form-control"
										required> <label class="form-control-placeholder"
										for="repeatpassword">Repeat Password</label> <span toggle="#password-field"
										class="fa fa-fw fa-eye field-icon toggle-password"></span>
								</div>
								<div class="form-group">
									<button type="submit"
										class="form-control btn btn-primary rounded submit px-3">Sign
										up</button>
								</div>
								<div class="form-group d-md-flex">
									<div class="w-50 text-left">
										<label class="checkbox-wrap checkbox-primary mb-0">Remember
											Me <input type="checkbox" checked> <span
											class="checkmark"></span>
										</label>
									</div>
									<div class="w-50 text-md-right">
										<a href="#">Forgot Password</a>
									</div>
								</div>
							</form>
							<p class="text-center">
								Not a member? <a data-toggle="" href="Account?action=login">Sign In</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<c:import url="footer.jsp"></c:import>
</body>
</html>