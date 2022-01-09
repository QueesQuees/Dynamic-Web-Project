<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container-fluid">

        <!--Phần đầu cảu cảu trang-->
        <header class="row bg-info jumbotron header">
            <div class="col-md-4 text-center">
                <h1>PRJ321x</h1>
                <h5>Welcome to my website</h5>
            </div>
            <div class="col-md-8 ">
                <form class="form-inline row" method="post" action="SearchController2">
                    <select class="form-control  col-md-3 col-lg-2 ">
                        <option selected="selected">Categories</option>
                        <option>Option1</option>
                        <option>Option2</option>
                        <option>Option3</option>
                    </select>
                    <input class="form-control  col-sm-7" type="text" name="s"
                        placeholder="What are you locking for?">
                    <input class="btn btn-success  " type="submit" value="Search">
                </form>
            </div>
        </header>

        <!--Thanh điều hướng và đăng ký, đăng nhập tài khoản-->
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a href="ListController" class="navbar-brand">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item"><a href="#" class="nav-link">Products</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">About Us</a></li>

                </ul>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item "><a href="Account?action=login" class="nav-link">Login</a></li>
                    <li class="nav-item "><a href="Account?action=register" class="nav-link">Register</a></li>

                </ul>
            </div>

        </nav>

    </div>


<%-- 
</body>
</html>
--%>