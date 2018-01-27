/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aquaparkrest.resources;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.GeoApiContext;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import com.mycompany.aquaparkrest.logic.Attraction;
import com.mycompany.aquaparkrest.logic.Attractions;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.ws.rs.QueryParam;
import jersey.repackaged.com.google.common.collect.Lists;


/**
 * REST Web Service
 *
 * @author Kazanostra
 */
@Path("/attractions")
public class AttractionsResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
      
    
    @Context
    HttpServletResponse response;
    
    @Context
    ServletContext context;
    
    private static final GeoApiContext GOOGLE_CONTEXT = new GeoApiContext().setApiKey("AIzaSyAOrA_gaunB6Vf7MHoSUpUO9uNSya5paNU");
    
    public static final String ATTRACTION_CONTEXT = "attractionContext";
    
    List<String> definedOrder = Arrays.asList("LATWY", "SREDNI", "TRUDNY");
    Comparator<Attraction> comparator = new Comparator<Attraction>() {
        @Override
        public int compare(final Attraction o1, final Attraction o2){
            return Integer.valueOf(
                definedOrder.indexOf(o1.getDifficulty()))
                .compareTo(
                    Integer.valueOf(
                        definedOrder.indexOf(o2.getDifficulty())));
        }
    };
    
    
    /**
     * Creates a new instance of AtractionsResource
     */
    public AttractionsResource() {
    }
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Attraction> getAttractions(@QueryParam("sorting") String sorting) throws IOException {
            List<Attraction> attractions = getAttracionsContext().getLiOfAttractions();
            if (!sorting.equals("noSorting")) sortAttractions(attractions, sorting);
            return attractions;
    }
    
     private void sortAttractions(List<Attraction> attractions, String typeOfSorting) {
            switch (typeOfSorting) {
                    case "theEasiest":
                        Collections.sort(attractions, comparator);
                        break;
                    case "theHardest":
                        List<String> reverseDifficulties = Lists.reverse(definedOrder); 
                        definedOrder = reverseDifficulties;
                        Collections.sort(attractions, comparator);
                        break;
            }
    }
     
    @GET
    @Path("googleDistance")
    @Produces(MediaType.APPLICATION_JSON)
    public DistanceMatrix showDistance(
            @QueryParam("from") String cityFrom,
            @QueryParam("transport") String transport,
            @QueryParam("units") String units) throws MalformedURLException, IOException, ApiException, InterruptedException {
            String destination = "suwalki";
            System.out.println(cityFrom + " " + transport + " " + units);
            DistanceMatrixApiRequest apiRequest = DistanceMatrixApi.newRequest(GOOGLE_CONTEXT);
            return apiRequest.origins(cityFrom).destinations(destination).mode(chooseTravelMode(transport)).language("pl-PL").units(chooseUnits(units)).await();
    }   
     
    private TravelMode chooseTravelMode(String travelMode) {
        switch (travelMode) {
            case "bike":
                return TravelMode.BICYCLING;
            case "state":
                return TravelMode.TRANSIT;
            case "car":
                return TravelMode.DRIVING;
            case "onFoot":
                return TravelMode.WALKING;
        }
        
        return TravelMode.UNKNOWN;
    }
    
    private Unit chooseUnits(String units) {
        switch (units) {
            case "metresAndKilometres":
                return Unit.METRIC;
            case "miles":
                return Unit.IMPERIAL;
        }
        
        return Unit.METRIC;
    }

    private Attractions getAttracionsContext() {
        Attractions attractions = (Attractions) context.getAttribute(ATTRACTION_CONTEXT);
        if (attractions == null) {
            attractions = new  Attractions();
            context.setAttribute(ATTRACTION_CONTEXT, attractions);
        }

        return attractions;
    }
}
