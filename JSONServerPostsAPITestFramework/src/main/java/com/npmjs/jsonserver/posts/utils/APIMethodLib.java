package com.npmjs.jsonserver.posts.utils;

import java.io.IOException;
import java.util.LinkedHashMap;

import com.npmjs.jsonserver.posts.base.IAutoConstant;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * Built to have all the HTTP request methods that we can perform on the API
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class APIMethodLib implements IAutoConstant
{
    ExcelLib eLib = new ExcelLib();
    JSONLib  jLib = new JSONLib();
    
    /**
     * It is used to execute required the HTTP request method based on the test case name. 
     * 
     * @param testCaseName Name of the test case
     * @param excelPath Path of the .xlsx file
     * @param sheetName Name of the sheet in the .xlsx file having the required data
     * @return Object reference of type Response
     * @throws IOException
     */
    public Response executeRequest(String testCaseName, String excelPath, String sheetName) throws IOException
    {
        LinkedHashMap<String, String> reqParams = eLib.getRequestParameters(testCaseName, excelPath, sheetName);
        String httpMethod = reqParams.get("HTTP Method");
        
        switch (httpMethod)
        {
            case "GET":
                return given()
//                           .queryParam("query_parameter_name", reqParams.get("Query Parameter"))
                           .pathParam("post-id", reqParams.get("Path Parameter")).
                       when()
                           .get(reqParams.get("End Point") + "/{post-id}");
                
            case "POST":
                return given()
                           .contentType("application/json; charset=utf-8")
                           .body(jLib.toJSONString(JSON_DIR + "json-server_posts-create_post.json")).
                       when()
                           .post(reqParams.get("End Point"));
                
            case "PUT":
                return given()
                           .contentType("application/json; charset=utf-8")
                           .body(jLib.toJSONString(JSON_DIR + "json-server_posts-edit_post_complete.json"))
                           .pathParam("post-id", reqParams.get("Path Parameter")).
                       when()
                           .put(reqParams.get("End Point") + "/{post-id}");
                
            case "PATCH":
                return given()
                           .contentType("application/json; charset=utf-8")
                           .body(jLib.toJSONString(JSON_DIR + "json-server_posts-edit_post_partial.json"))
                           .pathParam("post-id", reqParams.get("Path Parameter")).
                       when()
                           .patch(reqParams.get("End Point") + "/{post-id}");
                
            case "DELETE":
                return given()
                           .pathParam("post-id", reqParams.get("Path Parameter")).
                       when()
                           .delete(reqParams.get("End Point") + "/{post-id}");
        
        }
        
        return null;
    }
}