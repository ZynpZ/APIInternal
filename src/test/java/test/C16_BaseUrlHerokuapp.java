package test;

import baseURL.HerokuAppBaseUrl;
import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {

    //Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void get01(){
        /*1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response'un status code'unun 200 oldugunu
        ve Response'ta 1357 id'sine sahip bir booking oldugunu test edin */

        // 1 - Url ve body hazirla, get ve delete metodunda body ihtiyacimiz yok

        specHerokuApp.pathParam("pp1","booking");

        //2- expected data hazırla (bu soruda öyle bişey belirtilmediği için geçiyoruz
        //3- Response'u kaydet

        Response response=given().
                            spec(specHerokuApp).
                          when().
                            get("/{pp1}");

        response.prettyPrint();

        //4- assertion
        response.then().assertThat().statusCode(200).body("bookingid", hasItem(1357));
    }

    @Test
    public void post01(){
        /* 2- https://restful-booker.herokuapp.com/booking endpointine asagidaki
     body'ye sahip bir POST request gonderdigimizde donen response'un status
     code'unun 200 oldugunu ve "firstname" degerinin "Ali" oldugunu test edin

      {
      "firstname" : "Ali",
      "lastname" : "Bak",
      "totalprice" : 500,
      "depositpaid" : false,
      "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                    },
      "additionalneeds" : "wi-fi"
       }
       */

        // 1 - Url ve body hazirla

        specHerokuApp.pathParam("pp1","booking");


        JSONObject innerBody=new JSONObject();
        JSONObject reqBody=new JSONObject();

        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        reqBody.put("firstname", "Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wi-fi");


        //2- expected data hazırla (burda öyle birşey yok geçiyoruz)
        //3- Response'u kaydet

        Response response=given().
                                spec(specHerokuApp).
                                contentType(ContentType.JSON).
                          when().
                                body(reqBody.toString()).
                                post("/{pp1}");

        response.prettyPrint();

        //4-assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("booking.firstname",equalTo("Ali"));


    }
}
