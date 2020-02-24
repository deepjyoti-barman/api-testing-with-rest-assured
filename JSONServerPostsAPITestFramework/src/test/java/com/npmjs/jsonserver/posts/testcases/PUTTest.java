package com.npmjs.jsonserver.posts.testcases;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.npmjs.jsonserver.posts.base.BaseTest;

import io.restassured.response.Response;

/**
 * Contains all the test cases that is going to perform PUT (HTTP request method) operation on the API.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class PUTTest extends BaseTest
{
    /**
     * Test to completely alter a post and validate - Status code, Content-type, Response body and Response time of response given by the API.
     * 
     * @throws IOException
     */
    @Test
    public void editPostCompleteBDDTest() throws IOException
    {
        Response resp = amLib.executeRequest("editPostComplete", EXCEL_FILE_PATH, EXCEL_SHEET);
        
        System.out.println("Response time: " + resp.time() + " ms");
        resp.then()
            .log().ifStatusCodeIsEqualTo(200)
            .body("title", equalTo("The Selfish Giant"))
            .body("author", containsString("Wilde"))
            .contentType("application/json; charset=utf-8")
            .time(lessThan(4000L));
    }
}
