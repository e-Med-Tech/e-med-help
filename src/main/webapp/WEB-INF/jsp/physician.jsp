<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <meta name="description" content="">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
        <title>e-Med-Help Physician page</title>

        <!-- Bootstrap -->

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.bxslider.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/set1.css" />
        <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src='https://cdn.scaledrone.com/scaledrone.min.js' type='text/javascript'></script>
        <script src="/js/physician.js" type="text/javascript"></script>

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
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target=".navbar-collapse.collapse">
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

        <div class="container">
            <div class="row">

                <div>

                    <video id="localVideo" autoplay muted width="320" height="240"></video>
                    <video id="remoteVideo" autoplay></video>


                </div>
            </div>


            <div class="row">

                <div>
                    <div class="ficon features">
                        <a href="${pageContext.request.contextPath}/physician/medical-history" class="btn btn-default" target="_blank" role="button"><b> View Patient's files</b></a>

                        <a href="${pageContext.request.contextPath}/physician/prescription" class="btn btn-default" role="button"><b> Send Prescription</b></a>

                        <a href="#" class="btn btn-default" role="button" id="phStart" onclick="physicianStart()">
                            <i style="color: #0f0f0f" class="fa fa-video-camera"></i><b>&nbsp; Accept call</b></a>

                        <a href="#" class="btn btn-default" role="button" id="phClose" onclick="physicianClose()">
                            <i style="color: red" class="fa fa-stop"></i><b>&nbsp; Terminate call</b></a>
                    </div>
                </div>
            </div>


        </div>
        <div class="container">
            <div class="row">
                <div>
                    <div class="ficon features">
                        <a href="#" class="btn btn-danger" role="button" id="changeStatus"
                            onclick="change()">Offline</a>


                    </div>
                </div>

            </div>
        </div>
        <div class="container">
            <div class="row">
                <div style="text-align:center;color:green;font-size:20px;" id="messageText">
                    There's a patient waiting in the Conference Room. Please Connect
                </div>

            </div>
        </div>



        <footer>
            <div class="inner-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 f-about">
                            <a href="${pageContext.request.contextPath}/contact">
                                <h1>About us</h1>
                            </a>
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
                            <li><a href="#" data-placement="top" title="Facebook"><i
                                        class="fa fa-facebook fa-1x"></i></a></li>
                            <li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter fa-1x"></i></a>
                            </li>
                            <li><a href="#" data-placement="top" title="Linkedin"><i
                                        class="fa fa-linkedin fa-1x"></i></a></li>
                            <li><a href="#" data-placement="top" title="Pinterest"><i
                                        class="fa fa-pinterest fa-1x"></i></a>
                            </li>
                            <li><a href="#" data-placement="top" title="Google plus"><i
                                        class="fa fa-google-plus fa-1x"></i></a>
                            </li>
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

    </body>

    </html>