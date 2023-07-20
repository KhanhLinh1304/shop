<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<header>
	<div class="top-mid-header">
		<!-- Jumbotron -->
		<div class="p-3 text-center bg-white border-bottom">
			<div class="container">
				<div class="row gy-3">
					<!-- Left elements -->
					<div class="col-lg-2 col-sm-4 col-4">
						<a href="web-home" target="_blank" class="float-start"> <img
							src="https://mdbootstrap.com/img/logo/mdb-transaprent-noshadows.png"
							height="35" />
						</a>
					</div>
					<!-- Left elements -->

					<!-- Center elements -->
					<c:set var="user" value="${sessionScope.account}"></c:set>
					<div class="order-lg-last col-lg-5 col-sm-8 col-8">
						<div class="d-flex float-end">
							<c:choose>
								<c:when test="${user!=null}">
									<a
										href="#"
										class="me-1 border rounded py-1 px-2 nav-link d-flex align-items-center"
										target="_blank"> <i class="fas fa-user-alt m-1 me-md-2"></i>
										<p class="d-none d-md-block mb-0">${user.getName()}</p>
									</a>

									<a
										href="logout"
										class="me-1 border rounded py-1 px-2 nav-link d-flex align-items-center"
										target="_blank"> <i class="fa fa-sign-out m-1 me-md-2"></i>
										<p class="d-none d-md-block mb-0">logout</p>
									</a>
									<a
										href="#"
										class="border rounded py-1 px-2 nav-link d-flex align-items-center"
										target="_blank"> <i
										class="fas fa-shopping-cart m-1 me-md-2"></i>
										<p class="d-none d-md-block mb-0">My cart</p>
									</a>
									
								
									
								</c:when>
								<c:otherwise>
									<a
										href="login"
										class="me-1 border rounded py-1 px-3 nav-link d-flex align-items-center"
										target="_blank"> <i class="fas fa-user-alt m-1 me-md-2"></i>
										<p class="d-none d-md-block mb-0">Login</p>
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<!-- Center elements -->

					<!-- Right elements -->
					<div class="col-lg-5 col-md-12 col-12">
						<form action="SearchController" method="post">
							<div class="input-group float-center">
								<div class="form-outline">
									<input type="input" id="form1" name="name" class="form-control" />
									<label class="form-label" for="form1">Search</label>
								</div>
								<button type="submit" class="btn btn-primary shadow-0">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form>
					</div>
					<!-- Right elements -->
				</div>
			</div>
		</div>
		<!-- Jumbotron -->

		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-light bg-white">
			<!-- Container wrapper -->
			<div
				class="container justify-content-center justify-content-md-between">
				<!-- Toggle button -->
				<button class="navbar-toggler border py-2 text-dark" type="button"
					data-mdb-toggle="collapse"
					data-mdb-target="#navbarLeftAlignExample"
					aria-controls="navbarLeftAlignExample" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-bars"></i>
				</button>

				<!-- Collapsible wrapper -->
				<div class="collapse navbar-collapse" id="navbarLeftAlignExample">
					<!-- Left links -->
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<c:forEach items="${categories}" var="category">
							<li class="nav-item"><a class="nav-link text-dark"
								aria-current="page"
								href="categoryController?idCategory=${category.idCategory}">${category.nameCategory}</a>
							</li>
						</c:forEach>

					</ul>

				</div>
			</div>
			<!-- Container wrapper -->
		</nav>
		<!-- Navbar -->

	</div>
	<!-- Jumbotron -->

	<!-- Jumbotron -->
</header>
