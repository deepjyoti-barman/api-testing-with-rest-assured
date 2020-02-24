package com.npmjs.jsonserver.posts.base;

/**
 * It contains a pool of constants that is going to be used throughout the framework.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public interface IAutoConstant
{
    String BASE_URI         = "http://localhost";
    int PORT                = 3000;
    
    String USER_DIR         = System.getProperty("user.dir");
    
    String EXCEL_FILE_PATH  = USER_DIR + "/src/test/resources/testdata/json-server_posts_testinputs.xlsx";
    String EXCEL_SHEET = "Sheet1";
    
    String JSON_DIR         = USER_DIR + "/src/main/resources/JSONFiles/";
}