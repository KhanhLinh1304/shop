<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="bg-primary text-white py-5 bottom-header">
		<div class="container py-5">
			<h1>
				Best products & <br /> brands in our store
			</h1>
			<p>Trendy Products, Factory Prices, Excellent Service</p>
			<button type="button" class="btn btn-outline-light">Learn
				more</button>
			<button type="button"
				class="btn btn-light shadow-0 text-primary pt-2 border border-white">
				<span class="pt-1">Purchase now</span>
			</button>

		</div>
	</div>
	<section>
		<div class="container my-5">
			<header class="mb-4">
				<h3>New products</h3>
			</header>

			<div class="row">
				<c:forEach items="${products}" var="product">

					<div class="col-lg-3 col-md-6 col-sm-6 d-flex">
						<div class="card w-100 my-2 shadow-2-strong">
							<img src="${product.image}" class="card-img-top"
								style="aspect-ratio: 1/1" />
							<div class="card-body d-flex flex-column">
								<h5 class="card-title"><a style="color: black" href="detailController?idProduct=${product.idProduct}">${product.name}</a></h5>

								<p class="card-text">${product.price}</p>
								<div
									class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
									<a href="#!" class="btn btn-primary shadow-0 me-1">Add to
										cart</a> <a href="#!"
										class="btn btn-light border px-2 pt-2 icon-hover"><i
										class="fas fa-heart fa-lg text-secondary px-1"></i></a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>
	<!-- Products -->

</body>
</html>