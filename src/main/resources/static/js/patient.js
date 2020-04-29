$(document).ready(function () {
    $("#next-1").click(function () {
        $("#tab-1").hide();
        $("#tab-2").show();
        $("#progressBar").css("width", "25%");
        $("#progressText").html("Step-2");
    });
    $("#next-2").click(function () {
        $("#tab-3").show();
        $("#tab-2").hide();
        $("#progressBar").css("width", "40%");
        $("#progressText").html("Step-3");
    });
    $("#next-3").click(function () {
        $("#tab-4").show();
        $("#tab-3").hide();
        $("#progressBar").css("width", "60%");
        $("#progressText").html("Step-4");
    });
    $("#next-4").click(function () {
        $("#tab-5").show();
        $("#tab-4").hide();
        $("#progressBar").css("width", "80%");
        $("#progressText").html("Step-5");
    });
    $("#next-5").click(function () {
        $("#tab-6").show();
        $("#tab-5").hide();
        $("#progressBar").css("width", "100%");
        $("#progressText").html("Step-6");
        // obj = getmyObj();
        // $.ajax(post_diagnosis(obj));
        call();
    });
    $("#next-6").click(function () {
        // obj = alter_myObj(obj);
        // $.ajax(post_diagnosis(obj));
        callAgain();
    });
    $("#prev-2").click(function () {
        $("#tab-2").hide();
        $("#tab-1").show();
        $("#progressBar").css("width", "15%");
        $("#progressText").html("Step-1");
    });
    $("#prev-3").click(function () {
        $("#tab-3").hide();
        $("#tab-2").show();
        $("#progressBar").css("width", "25%");
        $("#progressText").html("Step-2");
    });
    $("#prev-4").click(function () {
        $("#tab-4").hide();
        $("#tab-3").show();
        $("#progressBar").css("width", "40%");
        $("#progressText").html("Step-3");
    });
    $("#prev-5").click(function () {
        $("#tab-5").hide();
        $("#tab-4").show();
        $("#progressBar").css("width", "60%");
        $("#progressText").html("Step-4");
    });
    $("#prev-6").click(function () {
        $("#tab-6").hide();
        $("#tab-5").show();
        $("#progressBar").css("width", "100%");
        $("#progressText").html("Step-5");
    });
    $("#prev-7").click(function () {
        $("#tab-6").hide();
        $("#tab-1").show();
        $("#progressBar").css("width", "15%");
        $("#progressText").html("Step-1");
    });
    $.getJSON("/json/symptoms.json", function (data) {
        // Symptoms option list for selects
        function getSymtoms(data) {
            let options = "";
            data.forEach(element => {
                options += `<option value="${element.id}">${element.common_name}</option>`;
            });
            return options;
        }

        const symptoms = getSymtoms(data);
        $("#initialSymnptoms").html(symptoms);
        $("#initialSymnptoms").chosen({
            width: '100%'
        });
    });
    let obj = {};
    let sourceObj ={};

    function call(){
        obj=getmyObj();
        $.ajax(post_diagnosis(obj));
    }
    function callAgain(){
        obj = alter_myObj(obj);
        $.ajax(post_diagnosis(obj));
    }

    function getmyObj() {
        const gender = $(".gender:checked").val();
        const age = $("#age").val();
        const risks = [];
        const unrisks = [];
        $(".risk:checked").each(
            function () {
                risks.push($(this).val());
            });
        $(".risk:not(:checked)").each(
            function () {
                unrisks.push($(this).val());
            }
        )
        const geo = $(".geo:checked").val();
        const initialSymptoms = $("#initialSymnptoms").val();
        const evidence = makeEvidence(initialSymptoms, risks, unrisks);
        const myObj = {
            "sex": " ",
            "age": 0,
            "evidence": " ",
            "extras": {"disable_groups": true, "enable_triage_5": true, "interview_mode": "default"}
        }
        myObj.evidence = evidence;
        myObj.sex = gender;
        myObj.age = age;
        console.log(myObj);
        return myObj;
    }

    function makeEvidence(first, second, third) {
        let evidence = [];
        for (let index = 0; index < first.length; index++) {
            const text = '{"id": "' + first[index] + '", "choice_id": "present", "initial": "true"}';
            evidence.push(JSON.parse(text));
        }
        for (let index = 0; index < second.length; index++) {
            const text = '{"id": "' + second[index] + '", "choice_id": "present"}';
            evidence.push(JSON.parse(text));
        }
        for (let index = 0; index < third.length; index++) {
            const text = '{"id": "' + third[index] + '", "choice_id": "absent"}';
            evidence.push(JSON.parse(text));
        }
        return evidence;
    }

    function alter_myObj(sourceObj) {
        const newObj = sourceObj;
        const itemId = $("#itemId").val();
        const itemChoice = $(".itemChoice:checked").val();
        const text = '{"id": "' + itemId + '", "choice_id": "' + itemChoice + '"}';
        newObj.evidence.push(JSON.parse(text));
        return newObj;
    }

    function post_diagnosis(myObj) {
        let settings = {
            url: "https://api.infermedica.com/v2/diagnosis",
            method: "POST",
            timeout: 0,
            headers: {
                "app_id": "bdbf9e91",
                "app_key": "f48d30305846a7898b986c9485415b5e",
                "Content-Type": ["application/json"],
                "Interview-Id": generateInterviewId(),
                "Dev-Mode": "true"
            },
            data: JSON.stringify(myObj),
            success: handleDiagnosis
        };
        return settings;
    }

    function handleDiagnosis(data) {
        let testData = data;
        fillQuestions(testData.question);
        let array = testData.conditions.length;
        if (testData.should_stop && array >= 3) {
            results(testData.conditions);
        }
    }

    function fillQuestions(q) {
        const str = `<h5 id="questionText">${q.text}</h5>
                <div class="btn-group d-flex" style="justify-content: space-between; display: flex;" role="group">
                    <input type="text" id ="itemId" value="${q.items[0].id}" hidden>
                    <div class="form-check-inline btn">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input itemChoice" name="question" value="${q.items[0].choices[0].id}">
                            ${q.items[0].choices[0].label}
                        </label>
                    </div>
                    <div class="form-check-inline btn">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input itemChoice" name="question" value="${q.items[0].choices[1].id}">
                            ${q.items[0].choices[1].label}
                        </label>
                    </div>
                    <div class="form-check-inline btn">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input itemChoice" name="question" value="${q.items[0].choices[2].id}">
                            ${q.items[0].choices[2].label}
                        </label>
                    </div>
                </div>`;
        $("#questions").empty().html(str);
        $("#lastBtns").show();
        $("#startBtn").hide();
    }

    function generateInterviewId() {
        let uuidv4 = function () {
            return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, c =>
                (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
            );
        };
        return this.interviewId = uuidv4();
    }

    function results(conditions) {
        let uls = "";
        conditions.forEach(condition => {
            let pos = ((condition.probability) * 100).toFixed(2);
            let id = condition.id;
            uls += `<li class="moreInfo list-group-item list-group-item-action>
                        <span class="font-weight-bold" style="font-size: larger; font-style: italic; font-weight: 70;">${condition.common_name}</span>
                        <span style="font-style: italic; text-align: right">${pos} %</span>
                    </li>`;
        })
        let list = '<p class="font-weight-bold">This is a list of possible conditions and the percentage:</p><div class="list-group">' + uls + '</div>';
        $("#resultTitle").empty().html("Conclusion");
        $("#questions").empty().html(list);
        $("#lastBtns").hide();
        $("#startBtn").show();
    }
});
var Sdrone1;
function patientStart() {

    $('#paClose').removeAttr('disabled');
    $('#paStart').attr('disabled', 'disabled');
    startChannel();
    showOnlinePatient();
}
function patientClose() {
    $('#paStart').removeAttr('disabled');
    $('#paClose').attr('disabled', 'disabled');
    disconnectPatient();
    closeChannel();
}
function showOnlinePatient() {

    Sdrone1 = new ScaleDrone('4HwAoJvexNnKycx2');
    const roomHash1 = "onlineRoom";

    const roomName = 'observable-' + roomHash1;
    room1 = Sdrone1.subscribe(roomName);
    room1.on('open', error => {
        if (error) {
            return console.error(error);
        }
        console.log('Successfully joined room');
    });
    room1.on('member_join', member => {
        members.push(member);
        $('#messageText').show();
    });


    room1.on('member_leave', ({id}) => {
        const index = members.findIndex(member => member.id === id);
        members.splice(index, 1);
        $('#messageText').hide();
    });
}
function disconnectPatient(){
    room1.unsubscribe();
    Sdrone1.close();
   
}
