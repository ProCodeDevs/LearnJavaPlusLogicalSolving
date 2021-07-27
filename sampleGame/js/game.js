var playerId = null;
var roomId = null;
function updateStatus() {
  $.get(
    "http://192.168.191.104:8080/status?roomId=" + roomId, // url
    function (data, textStatus, jqXHR) {
      if (playerId === "1" && data.playerOneTurn) {
        alert("Its my turn");
      }
      if (playerId === "2" && data.playerTwoTurn) {
        alert("Its my turn");
      }
    }
  );
}
function getStatusFromServer() {
  window.setInterval(function () {
    updateStatus(); /// call your function here
  }, 5000);
}
$(window).on("load", function () {
  var params = new URLSearchParams(window.location.search);
  roomId = params.get("roomId");
  $.get(
    "http://192.168.191.104:8080/join?roomId=" + roomId, // url
    function (data, textStatus, jqXHR) {
      // success callback
      if (data.serverComment !== "ROOM_FULL") {
        playerId = data.serverComment;
        getStatusFromServer();
      } else {
        $("#room-full").css("display", "block");
        $(".container").css("display", "none");
      }
    }
  );
});
