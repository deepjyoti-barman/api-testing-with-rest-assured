package com.howtodoinjava;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

/**
 * It is built to convert a JSON string into an object, which is known as Unmarshalling. Object content will be displayed in console once the process of unmarshalling is done.
 * 
 * @author Deepjyoti Barman
 * @since February 15, 2020
 * @apiNote Works fine only with EclipseLink Moxy 2.7.0 or below
 */
public class JSONToObjectUnmarshaller
{
    /**
     * Converts the JSON string into an object, then displays the object content in console.
     * 
     * @param filePath Path of the .JSON file which is going to be used for unmarshalling
     * @throws JAXBException
     */
    public static void jaxbJSONToObject(String filePath) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(TestYantra.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        // Set the type
        unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
        
        // Convert the JSON String present in given file into an object 
        TestYantra tyObj = (TestYantra) unmarshaller.unmarshal(new File(filePath));
        
        // Print the object into console
        System.out.println(tyObj);
    }
    
    
    public static void main(String[] args) throws JAXBException
    {
        // Locating the JSON file which is is going to be converted into an object
        String filePath = "JSONFiles/test-yantra-software-solutions-pvt-ltd.json";
        
        jaxbJSONToObject(filePath);
    }
}