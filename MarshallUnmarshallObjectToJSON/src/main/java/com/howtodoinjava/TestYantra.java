package com.howtodoinjava;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="test-yantra")
public class TestYantra
{
    /* Properties (non-static member variables) */
    private List<Employee> emp;
    
    
    /* Constructors */
    public TestYantra() {
        // NOTE: Your Java class must have a no-argument constructor, otherwise JAXB will not able to marshal it.
        super();
    }

    public TestYantra(List<Employee> emp) {
        super();
        this.emp = emp;
    }

    
    /* Getters and Setters */
    // Getter methods is going to help in marshalling
    // Setter methods is going to help in umarshalling
    @XmlElement
    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }

    
    /* Overriding super class methods */
    @Override
    public String toString() {
        return "TestYantra [emp=" + emp + "]";
    }
}