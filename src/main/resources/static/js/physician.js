


var Sdrone2;

function change() {
    var btnc = document.getElementById('changeStatus');

    if (btnc.innerHTML === "Offline") {
        btnc.innerHTML = "Online";
        document.getElementById("changeStatus").classList.remove('btn-danger');
        document.getElementById("changeStatus").classList.add('btn-success');
        showOnlinePhysician();
    } else {
        btnc.innerHTML = "Offline";
        document.getElementById("changeStatus").classList.remove('btn-success');
        document.getElementById("changeStatus").classList.add('btn-danger');
        closeOnlinePhysician();
    }
}
function physicianStart() {
    $('#messageText').hide();
    $('#phClose').removeAttr('disabled');
    $('#phStart').attr('disabled', 'disabled');
    startChannel();
}
function physicianClose() {
    $('#phStart').removeAttr('disabled');
    $('#phClose').attr('disabled', 'disabled');
    closeChannel();
}
function showOnlinePhysician() {

    Sdrone2 = new ScaleDrone('4HwAoJvexNnKycx2');
    const roomHash2 = "onlineRoom";

    const roomName = 'observable-' + roomHash2;
    room2 = Sdrone2.subscribe(roomName);
    room2.on('open', error => {
        if (error) {
            return console.error(error);
        }
        console.log('Successfully joined room');
    });
    room2.on('member_join', member => {
        members.push(member);
        $('#messageText').show();
        
       
    });


    room2.on('member_leave', ({id}) => {
        const index = members.findIndex(member => member.id === id);
        members.splice(index, 1);
        $('#messageText').hide();

    });
}
function closeOnlinePhysician() {
    room2.unsubscribe();
    Sdrone2.close();

}
