package test;

import baseURL.DummyBaseURL;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Get_TestDataKullanimi extends DummyBaseURL {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
     donen response’un status code’unun 200, content Type’inin application/json
     ve body’sinin asagidaki gibi oldugunu test edin.

     	Expected Body ya da Reponse Body
      {
        "status":"success",
        "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
        },
        "message":"Successfully!Record has been fetched."
     }

     */

    @Test
    public void get01(){
        //1- Request URL ve Body Hazırla
        specDummy.pathParams("pp1","employee","pp2",3);

        //2- Expected Hazırla
        TestDataDummy testDataDummy=new TestDataDummy();

        JSONObject expData=testDataDummy.expectedDataBodyOlustur();

        //1- Response'u kaydet
        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        //4- Assertion
        assertEquals();



    }
}
