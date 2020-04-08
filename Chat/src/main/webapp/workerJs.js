
    var jsonParser;
    if (typeof (EventSource) !== "undefined") {
        var source = new EventSource("ChatServlet");
        source.onmessage = function (event) {

            jsonParser = JSON.parse(event.data);


            postMessage(jsonParser);
        };
    } else {
        document.getElementById("table").innerHTML = "Sorry, your browser does not support server-sent events...";
    }


