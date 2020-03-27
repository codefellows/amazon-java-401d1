var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    // to get a room list
    // $.get("/rooms").then(displayRooms);
    // use a specific room on stompClient.subscribe('/topic/room9')

    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        //the line that would allow you to set up rooms
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
//        stompClient.post('/topic/greeting', handleGreeting);
//@PostMapping("/topic/greeting")
//public String handleGreeting();
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
console.log('greeting happenin');
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function goodbye() {
    stompClient.send("/app/goodbye", {}, JSON.stringify({
        'byeName' : $('#byeName').val(),
        'miss' : $('#miss').val()
    }))
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#goodbye").click(function() { goodbye() });
    $( "#send" ).click(function() { sendName(); });
});

