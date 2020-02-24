package com.howtodoinjava;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="employee")
@XmlType(propOrder={"firstName", "lastName", "department", "contacts"})
public class Employee
{
    /* Properties (non-static member variables) */
    private int id;
    private String firstName;
    private String lastName;
    private Department department;
    private List<String> contacts;
    
    
    /* Constructors */
    public Employee() {
        // NOTE: Your Java class must have a no-argument constructor, otherwise JAXB will not able to marshal it.
        super();
    }

    public Employee(int id, String firstName, String lastName, Department department, List<String> contacts) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.contacts = contacts;
    }

    
    /* Getters and Setters */
    @XmlAttribute
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    @XmlElementWrapper(name = "contacts")
    @XmlElement(name = "mobile")
    public List<String> getContacts() {
        return contacts;
    }
    
    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    
    /* Overriding super class methods */
    @Override
    public String toString() {
        return "\n\tEmployee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
                + department + ", contacts=" + contacts + "]";
    }    
}