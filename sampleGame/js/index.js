$(window).on("load", function () {
  $("#create-room").click(function () {
    $.get(
      "http://192.168.191.104:8080/Createroom", // url
      function (data, textStatus, jqXHR) {
        // success callback
        window.location.href =
          "http://localhost:8081/game.html?roomId=" + data.roomId;
      }
    );
  });
});
