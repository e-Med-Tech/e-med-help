<%-- 
    Document   : addUser
    Created on : Apr 17, 2020, 9:19:23 PM
    Author     : Natasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>e-Med-Help Homepage</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/jquery.bxslider.css">
        <link rel="stylesheet" type="text/css" href="css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/set1.css" />
        <link href="css/overwrite.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/signupform.css" rel="stylesheet">


        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- =======================================================
          Theme Name: eNno
          Theme URL: https://bootstrapmade.com/enno-free-simple-bootstrap-template/
          Author: BootstrapMade
          Author URL: https://bootstrapmade.com
        ======================================================= -->

        <style>
            .error{

                color: red;

            }
        </style>

        <Script>
            //alert button if passwords dont match
            $(document).ready(function () {
                $('#password2').on("focusout", function () {
                    $('#errorsign').remove();
                    if ($('#password1').val() !== $('#password2').val()) {
                        $('#submitbtn').attr("disabled", true);
                        $('#pass2label').prepend('<i id="errorsign" class="material-icons" style="font-size:15px;color:red"> Warning: Passwords do not match! </i>');
                    } else {
                        $('#submitbtn').removeAttr("disabled");
                    }
                });
            });

            //fernei boolean gia username
            $(document).ready(function () {
                var dd = $("#username");
                $(dd).on("focusout", function () {
                    var url = "/checkUsername/" + dd.val();
                    $('#errorsign1').remove();
                    $.ajax({
                        method: "POST",
                        url: url
                    }).then(function (data) {
                        if (data === true) {
                            $('#usernamelabel').prepend('<i id="errorsign1" class="material-icons" style="font-size:15px;color:red"> Warning: Username already exists! </i>');
                        }
                    });
                });
            });


        </script>

    </head>
</head>

<body>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">
                    <span>e-Med-Help</span>
                </a>
            </div>
            <div class="navbar-collapse collapse">
                <div class="menu">
                    <ul class="nav nav-tabs" role="tablist">
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation"><a href="/">Home</a></li>
                            <li role="presentation" class="active"><a href="/registerForm">Sign Up</a></li>
                            <li role="presentation"><a href="/loginForm">Login</a></li>
                            <li role="presentation"><a href="/contact">Contact</a></li>
                        </ul>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <div class="signup-form">

        <div class="form-group">

            <form:form method="POST" action="/addUser" modelAttribute="newUser">
                <h2>Sign Up</h2>
                <p class="hint-text">Create your account. It's free and only takes a minute.</p>
                <div class="row">
                    <div class="col-xs-6">
                        <form:label path="name">First Name</form:label>
                        <form:input class="form-control" type="text" path="name" name="first_name" placeholder="First Name" required="required"/>
                        <form:errors path="name" class="error"/>
                    </div>

                    <div class="col-xs-6">
                        <form:label path="surname">Last Name</form:label>
                        <form:input class="form-control" type="text" path="surname" name="last_name" placeholder="Last Name" required="required"/>
                        <form:errors path="surname" class="error"/>
                    </div>


                </div>


                <div class="form-group">

                    <form:label path="username" id="usernamelabel"> Username </form:label>
                    <form:input class="form-control" type="text" path="username" id="username" name="username" placeholder="Username" required="required"/>
                    <form:errors path="username" class="error"/>
                </div>


                <div class="form-group">

                    <form:label path="password1"> Password </form:label>
                    <form:input class="form-control" type="password" path="password1" id="password1" name="password" placeholder="Password" required="required"/>
                    <form:errors path="password1" class="error"/>
                </div>


                <div class="form-group" id="pass2div">
                    <form:label path="password2" id="pass2label"> Confirm Password </form:label>
                    <form:input class="form-control" type="password" path="password2" id="password2" name="confirm_password" placeholder="Confirm Password" required="required"/>
                    <form:errors path="password2" class="error"/>

                </div>   

                <div class="form-group">
                    <form:label path="role"> Role </form:label>
                    <form:select path="role"  class="form-control" id="select">
                        <c:forEach items="${roles}" var="ro">
                            <form:option value="${ro.roleId}">${ro.roleName}</form:option>
                        </c:forEach>
                    </form:select>
                </div>


                <div class="form-group">
                    <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
                </div>


                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block" id="submitbtn" value="Submit" disabled>Register Now</button>
                    <div class="text-center">Already have an account? <a href="/loginForm">Login here</a></div>
                </div>

            </div>
        </div>

    </form:form>


    <footer>
        <div class="inner-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 f-about">
                        <a href="index.html"><h1>About us</h1></a>
                        <q>Every day, more and more people in need of care are forced to delay, 
                            go without, or seek inappropriate care options. 
                            Our goal in founding e-Med-Help? 
                            Provide the solution to make healthcare work.
                            We’ve developed premium technology merged with quality healthcare to provide affordable, 
                            accessible care whenever needed.</q>
                        <br>
                        <b>From the Founding Team</b>
                    </div>
                    <div class="col-md-4 l-posts">
                        <h3 class="widgetheading">Latest Posts</h3>
                        <p>Covid-19 has infected more than 1.9 million people and killed at least 119,000 worldwide, according to Johns Hopkins University.</p>
                    </div>
                    <div class="col-md-4 f-contact">
                        <h3 class="widgetheading">Stay in touch</h3>
                        <a href="#">
                            <p><i class="fa fa-envelope"></i> e-med-help@gmail.com</p>
                        </a>
                        <p><i class="fa fa-phone"></i> +030 210 10 10 100</p>
                        <p><i class="fa fa-home"></i> e-Med-Help inc | Athens, Greece</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="last-div">
            <div class="container">
                <div class="row">
                    <div class="copyright">
                        &copy; eNno Theme. All Rights Reserved
                        <div class="credits">
                            <!--
                              All the links in the footer should remain intact. 
                              You can delete the links only if you purchased the pro version.
                              Licensing information: https://bootstrapmade.com/license/
                              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=eNno
                            -->
                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <ul class="social-network">
                        <li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook fa-1x"></i></a></li>
                        <li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter fa-1x"></i></a></li>
                        <li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin fa-1x"></i></a></li>
                        <li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest fa-1x"></i></a></li>
                        <li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus fa-1x"></i></a></li>
                    </ul>
                </div>
            </div>

            <a href="" class="scrollup"><i class="fa fa-chevron-up"></i></a>


        </div>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/jquery.bxslider.min.js"></script>
    <script type="text/javascript" src="js/fliplightbox.min.js"></script>
    <script src="js/functions.js"></script>


</body>
</html>