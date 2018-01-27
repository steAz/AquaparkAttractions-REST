/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aquaparkrest.logic;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kazanostra
 */


@XmlType(name = "attraction")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "attraction")
public class Attraction implements Serializable{
    
    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "name")
    public String name;

    @XmlAttribute(name = "difficulty")
    private String difficulty;
    
    @XmlAttribute(name = "age")
    private String age;
    
    public Attraction() {}
     
    public Attraction(String id, String name, String difficulty, String age) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
     public String getAge() {
        return age;
    }
     
    public void setAge(String age) {
        this.age = age;
    }

}
