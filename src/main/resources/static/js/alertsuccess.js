
// On click of Submit buttons, the required elements of the form are checked.
// If they are filled out, a message box pops out.On Press of OK, the form is submitted.

$(document).ready(
    function () {
        $('#submitbtn').on('click', () => {
            var f = document.getElementsByTagName('form')[0];
            var form = $(this).parents('form');
            if (f.checkValidity()) {
                event.preventDefault();
                Swal.fire(
                    'Registration successful!',
                    'Click OK to proceed to home page.',
                    'success'
                ).then(function () {

                    $('#form').submit();

//                    location.reload();
                });
            }

        });
    });



$(document).ready(
    function () {
        $('#checkout').on('click', () => {


                event.preventDefault();
                Swal.fire(
                    'Order successful!',
                    'Billing sent to patient.',
                    'success'
                ).then(function () {



                  location.reload();
                });


        });
    });