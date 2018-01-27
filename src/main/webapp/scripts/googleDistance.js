function getTransport(transport) {
    switch(transport) {
        case("car"):
            return "Samochód";
        case("bike"):
            return "Rower";
        case("state"):
            return "Komunikacja publiczna";
        case("onFoot"):
            return "Pieszo";
    }
}

function showDist() {
        var from = $('#yourCity').val();
        var transport = $('input[name=transport]:checked', '#distanceForm').val();
        if (transport === undefined) transport = "car";
        var units = $('input[name=units]:checked', '#distanceForm').val();
        if (units === undefined) units = "metresAndKilometres";
        $.getJSON("resources/attractions/googleDistance", {"from": from, "transport": transport, "units": units}, function (data) {
            if (data.rows[0].elements[0].distance !== null) {
                    var tableOfDistance= "<table style='height:20;'> <tr id='kolorwiersza'><th>Miasto startowe</th>";
                    tableOfDistance+="<th>Długość trasy</th>";
                    tableOfDistance+="<th>Środek transportu</th>";
                    tableOfDistance+="<th>Czas jazdy</th></tr>";
                    tableOfDistance+="<tr><th class='kolorkolumny'>" + data.originAddresses[0] +"</th>";
                    tableOfDistance+="<td>" + data.rows[0].elements[0].distance.humanReadable  + "</td>";
                    tableOfDistance+="<td>" + getTransport(transport) + "</td>";
                    tableOfDistance+="<td>" + data.rows[0].elements[0].duration.humanReadable + "</td></tr>";
                    tableOfDistance+="</table>";
                    document.getElementById("atrakcje").innerHTML = tableOfDistance;
            } 
            else {
                console.log('Napotkano problem z pobraniem miasta');
            }
        }).error(function (jqXHR) {
                console.log("iERROR " + jqXHR.responseText);
        });
}
