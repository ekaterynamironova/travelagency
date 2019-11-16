<%@ page pageEncoding="UTF-8" %>
<%@ include file="../jspf/directive/page.jspf" %>
<%@ include file="../jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<c:set var="title" value="ParadiseTravel" scope="page"/>
<%@ include file="../jspf/head.jspf" %>

<body>
<%@ include file="../jspf/header.jspf" %>
<section id="picture" class="picture">
    <div class="container-fluid">
        <div class="row no-gutters">
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="${root}/img/norway.jpg" alt="Norway">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Norway</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${root}/img/italy.jpg" alt="Italy">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Italy</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${root}/img/maldives.jpg" alt="Maldives">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Maldives</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${root}/img/greece.jpg" alt="Greece">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Greece</h5>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</section>
<section id="search" class="search">
    <div class="container">
        <div class="shadow p-3 m-0 bg-white rounded navbar-fixed-top">
            <form action="${root}/controller" method="post">
                <input type="hidden" name="command" value="search"/>
                <div class="form-group">
                    <div class="row">
                        <select name="country" class="browser-default custom-select mb-0 col">
                            <option selected>Country</option>
                            <c:forEach var="country" items="${countries}">
                                <option value="${country.name}">${country.name}</option>
                            </c:forEach>
                        </select>

                        <select name="month" class="browser-default custom-select mb-0 col">
                            <option selected>Month</option>
                            <option value="January">January</option>
                            <option value="February">February</option>
                            <option value="March">March</option>
                            <option value="April">April</option>
                            <option value="May">May</option>
                            <option value="June">June</option>
                            <option value="July">July</option>
                            <option value="August">August</option>
                            <option value="September">September</option>
                            <option value="October">October</option>
                            <option value="November">November</option>
                            <option value="December">December</option>
                        </select>

                        <select name="sort" class="browser-default custom-select mb-0 col">
                            <option selected value="by date">Sort By Date</option>
                            <option value="by price asc">Price Low to High</option>
                            <option value="by price desc">Price High to Low</option>
                            <option value="by name">Sort By Name</option>
                        </select>

                        <input type="submit" value="Search" class="btn btn-primary mb-0 col">
                    </div>
                    <div class="row">
                        <select name="category" class="browser-default custom-select mb-0 col">
                            <option selected>All Categories</option>
                            <option value="excursion">Excursion</option>
                            <option value="recreation">Recreation</option>
                            <option value="shopping">Shopping</option>
                        </select>

                        <select name="stars" class="browser-default custom-select mb-0 col stars">
                            <option selected>All Stars</option>
                            <option value="1">
                                &#xf005; and better
                            </option>
                            <option value="2">
                                &#xf005;&#xf005; and better
                            </option>
                            <option value="3">
                                &#xf005;&#xf005;&#xf005; and better
                            </option>
                            <option value="4">
                                &#xf005;&#xf005;&#xf005;&#xf005; and better
                            </option>
                            <option value="5">
                                &#xf005;&#xf005;&#xf005;&#xf005;&#xf005;
                            </option>
                        </select>

                        <select name="food" class="browser-default custom-select mb-0 col">
                            <option selected>All Food Type</option>
                            <option value="OB">OB</option>
                            <option value="BB">BB</option>
                            <option value="HB">HB</option>
                            <option value="FB">FB</option>
                            <option value="AI">AI</option>
                        </select>

                        <input name="people" type="text" value="Number of People" class="form-control mb-0 col">
                        <input name="people" type="text" value="Max Price" class="form-control mb-0 col">
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<section id="tours" class="tours">
    <div class="container">
        <div class="row justify-content center">
            <c:forEach var="tour" items="${tours}">
                <c:choose>
                    <c:when test="${tour.lastMinute == true}">
                        <div class="col-lg-4 mb-5">
                            <div class="card border-danger text-danger shadow h-100 w-100">
                                <div class="card-header">
                                    <div class="col-lg-12">
                                        <p>HOT</p>
                                        <c:set var="minStar" scope="page" value="5"/>
                                        <c:forEach var="routeEntry" items="${tour.route}">
                                            <c:if test="${routeEntry.value.countStars < minStar}">
                                                <c:set var="minStar" scope="page"
                                                       value="${routeEntry.value.countStars}"/>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach var="star" begin="1" end="${minStar}" step="1">
                                            <i class="fa fa-star stars"></i>
                                        </c:forEach>
                                        <c:remove var="minStar" scope="page"/>
                                    </div>
                                </div>
                                <img class="card-img-top" src="${tour.imgPath}" alt="Tour img">
                                <div class="card-body text-danger">
                                    <h5 class="card-title">${tour.name}</h5>
                                    <p class="card-text">${tour.type.name()}</p>
                                    <p class="card-text">
                                        Cities:
                                        <c:forEach var="routeEntry" items="${tour.route}" varStatus="status">
                                            <c:if test="${!status.first}">
                                                <c:out value=", "/>
                                            </c:if>
                                            <c:out value="${routeEntry.value.city.name}" />
                                        </c:forEach>
                                    </p>
                                </div>
                                <div class="card-footer bg-transparent border-danger text-danger">${tour.price}</div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-lg-4 mb-5">
                            <div class="card shadow h-100 w-100">
                                <div class="card-header">
                                    <div class="col-lg-12">
                                        <c:set var="minStar" scope="page" value="5"/>
                                        <c:forEach var="routeEntry" items="${tour.route}">
                                            <c:if test="${routeEntry.value.countStars < minStar}">
                                                <c:set var="minStar" scope="page"
                                                       value="${routeEntry.value.countStars}"/>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach var="star" begin="1" end="${minStar}" step="1">
                                            <i class="fa fa-star stars"></i>
                                        </c:forEach>
                                        <c:remove var="minStar" scope="page"/>
                                    </div>
                                </div>
                                <img class="card-img-top" src="${tour.imgPath}" alt="Tour img">
                                <div class="card-body">
                                    <h5 class="card-title">${tour.name}</h5>
                                    <p class="card-text">${tour.type.name()}</p>
                                    <p class="card-text">
                                        Cities:
                                        <c:forEach var="routeEntry" items="${tour.route}" varStatus="status">
                                            <c:if test="${!status.first}">
                                                <c:out value=", "/>
                                            </c:if>
                                            <c:out value="${routeEntry.value.city.name}" />
                                        </c:forEach>
                                    </p>
                                </div>
                                <div class="card-footer bg-transparent">${tour.price}</div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</section>
<%@ include file="../jspf/footer.jspf" %>
</body>
</html>
