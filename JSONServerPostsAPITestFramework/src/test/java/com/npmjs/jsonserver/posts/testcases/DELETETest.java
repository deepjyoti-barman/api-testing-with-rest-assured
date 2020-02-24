package com.npmjs.jsonserver.posts.testcases;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.npmjs.jsonserver.posts.base.BaseTest;

import io.restassured.response.Response;

/**
 * Contains all the test cases that is going to perform DELETE (HTTP request method) operation on the API.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class DELETETest extends BaseTest
{
    /**
     * Test to delete a post and validate - Status code, Content-type, Response body and Response time of response given by the API.
     * 
     * @throws IOException
     */
    @Test
    public void deletePostBDDTest() throws IOException
    {
        Response resp = amLib.executeRequest("deletePost", EXCEL_FILE_PATH, EXCEL_SHEET);
        
        System.out.println("Response time: " + resp.time() + " ms");
        resp.then()
            .log().ifStatusCodeIsEqualTo(200)
            .body(equalTo("{}"))
            .contentType("application/json; charset=utf-8")
            .time(lessThan(4000L));
    }
}
