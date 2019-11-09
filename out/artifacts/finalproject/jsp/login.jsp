<%--
  Created by IntelliJ IDEA.
  User: Elfa
  Date: 11/1/2019
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<header id="header" class="header fixed-top">
    <div class="container">
        <div class="row shadow p-3 mb-5 bg-white rounded">
            <div class="col-lg-4 my-auto">
                <img src="logo_eng.png" alt="ParadiseTravel" class="img-fluid w-100">
            </div>
            <div class="col-lg-3 my-auto">
                <form class="form-inline">
                    <div class="input-group border rounded-pill p-0">
                        <input type="search" placeholder="Search..." class="form-control bg-none border-0">
                        <div class="input-group-append border-0">
                            <button type="submit" class="btn btn-link"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-5 my-auto">
                <nav>
                    <ul class="menu d-flex justify-content-center">
                        <li class="menu_item">
                            <a href="#">Search</a>
                        </li>
                        <li class="menu_item">
                            <a href="#">Log In</a>
                        </li>
                        <li class="menu_item">
                            <a href="#">Sign Up</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</header>
<section id="picture" class="picture">
    <div class="container-fluid">
        <div class="row no-gutters">
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel" data-slide-to="1"></li>
                    <li data-target="#carousel" data-slide-to="2"></li>
                    <li data-target="#carousel" data-slide-to="3"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="norway.jpg" alt="Norway">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Norway</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="italy.jpg" alt="Italy">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Italy</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="maldives.jpg" alt="Maldives">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Maldives</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="greece.jpg" alt="Greece">
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
        <div class="row shadow p-3 mb-5 bg-white rounded">
            <form action="#">
                <div class="form-group">
                    <div class="row">
                        <select name="country" class="browser-default custom-select mb-3 col-lg-3 my-auto">
                            <option selected>Сountry</option>
                            <option value="Norway">Norway</option>
                            <option value="Greece">Greece</option>
                            <option value="Maldives">Maldives</option>
                            <option value="Italy">Italy</option>
                        </select>

                        <select name="month" class="browser-default custom-select mb-3 col-lg-3 my-auto">
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

                        <select name="sort" class="browser-default custom-select mb-3 col-lg-3 my-auto">
                            <option selected value="by date">Sort By Date</option>
                            <option value="by price asc">Price Low to High</option>
                            <option value="by price desc">Prive High to Low</option>
                            <option value="by name">Sort By Name</option>
                        </select>

                        <input type="submit" value="Search" class="btn btn-primary col-lg-3 my-auto">
                    </div>
                    <div class="row">
                        <select name="category" class="browser-default custom-select mb-3 col-lg-3">
                            <option selected>All Categories</option>
                            <option value="excursion">Excursion</option>
                            <option value="recreation">Recreation</option>
                            <option value="shopping">Shopping</option>
                        </select>

                        <input name="people" type="text" value="Number of People" class="form-control col-lg-3">
                        <input name="people" type="text" value="Max Price" class="form-control col-lg-3">
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<section id="destination2" class="destination">
    <div class="container">

    </div>
</section>
<footer id="footer" class="footer">
    <div class="container">
        <p class="text-center">Created by Ekaterina Mironova, November 2019</p>
    </div>
</footer>
</body>
</html>
