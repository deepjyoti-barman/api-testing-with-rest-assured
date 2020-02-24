package com.howtodoinjava;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * It is built to convert a XML string into an object, which is known as Unmarshalling. Object content will be displayed in console once the process of unmarshalling is done.
 * 
 * @author Deepjyoti Barman
 * @since February 15, 2020
 */
public class XMLToObjectUnmarshaller
{
    /**
     * Converts the XML string into an object, then displays the object content in console.
     * 
     * @param filePath Path of the .XML file which is going to be used for unmarshalling
     * @throws JAXBException
     */
    public static void jaxbXMLToObject(String filePath) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(TestYantra.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        // Convert the XML String present in given file into an object
        TestYantra tyObj = (TestYantra) unmarshaller.unmarshal(new File(filePath));
        
        // Print the object into console
        System.out.println(tyObj);
    }
    
    
    public static void main(String[] args) throws JAXBException
    {
        // Locating the XML file which is is going to be converted into an object
        String filePath = "XMLFiles/test-yantra-software-solutions-pvt-ltd.xml";
        
        jaxbXMLToObject(filePath);
    }
}