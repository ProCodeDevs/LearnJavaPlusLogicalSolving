var playerId = null;
var roomId = null;
var round = null;

var isClickAllowed = false;

function updateStatus() {
  $.get("http://192.168.191.104:8080/status?roomId=" + roomId, writeStatus);
}
var writeStatus = function (data, textStatus, jqXHR) {
  if (playerId === "1" && data.playerOneTurn) {
    isClickAllowed = true;
  }
  if (playerId === "2" && data.playerTwoTurn) {
    isClickAllowed = true;
  }
  if (round !== data.roundStatus.length) {
    if (playerId == data.roundStatus[round]) {
      swal({
        title: "You winnnn !!!",
        icon: "success",
        button: "Nex round !",
      });
    } else if (data.roundStatus[round] == 0) {
      swal({
        title: "Math draw",
        icon: "question",
        button: "Nex round !",
      });
    } else {
      swal({
        title: "You lose !!!!",
        icon: "error",
        button: "Nex round !",
      });
    }
    round = data.roundStatus.length;
  }
};
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
        $("#player-id").text(playerId);
        round = data.roundStatus.length;
        getStatusFromServer();
      } else {
        $("#room-full").css("display", "block");
        $(".container").css("display", "none");
      }
    }
  );

  $(".selector-image").click(function (event) {
    if (!isClickAllowed) {
      return;
    }
    $("#image-holder-1").attr("src", "images/" + event.target.id + ".png");
    var moveId = 0;
    if (event.target.id === "stone") {
      moveId = 1;
    } else if (event.target.id === "paper") {
      moveId = 2;
    } else {
      moveId = 3;
    }

    $.get(
      "http://192.168.191.104:8080/move?roomId=" +
        roomId +
        "&playerId=" +
        playerId +
        "&moveId=" +
        moveId,
      writeStatus
    );
    isClickAllowed = false;
  });
});
