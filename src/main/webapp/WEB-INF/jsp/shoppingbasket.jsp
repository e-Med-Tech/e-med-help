<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
    <meta name="description" content="">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
    <title>e-Med-Help Order medicine page</title>

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
    <link href="${pageContext.request.contextPath}/css/basket.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
<br>
<br>

<main>
    <div class="basket">
        <div class="basket-module">
            <label for="promo-code">Enter a promotional code</label>
            <input id="promo-code" type="text" name="promo-code" maxlength="5" class="promo-code-field">
            <button class="promo-code-cta">Apply</button>
        </div>
        <div class="basket-labels">
            <ul>
                <li class="item item-heading">Item</li>
                <li class="price">Price</li>
                <li class="quantity">Quantity</li>
                <li class="subtotal">Subtotal</li>
            </ul>
        </div>
        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://www.i-eidisi.com/wp-content/uploads/2017/02/xanax-25.jpg" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x XANAX TAB 0,25MG</strong><br> TAB ΒΤ x 100</h1>
                    <p>Product Code - 232321939</p>
                </div>
            </div>
            <div class="price">25.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>
        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://5.imimg.com/data5/HH/UK/KO/SELLER-16645300/2-500x500.jpg" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x LAMICTAL TAB 0,20MG</strong><br> TAB ΒΤ x 30</h1>
                    <p>Product Code - 232321940</p>
                </div>
            </div>
            <div class="price">50.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>

        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://www.loyal-pharmacist.com/wp-content/uploads/2019/03/Prozac-Fluoxetine.jpg" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x PROZAC TAB 0,20MG</strong><br> TAB ΒΤ x 28</h1>
                    <p>Product Code - 232321941</p>
                </div>
            </div>
            <div class="price">30.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>
        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://documedis.hcisolutions.ch/2019-01/api/products/image/PICFRONT3D/productnumber/26319/350" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x SEROPRAM TAB 0,20MG</strong><br> Packaging Size: 14 Tablet</h1>
                    <p>Product Code - 232321942</p>
                </div>
            </div>
            <div class="price">10.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>

        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://www.officerock.com/media/catalog/product/cache/1/image/500x500/9df78eab33525d08d6e5fb8d27136e95/1/_/1_48_1.jpg" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x PONSTAN TAB 0,50MG</strong><br> Packaging Size: 20 Tablet</h1>
                    <p>Product Code - 232321943</p>
                </div>
            </div>
            <div class="price">20.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>

        <div class="basket-product">
            <div class="item">
                <div class="product-image">
                    <img src="https://www.florfarma.com/images/com_hikashop/upload/claripen.png" alt="Placholder Image 2" class="product-frame">
                </div>
                <div class="product-details">
                    <h1><strong><span class="item-quantity"></span> x claripen TAB 0,50MG</strong><br> Packaging Size: 21 Tablet</h1>
                    <p>Product Code - 232321944</p>
                </div>
            </div>
            <div class="price">40.00</div>
            <div class="quantity">
                <input type="number" value="0" min="0" class="quantity-field">
            </div>
            <div class="subtotal">0.00</div>

        </div>

    </div>
    <aside>
        <div class="summary">
            <div class="summary-total-items"><span class="total-items"></span> Items in your Bag</div>
            <div class="summary-subtotal">
                <div class="subtotal-title">Subtotal</div>
                <div class="subtotal-value final-value" id="basket-subtotal">0.00</div>
                <div class="summary-promo hide">
                    <div class="promo-title">Promotion</div>
                    <div class="promo-value final-value" id="basket-promo"></div>
                </div>
            </div>




            <div class="summary-total">
                <div class="total-title">Total</div>
                <div class="total-value final-value" id="basket-total">0.00</div>
            </div>
            <div class="summary-checkout" >
                <a href="${pageContext.request.contextPath}/payment"><button class="checkout-cta">Send to patient for checkout</button></a>
            </div>

        </div>
    </aside>
</main>


<footer>
    <div class="inner-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4 f-about">
                    <a href="${pageContext.request.contextPath}/contact"><h1>About us</h1></a>
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
                    <p>Covid-19 has infected more than 1.9 million people and killed at least 119,000 worldwide,
                        according to Johns Hopkins University.</p>
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
<script src="${pageContext.request.contextPath}/js/shopping-basket.js"></script>

</body>

</html>

