package com.npmjs.jsonserver.posts.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * This class contains methods to extract required data from the .json file.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class JSONLib
{
    /**
     * Extracts the data present in the given .json file and returns it converting into a String.
     * 
     * @param jsonFilePath Path of the .json file
     * @return The JSON data contained in the file as a String
     * @throws IOException
     */
    public String toJSONString(String jsonFilePath) throws IOException
    {
        FileInputStream fis = new FileInputStream(jsonFilePath);
        return IOUtils.toString(fis, "utf-8"); 
    }
}
