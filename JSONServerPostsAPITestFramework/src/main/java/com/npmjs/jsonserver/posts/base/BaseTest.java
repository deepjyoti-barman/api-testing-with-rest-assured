package com.npmjs.jsonserver.posts.base;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.BeforeTest;

import com.npmjs.jsonserver.posts.utils.APIMethodLib;

/**
 * It is used to perform the initial configuration of every test cases. It acts like the parent class for each and every test cases. Hence every class having test cases must and should inherit this class.  
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class BaseTest implements IAutoConstant
{
    protected APIMethodLib amLib = new APIMethodLib();
    
    /**
     * It is used to initialize the URI and Port of the API.
     */
    @BeforeTest
    public void configBT()
    {
        baseURI = BASE_URI;
        port    = PORT;
        
        /*
         * basePath can be set if the URI is like:
         *      http://dummy.restapiexample.com/api/v1/employee/1
         * where,
         *      baseURI       = http://dummy.restapiexample.com
         *      basePath      = /api/v1
         *      endPoint      = /employee
         *      pathParameter = /{emp-id}   (where emp-id = 1)
         */
        // basePath = BASE_PATH; 
    }
}
