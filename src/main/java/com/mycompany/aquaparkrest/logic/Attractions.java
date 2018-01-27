/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aquaparkrest.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kazanostra
 */


public class Attractions implements Serializable{
    private static Map<String,Attraction> attractions;
    
    public Attractions() {
        attractions = new HashMap<String,Attraction>();
        Attraction attrI = new Attraction("1", "Zjezdzalnia Huragan", "SREDNI", "Pomiedzy 12 a 16");
        Attraction attrII = new Attraction("2", "Zjezdzalnia Torpeda", "TRUDNY", "Wiecej niz 16");
        Attraction attrIII = new Attraction("3", "Zjezdzalnia Armata", "TRUDNY", "Mniej niz 12");
        Attraction attr4 = new Attraction("4", "Zjezdzalnia Hefalumpy", "TRUDNY", "Pomiedzy 12 a 16");
        Attraction attr5 = new Attraction("5", "Zjezdzalnia Ostroga", "SREDNI", "Mniej niz 12");
        Attraction attr6 = new Attraction("6", "Zjezdzalnia Bomba", "SREDNI", "Wiecej niz 16");
        Attraction attr7 = new Attraction("7", "Zjezdzalnia Alaska", "LATWY", "Mniej niz 12");
        Attraction attr8 = new Attraction("8", "Zjezdzalnia Antuiga", "LATWY", "Pomiedzy 12 a 16");
        Attraction attr9 = new Attraction("9", "Zjezdzalnia Masakra", "LATWY", "Wiecej niz 16");
        attractions.put(attrI.getId(), attrI);
        attractions.put(attrII.getId(), attrII);
        attractions.put(attrIII.getId(), attrIII);
        attractions.put(attr4.getId(), attr4);
        attractions.put(attr5.getId(), attr5);
        attractions.put(attr6.getId(), attr6);
        attractions.put(attr7.getId(), attr7);
        attractions.put(attr8.getId(), attr8);
        attractions.put(attr9.getId(), attr9);
    }
    
    public List<Attraction> getLiOfAttractions() {
        return new ArrayList<>(attractions.values());
    }
   
}
