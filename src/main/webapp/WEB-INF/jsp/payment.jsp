<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
    <meta name="description" content="">

    <title>e-Med-Help payment page</title>

    <!-- Bootstrap -->

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/set1.css"/>
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/payment.css" rel="stylesheet">

    <!-- =======================================================
      Theme Name: eNno
      Theme URL: https://bootstrapmade.com/enno-free-simple-bootstrap-template/
      Author: BootstrapMade
      Author URL: https://bootstrapmade.com
    ======================================================= -->
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
            <a class="navbar-brand" href="#">
                <span>e-Med-Help</span>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <div class="menu">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation"><a href="#"> <i class="fa fa-user"></i>
                        &nbsp; ${user.UName} ${user.USurname}</a></li>
                    <li role="presentation"><a  href="${pageContext.request.contextPath}/"> <i class="fa fa-sign-out"></i>
                        Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<br>
<br>
<br>
<br>

<div class="box">
    <a class="button" href="#popup1">Confirmation button</a>
</div>

<div id="popup1" class="overlay">
    <div class="popup">
        <a class="close" href="#">&times;</a>
        <div class="content">
            Prescription confirmed, proceed to billing.
        </div>
    </div>
</div>

<div id="wrapper">
    <div class="row">
        <div class="col-xs-5">
            <div id="cards">
                <img src="http://icons.iconarchive.com/icons/designbolts/credit-card-payment/256/Visa-icon.png">
                <img src="http://icons.iconarchive.com/icons/designbolts/credit-card-payment/256/Master-Card-icon.png">
            </div><!--#cards end-->
            <div class="form-check">
                <label class="form-check-label" for="card">
                    <input id="card" class="form-check-input" type="radio" name="foo" value="1">
                    Pay with credit card
                </label>
            </div>
        </div><!--col-xs-5 end-->
        <div class="col-xs-5">
            <div id="cards">
                <img src="http://icons.iconarchive.com/icons/designbolts/credit-card-payment/256/Paypal-icon.png">
            </div><!--#cards end-->
            <div class="form-check">
                <label class="form-check-label" for="paypal">
                    <input id="paypal" class="form-check-input" type="radio" name="foo" value="2">
                    Pay with PayPal
                </label>
            </div>
        </div><!--col-xs-5 end-->
    </div><!--row end-->


    <div class="row">

        <div class="col-xs-5">
            <i class="fa fa fa-user"></i>
            <label for="cardholder">Cardholder's Name</label>
            <input type="text" id="cardholder">
        </div><!--col-xs-5-->
        <div class="col-xs-5">
            <i class="fa fa-credit-card-alt"></i>
            <label for="cardnumber">Card Number</label>
            <input type="text" id="cardnumber">
        </div><!--col-xs-5-->
    </div><!--row end-->
    <div class="row row-three">
        <div class="col-xs-2">
            <i class="fa fa-calendar"></i>
            <label for="date">Valid thru</label>
            <input type="text" placeholder="MM/YY" id="date">
        </div><!--col-xs-3-->
        <div class="col-xs-2">
            <i class="fa fa-lock"></i>
            <label for="date">CVV / CVC *</label>
            <input type="text">
        </div><!--col-xs-3-->
        <div class="col-xs-5">
            <span class="small"><b>* CVV or CVC is the card security code, unique three digits number on the back of your card seperate from its number.</b></span>
        </div><!--col-xs-6 end-->
    </div><!--row end-->
    <!-- </form> -->

    <footer>
        <div class="box2">
            <a class="button" href="#popup2">Billing</a>
        </div>

        <div id="popup2" class="overlay">
            <div class="popup2">
                <a class="close" href="#">&times;</a>
                <div class="content">
                    Prescription paid.
                </div>
            </div>
        </div>

    </footer>

</div><!--wrapper end-->




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fliplightbox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/contactform/contactform.js"></script>
<script src="${pageContext.request.contextPath}/js/alertsuccess.js"></script>

<script>
    $('input[type="checkbox"]').on('click',function(){
        var selected = $(this).parent().parent().parent();    $(selected).toggleClass('highlight');
    });
</script>
</body>
</html>
