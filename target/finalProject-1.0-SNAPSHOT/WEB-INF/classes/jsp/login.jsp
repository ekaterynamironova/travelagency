<%@ page pageEncoding="UTF-8" %>
<%@ include file="../jspf/directive/page.jspf" %>
<%@ include file="../jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<c:set var="title" value="Login" scope="page"/>
<%@ include file="../jspf/head.jspf" %>

<body>
<%@ include file="../jspf/header.jspf" %>
<section id="login" class="login">
    <div class="container h-100">
        <div class="row my-auto h-100">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-auto">
                <div class="card card-signin">
                    <div class="card-body">
                        <h5 class="card-title text-center">Sign In</h5>
                        <form class="form-signin active-purple-4" action="${root}/controller" method="post">
                            <input type="hidden" name="command" value="login"/>
                            <div class="form-label-group">
                                <input type="text" id="userLogin" name="login" class="form-control" placeholder="Login"
                                       required autofocus>
                                <label for="userLogin">Login</label>
                            </div>

                            <div class="form-label-group">
                                <input type="password" id="userPassword" name="password" class="form-control" placeholder="Password"
                                       required>
                                <label for="userLogin">Password</label>
                            </div>
                            <c:if test="${not empty loginError}">
                                <p class="text-danger"><c:out value="${loginError}"/></p>
                            </c:if>

                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in
                            </button>

                            <div class="text-center">
                                <a href="register.jsp">Not registered? Create an account</a>
                            </div>
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
