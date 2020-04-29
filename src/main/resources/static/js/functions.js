/* global members, on */
let pc;
var Sdrone;
let room;
let members = [];
var room1;
var room2;
(function ($) {

    $('#phClose').attr('disabled', 'disabled');
    $('#paClose').attr('disabled', 'disabled');
    $('#messageText').hide();
    var slider = $('.bxslider').bxSlider({
        mode: 'horizontal'
    });

    $('#reload-slider').click(function (e) {
        e.preventDefault();
        slider.reloadSlider({
            mode: 'fade',
            auto: true,
            pause: 1000,
            speed: 500
        });
    });

    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.scrollup').fadeIn();
        } else {
            $('.scrollup').fadeOut();
        }
    });
    $('.scrollup').click(function () {
        $("html, body").animate({
            scrollTop: 0
        }, 1000);
        return false;
    });

    wow = new WOW({}).init();




})(jQuery);
function sendPrescription() {
    var getInput = prompt("Write your prescription here: ");
    localStorage.setItem("storageName", getInput);
}

function showMessage() {
    alert(localStorage.getItem("storageName"));

}



function startChannel() {


    Sdrone = new ScaleDrone('qnc8mAellSgbcb5C');
    const roomHash = "conferenceRoom";

    const roomName = 'observable-' + roomHash;

    const configuration = {
        iceServers: [{
                urls: 'stun:stun.l.google.com:19302'
            }]
    };
    function onSuccess() {}
    ;
    function onError(error) {
        console.error(error);
    }
    ;


    Sdrone.on('open', error => {

        if (error) {
            console.log(" Error open drone >>");
            return console.error(error);
        }
        console.log(" Drone open >>");
        room = Sdrone.subscribe(roomName);
        room.on('open', error => {
            if (error) {
                onError(error);
            }
        });

        room.on('members', members => {
            console.log('MEMBERS', members);

            const isOfferer = members.length === 2;
            startWebRTC(isOfferer);
        });
    });


    function sendMessage(message) {
        console.log("Sending signal via scaledrone");
        Sdrone.publish({
            room: roomName,
            message
        });
    }

    function startWebRTC(isOfferer) {

        console.log('Starting WebRTC in as', isOfferer ? 'offerer' : 'waiter');
        pc = new RTCPeerConnection(configuration);

        pc.onicecandidate = event => {
            console.log("Send Message to Candidate");
            if (event.candidate) {
                sendMessage({'candidate': event.candidate});
            }
        };

        if (isOfferer) {
            console.log(" Create Offer ");
            pc.onnegotiationneeded = () => {
                pc.createOffer().then(localDescCreated).catch(onError);
            };
        }


        pc.ontrack = event => {
            console.log("Display remote video >>>");
            const stream = event.streams[0];
            console.log(" Stream : >>" + stream);
            if (!remoteVideo.srcObject || remoteVideo.srcObject.id !== stream.id)
                ;
            {
                remoteVideo.srcObject = stream;
            }
        };



        navigator.mediaDevices.getUserMedia({
            audio: true,
            video: true
        }).then(stream => {
            localVideo.srcObject = stream;

            stream.getTracks().forEach(track => pc.addTrack(track, stream));
        }, onError);


        room.on('data', (message, client) => {

            if (client.id === Sdrone.clientId) {
                return;
            }


            if (message.sdp) {

                pc.setRemoteDescription(new RTCSessionDescription(message.sdp), () => {

                    if (pc.remoteDescription.type === 'offer') {
                        pc.createAnswer().then(localDescCreated).catch(onError);
                    }
                }, onError);
            } else if (message.candidate) {

                pc.addIceCandidate(
                        new RTCIceCandidate(message.candidate), onSuccess, onError
                        );
            }

        });
    }

    function localDescCreated(desc) {
        pc.setLocalDescription(
                desc,
                () => sendMessage({'sdp': pc.localDescription}),
                onError
                );
    }
}



function closeChannel() {
    room.unsubscribe();

    const stream1 = localVideo.srcObject;
    const tracks1 = stream1.getTracks();

    tracks1.forEach(function (track) {
        track.stop();
    });

    localVideo.srcObject = null;
    remoteVideo.srcObject = null;
    pc.close();
    pc = null;


}
