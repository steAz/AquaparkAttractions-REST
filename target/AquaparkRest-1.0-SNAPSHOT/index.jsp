<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
         <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <meta charset="utf-8">
        <link rel="Stylesheet" href="styles.css" />
        <title>Aquapark, mapy, pogoda</title>
    </head>
    <body>
        <div id="dokument2"> 
        
            <div id="naglowek"> </div>
             <div id="tloKolor"> 
            
            <div id="menu">

                    <h2>INFORMACJE</h2>
                    <ol>

                        <li><a href="index.jsp"><b>Strona startowa</b></a></li>
                        <li>
                            <a href="Attractions.htm"><b>Atrakcje</b></a>
                        </li>
                        <li>
                            <a href="Weather.htm"><b>Pogoda</b></a>
                        </li>
                        
                        <li>
                            <a href="Distance.htm"><b>Droga do Aquaparku</b></a>
                        </li>

                    </ol>
            </div>
                
                  <div id="tresc">
                <h1><i>Opis  </i></h1>
                <br />
                <br />
                
                <p>
                    <b>
                        Aquapark w Suwałkach jest największym otwartym obiektem tego typu w Polsce i jednym z największych w Europie.
                        Zaprasza swoich gości każdego dnia w godzinach 8.00-22.00. Aquapark oferuje siedem basenów o powierzchni ponad 2500 m2 oraz liczne atrakcje. 
                        Możliwe jest również skorzystanie z zajęć zorganizowanych(aquaaerobik), a także 30 zjeżdżalni pojedynczych i 5 familijnych. 
                        Niedawno w aquaparku został otwarty basen ze sztuczną falą, który daje wrażenie kąpieli w morzu lub jeziorze. Aquapark oferuje największą w Europie wodną kulę o średnicy 2,5 metrów. Baseny są utrzymywane we wzorowej czystości dzięki najnowocześniejszej technologii z zastosowaniem ozonu, która dodatkowo minimalizuje przykry zapach. Temperatura wody to około 30 stopni Celsjusza. 
                        Głębokość basenów waha się od 60 cm do 1,4 m.
                        

                    </b>
                </p>
            </div>
                               
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAOrA_gaunB6Vf7MHoSUpUO9uNSya5paNU&callback=initMap" async defer></script> 
                         
                <script>
                    var map;
                    function initMap() {
                        map = new google.maps.Map(document.getElementById('mapCanvas'), {
                           center: {lat: 54.113214, lng: 22.937447},
                           zoom: 17
                         });
                    }
                    
                   google.maps.event.addDomListener(window, 'load', initMap);
                </script>
                 
             <div id="mapCanvas"></div>
             <div id="footer">
                <h3 class="mail"><i><a href="mailto:kazanov18@wp.pl">Jeśli masz jakikolwiek problem, napisz</a></i></h3>
                &copy; MK
            </div>
        </div> 
     </div>  
       
                   
    </body>
</html> 
