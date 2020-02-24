package com.npmjs.jsonserver.posts.testcases;

import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.npmjs.jsonserver.posts.base.BaseTest;

import io.restassured.response.Response;

/**
 * Contains all the test cases that is going to perform GET (HTTP request method) operation on the API.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class GETTest extends BaseTest
{
    /**
     * Test to get all the posts and validate - Status code, Content-type and Response time of response given by the API.
     * 
     * @throws IOException
     */
    @Test
    public void getAllPostsBDDTest() throws IOException
    {
        Response resp = amLib.executeRequest("getAllPosts", EXCEL_FILE_PATH, EXCEL_SHEET);
        
        System.out.println("Response time: " + resp.time() + " ms");
        resp.then()
            .log().ifStatusCodeIsEqualTo(200)
            .contentType("application/json; charset=utf-8")
            .time(lessThan(4000L));
    }
    
    /**
     * Test to get one post and validate - Status code, Content-type and Response time of the response given by the API.
     * 
     * @throws IOException
     */
    @Test
    public void getOnePostBDDTest() throws IOException
    {
        Response resp = amLib.executeRequest("getOnePost", EXCEL_FILE_PATH, EXCEL_SHEET);
        
        System.out.println("Response time: " + resp.time() + " ms");
        resp.then()
            .log().ifStatusCodeIsEqualTo(200)
            .contentType("application/json; charset=utf-8")
            .time(lessThan(4000L));
    }
}
