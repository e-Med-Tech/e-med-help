<%-- 
    Document   : physician
    Created on : Apr 18, 2020, 8:45:19 PM
    Author     : Natasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <meta name="description" content="">

        <title>e-Med-Help Homepage</title>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/css/animate.css" />
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/css/font-awesome.min.css" />
        <link rel="stylesheet" href="/css/jquery.bxslider.css" />
        <link rel="stylesheet" href="/css/normalize.css" />
        <link rel="stylesheet" href="/css/demo.css" />
        <link rel="stylesheet" href="/css/set1.css" />
        <link rel="stylesheet" href="/css/overwrite.css" />
        <link rel="stylesheet" href="/css/style.css" />




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
                    <a class="navbar-brand" href="index.html">
                        <span>e-Med-Help</span>
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <div class="menu">
                        <ul class="nav nav-tabs" role="tablist">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation"><a href="/">Home</a></li>
                                <li role="presentation"><a href="/registerForm">Sign Up</a></li>
                                <li role="presentation"><a href="/loginForm">Login</a></li>
                                <li role="presentation"><a href="/contact">Contact</a></li>
                            </ul>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>


        <div class="container" >
            <div class="row">

                <div>
                    <div class="videobox">Video box</div>

                </div>
            </div>


            <div class="container">
                <div class="row">

                    <div>
                        <div class="ficon features">
                            <a href="#" class="btn btn-default" role="button"><b> View Patient's files</b></a>

                            <a href="#" class="btn btn-default" role="button" onclick="sendPrescription()"><b> Send Prescription</b></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>




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



        <script type="text/javascript" src="/js/jquery-2.1.1.min.js" />





        <script type="text/javascript" src="/js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="/js/wow.min.js" ></script>
        <script type="text/javascript" src="/js/jquery.easing.1.3.js" ></script>
        <script type="text/javascript" src="/js/jquery.isotope.min.js" ></script>
        <script type="text/javascript" src="/js/jquery.bxslider.min.js" ></script>
        <script type="text/javascript" src="/js/fliplightbox.min.js" ></script>
        <script type="text/javascript" src="/js/functions.js" ></script>



    </body>
</html>

