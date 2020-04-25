<%-- 
    Document   : patient
    Created on : Apr 20, 2020, 4:24:44 PM
    Author     : gratsiella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Patient page</title>

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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
    <link href="${pageContext.request.contextPath}/css/chosen.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/patient.css"  type="text/css"rel="stylesheet">


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
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/registerForm">Sign Up</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/loginForm">Login</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
                        <li role="presentation"><a href="#"> <i class="fa fa-user"></i> &nbsp; ${user.UName} ${user.USurname}</a></li>
                    </ul>
                </ul>
            </div>
        </div>
    </div>
</nav>





<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="blogs">
                <div class="text-center">
                    <h2>Patient's Page</h2>
                    <p>
                        As a patient using the e-Med-Help application, you have many benefits:
                        <br>
                        - Communication with a General Practitioner via <b>Video Call</b>.
                        <br>
                        - <b>Symptoms search engine</b>, which returns possible diagnosis.
                    </p>
                </div>
            </div>
        </div>
    </div>
    <hr>
</div>


<div class="container">
    <div class="row">
        <div class="col-md-3 bg-secondary d-flex">

            <div class="patient-info align-items-center justify-content-center"
                 style="justify-content: center; display: flex;">
                <i class="fa fa-user fa-fw fa-2x pull-left"></i>
                <span class="fa-2x text-center" style="padding-left:0.3em">User's Name</span>
            </div>

            <ul class="nav nav-sidebar text-center">

                <li><a href="" data-toggle="modal" data-target="#medicalInput">
                    <i class="fas fa-clipboard fa-fw pull-left"></i>Medical History</a></li>
                <li><a class="sidebar-header" data-toggle="collapse" href="#message">
                    <i class="fas fa-mail-bulk fa-fw pull-left"></i>Messsages<span
                        class="badge badge-pill badge-info pull-right">5</span></a></li>
                <div class="collapse text-left" id="message">
                    <li><a href=""><i class="fa fa-envelope fa-fw"></i>From Doctor<span
                            class="badge badge-pill badge-info pull-right">3</span></a></li>
                    <li><a href=""><i class="fa fa-envelope fa-fw"></i>From Pharmacy<span
                            class="badge badge-pill badge-info pull-right">2</span></a></li>
                </div>

            </ul>


            <!-- Modal -->
            <div class="modal fade" id="medicalInput" tabindex="-1" aria-hidden="true">
                <!-- role="dialog"  -->
                <div class="modal-dialog modal-dialog-centered">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h2 class="modal-title text-center">Update Your Medical History</h2>
                        </div>
                        <div class="modal-body">
                            <p>You can update your medical history either by <b>uploading a file</b> or by
                                <b>writing</b></p>
                            <form role="form">
                                <div class="form-group">
                                    <label path="medFile" for="med-file">Upload file:</label>
                                    <input id="med-file" class="form-control" type="file" name="med-file"
                                           path="medFile"/>
                                </div>
                                <div class="form-group">
                                    <label path="medText" for="med-text">Write:</label>
                                    <textarea id="med-text" class="form-control" type="text" name="med-text"
                                              rows="7" path="medText"></textarea>
                                </div>
                                <div class="text-center">
                                    <input name="med-submit" path="med-submit" id="med-submit" class="btn btn-primary"
                                           type="submit" value="Submit"/>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <div class="col-md-9">


            <canvas id="canvas" style="width: 100%; height: 400px;" class="border border-dark w-100 bg-info">
                <!--TODO Video Call-->
            </canvas>
        </div>
    </div>

    <div class="container" id="symptomChecker">
        <div class="row" style="justify-content: center; display: flex;">
            <div class="col-md-6 bg-light p-4 rounded mt-5">
                <h5 class="text-light text-center bg-success mb-2 p-2 rounded lead" id="result">Hello World!</h5>
                <div class="progress mb-3 rounded"
                     style="height: 40px; justify-content: center; align-content: center;">
                    <div class="progress-bar bg-danger" role="progressbar" style="width: 15%;" id="progressBar">
                        <b class="lead" id="progressText">Step-1</b>
                    </div>
                </div>
                <form action="" method="post" id="form-data"></form>
                <div id="tab-1">
                    <h4 class="text-center bg-primary p-1 rounded text-light">Sex & Age</h4>
                    <div class="form-group">
                        <div>
                            <label>Sex:</label>
                        </div>

                        <div class="btn-group btn-group-toggle" data-toggle="buttons"
                             style="display: flex; justify-content: space-around; align-content: center;">
                            <ul>
                                <li class="btn btn-light active btn-lg-01" style="margin-right: 40px;">
                                    <input type="radio" name="gender" id="male" autocomplete="off" value="male" checked
                                           class="gender">
                                    <img src="${pageContext.request.contextPath}/img/male-solid.svg" alt="Male">
                                </li>

                                <li class="btn btn-light btn-lg-01">
                                    <input type="radio" name="gender" id="female" autocomplete="off" value="female"
                                           class="gender">
                                    <img src="${pageContext.request.contextPath}/img/female-solid.svg" alt="Female">
                                </li>

                            </ul>
                        </div>


                    </div>
                    <div class="form-group">
                        <label for="age">Age:</label>
                        <input id="age" class="form-control" type="number" name="age" value="30">
                    </div>
                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;">
                        <a class="btn btn-primary" id="next-1">Next</a>
                    </div>
                </div>
                <div id="tab-2">
                    <h4 class="text-center bg-primary p-1 rounded text-light">Demographics & History</h4>


                    <div class="form-check m-2">
                        <input id="p_6" class="form-check-input risk" type="checkbox" name="" value="p_6">
                        <label for="p_6" class="form-check-label font-weight-bolder">BMI below 19</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_7" class="form-check-input risk" type="checkbox" name="" value="p_7">
                        <label for="p_7" class="form-check-label font-weight-bolder">BMI over 30</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_8" class="form-check-input risk" type="checkbox" name="" value="p_8">
                        <label for="p_8" class="form-check-label font-weight-bolder">Hypertension</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_9" class="form-check-input risk" type="checkbox" name="" value="p_9">
                        <label for="p_9" class="form-check-label font-weight-bolder">High cholesterol</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_10" class="form-check-input risk" type="checkbox" name="" value="p_10">
                        <label for="p_10" class="form-check-label font-weight-bolder">Smoking</label>
                    </div>

                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;">
                        <a class="btn btn-primary" id="prev-2">Previous</a>
                        <a class="btn btn-primary" id="next-2">Next</a>
                    </div>
                </div>
                <div id="tab-3">
                    <h4 class="text-center bg-primary p-1 rounded text-light">Geographical location</h4>

                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_13"><span
                                style="margin-left: 30px;">North
                                        America without Mexico</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_14"><span
                                style="margin-left: 30px;">Latin
                                        and South America</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio" value="p_15"
                                                                 checked><span style="margin-left: 30px;">Europe</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_16"><span
                                style="margin-left: 30px;">Northern Africa</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_17"><span
                                style="margin-left: 30px;">Central
                                        Africa</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_18"><span
                                style="margin-left: 30px;">Southern Africa</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_19"><span
                                style="margin-left: 30px;">Australia and Oceania</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_20"><span
                                style="margin-left: 30px;">Russia,
                                        Kazakhstan and Mongolia</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio"
                                                                 value="p_21"><span
                                style="margin-left: 30px;">Middle
                                        East</span></label>
                    </div>
                    <div class="radio">
                        <label class="font-weight-bolder"><input class="geo" type="radio" name="optradio" value="p_236"><span
                                style="margin-left: 30px;">Asia
                                        excluding Middle East, Russia, Kazakhstan and Mongolia</span></label>
                    </div>

                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;">
                        <a class="btn btn-primary" id="prev-3">Previous</a>
                        <a class="btn btn-primary" id="next-3">Next</a>
                    </div>
                </div>
                <div id="tab-4">
                    <h4 class="text-center bg-primary p-1 rounded text-light">Symptoms</h4>

                    <div class="form-check m-2">
                        <input id="p_147" class="form-check-input risk" type="checkbox" name="" value="p_147">
                        <label for="p_147" class="form-check-label font-weight-bolder">Physical injury</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_144" class="form-check-input risk" type="checkbox" name="" value="p_144">
                        <label for="p_144" class="form-check-label font-weight-bolder">Abdominal trauma</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_145" class="form-check-input risk" type="checkbox" name="" value="p_145">
                        <label for="p_145" class="form-check-label font-weight-bolder">Acceleration-deceleration
                            injury</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_146" class="form-check-input risk" type="checkbox" name="" value="p_146">
                        <label for="p_146" class="form-check-label font-weight-bolder">Back injury</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_74" class="form-check-input risk" type="checkbox" name="" value="p_74">
                        <label for="p_74" class="form-check-label font-weight-bolder">Craniocerebral trauma</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_136" class="form-check-input risk" type="checkbox" name="" value="p_136">
                        <label for="p_136" class="form-check-label font-weight-bolder">Skeletal trauma, chest</label>
                    </div>
                    <div class="form-check m-2">
                        <input id="p_53" class="form-check-input risk" type="checkbox" name="" value="p_53">
                        <label for="p_53" class="form-check-label font-weight-bolder">Skeletal trauma, limb</label>
                    </div>

                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;">
                        <a class="btn btn-primary" id="prev-4">Previous</a>
                        <a class="btn btn-primary" id="next-4">Next</a>
                    </div>

                </div>
                <div id="tab-5">
                    <h4 class="text-center bg-primary p-1 rounded text-light">Symptoms</h4>
                    <div class="form-group">
                        <label for="initialSymnptoms">Primary Symptoms</label>
                        <select id="initialSymnptoms" multiple name="initialSymnptoms" class="form-control"></select>
                    </div>


                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;">
                        <a class="btn btn-primary" id="prev-5">Previous</a>
                        <a class="btn btn-primary" id="next-5">Next</a>
                    </div>
                </div>
                <div id="tab-6">
                    <h4 class="text-center bg-primary p-1 rounded text-light" id="resultTitle">Questions</h4>
                    <div class="form-group" id="questions">
                        <!-- fill by js -->

                    </div>

                    <div class="form-group d-flex" style="justify-content: space-between; display: flex;" id="lastBtns">
                        <a class="btn btn-primary" id="prev-6">Previous</a>
                        <a class="btn btn-primary" id="next-6">Next</a>
                    </div>


                    <div class="form-group d-flex" style="justify-content: center; display: flex;" id="startBtn">
                        <a class="btn btn-primary" id="prev-7">Start</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<hr/>

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
                    <li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest fa-1x"></i></a>
                    </li>
                    <li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus fa-1x"></i></a>
                    </li>
                </ul>
            </div>
        </div>

        <a href="" class="scrollup"><i class="fa fa-chevron-up"></i></a>


    </div>
</footer>






<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fliplightbox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/contactform/contactform.js"></script>
<script src="${pageContext.request.contextPath}/js/chosen.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/patient.js"></script>


</body>
</html>
