package com.howtodoinjava;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="department")
@XmlType(propOrder={"id", "name"})
public class Department
{
    /* Properties (non-static member variables) */
    private int id;
    private String name;
    
    
    /* Constructors */
    public Department() {
        // NOTE: Your Java class must have a no-argument constructor, otherwise JAXB will not able to marshal it.
        super();
    }
    
    public Department(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    
    /* Getters and Setters */
    @XmlElement(name="department-id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name="department-name")
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    /* Overriding super class methods */
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}