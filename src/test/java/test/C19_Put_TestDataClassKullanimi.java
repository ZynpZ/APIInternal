package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*
       https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
       request yolladigimizda donen response’un
       status kodunun 200, content type’inin “application/json; charset=utf-8”,
       Connection header degerinin “keep-alive”
       ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
       Request Body
           {
           "title":"Ali",
           "body":"Merhaba",
           "userId":10,
           "id":70
           }
       Expected Data
           {
           "title":"Ali",
           "body":"Merhaba",
           "userId":10,
           "id":70
           }
     */

    @Test
    public void put01() {
        // 1 - Request URL ve Body olustur
        specJsonPlace.pathParams("pp1","posts","pp2", 70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();

        JSONObject reqbody=testDataJsonPlaceHolder.requestBodyOlustur();

        //System.out.println(reqbody);

        //2- expected data hazırla (soruda verildiği için bu adım yapılır)

        JSONObject expData=testDataJsonPlaceHolder.requestBodyOlustur();

        //3-Response kaydet (put methodunda body kullanılacağından contentType yazılır)

        Response response=given().
                                spec(specJsonPlace).
                                contentType(ContentType.JSON).
                          when().
                                body(reqbody.toString()).
                                put("/{pp1}/{pp2}");

        response.prettyPrint();

        //4-Assertion (expected data varsa JsonPath üzerinden sorgu yapılır.)
        JsonPath respJP=response.jsonPath();

        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(testDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(testDataJsonPlaceHolder.connectionHeaderDegeri,response.header("Connection"));
        assertEquals(expData.get("title"),respJP.get("title"));
        assertEquals(expData.get("body"),respJP.get("body"));
        assertEquals(expData.get("userId"),respJP.get("userId"));
        assertEquals(expData.get("id"),respJP.get("id"));




    }
}
