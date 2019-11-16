<%@ page pageEncoding="UTF-8" %>
<%@ include file="../jspf/directive/page.jspf" %>
<%@ include file="../jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<c:set var="title" value="Register" scope="page"/>
<%@ include file="../jspf/head.jspf" %>

<body>
<%@ include file="../jspf/header.jspf" %>
<section id="registration" class="registration">
    <div class="container h-100">
        <div class="row my-auto h-100">
            <div class="col-sm-11 col-md-10 col-lg-10 mx-auto my-auto">
                <div class="card card-signin">
                    <div class="card-body">
                        <h5 class="card-title text-center">Sign Up</h5>
                        <form class="form-signin active-purple-4" action="${root}/controller" method="post">
                            <div class="form-content">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-label-group">
                                            <input type="email" id="email" name="email" class="form-control" placeholder="Email"
                                                   required autofocus>
                                            <label for="email">Email</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="text" id="userLogin" name="login" class="form-control" placeholder="Login">
                                            <label for="userLogin">Login</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="password" id="userPassword" name="password" class="form-control" placeholder="Password"
                                                   required>
                                            <label for="userPassword">Password</label>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-label-group">
                                            <input type="email" id="name" name="name" class="form-control" placeholder="Name">
                                            <label for="name">Name</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="text" id="surname" name="surname" class="form-control" placeholder="Surname">
                                            <label for="surname">Surname</label>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="password" id="tel" name="telephone" class="form-control" placeholder="Telephone">
                                            <label for="tel">Telephone</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-label-group">
                                        <input type="file" id="img" name="img" class="form-control" placeholder="Select an image">
                                        <label for="img">Select an image (optional)</label>
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in
                                    </button>
                                    <div class="text-center">
                                        <a href="login.jsp">Hane an account? Log In</a>
                                    </div>
                                </div>
                                <c:if test="${not empty loginError}">
                                    <p class="text-danger"><c:out value="${loginError}"/></p>
                                </c:if>
                            </div>
                            <input type="hidden" name="command" value="login"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="../jspf/footer.jspf" %>
</body>
</html>
