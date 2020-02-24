package com.howtodoinjava;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * It is built to convert an object into a XML string, which is known as Marshalling. XML string content will be displayed in console once the process of marshalling is done and it is also going to be stored into a .XML file.
 *  
 * @author Deepjyoti Barman
 * @since February 15, 2020
 */
public class ObjectToXMLMarshaller
{
    /**
     * Converts the object into a XML string, then displays the XML string content in console and also stores it in a .XML file.
     * 
     * @param tyObj Object reference of the class which is going be used for marshalling
     * @throws JAXBException
     */
    public static void jaxbObjectToXML(TestYantra tyObj) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(TestYantra.class);
        Marshaller marshaller = context.createMarshaller();
        
        // Set the format
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        // Print the XML string into console
        marshaller.marshal(tyObj, System.out);
        
        // Write the XML string into file
        marshaller.marshal(tyObj, new File("XMLFiles/test-yantra-software-solutions-pvt-ltd.xml"));
    }
    
    
    public static void main(String[] args) throws JAXBException
    {
        // Creating the object which is going to be converted into XML
        Employee employee1 = new Employee(1, "Deepjyoti", "Barman", new Department(100, "Development"), Arrays.asList("+91-7687881748", "+91-6290582451"));
        Employee employee2 = new Employee(2, "Keerthi", "N.", new Department(101, "Quality Assurance"), Arrays.asList("+91-9876543210", "+91-9876501234"));
        Employee employee3 = new Employee(3, "Padmini", "Magar", new Department(102, "Design and Architect"), Arrays.asList("+91-9764312580", "+91-7182934560"));
        
        ArrayList<Employee> empList = new ArrayList<Employee>();
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        
        TestYantra tyObj = new TestYantra(empList);
        
        // Calling the method which will convert the object to XML
        jaxbObjectToXML(tyObj);
    }
}