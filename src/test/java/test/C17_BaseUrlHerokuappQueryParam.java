package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {
    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void get01() {

        /*1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
    request gonderdigimizde donen response'un status code'unun 200 oldugunu
    ve Response'ta 625 id'ye sahip bir booking oldugunu test edin*/

        // 1 - Url ve body hazirla, get ve delete metodunda body ihtiyacimiz yok
        specHerokuApp.pathParam("pp1", "booking");

        //2- expected data hazırla (bu soruda öyle bişey yok)
        //3- Response'u kaydet

        Response response=given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        //4- assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(625));

    }

    @Test
    public void get02(){
        /*
         https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak "firstname" degeri "Eric" olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response'un
        status code'unun 200 oldugunu ve "Eric" ismine sahip en az bir booking oldugunu test edin
        */

        //1- URL hazirla
        specHerokuApp.pathParam("pp1", "booking").queryParam("firstname","Eric");

        //2- expected data (burada yok)
        //3- Response kaydet

        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        //4- assertion

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(2));
    }

    @Test
    public void get03(){
        /*
             3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak "firstname" degeri "Jim" ve "lastname" degeri
        "Jackson" olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        donen response'un status code'unun 200 oldugunu ve "Jim Jackson" ismine sahip
        en az bir booking oldugunu test edin
        */

        //1- URL hazirla
        specHerokuApp.pathParam("pp1","booking").queryParam("firstname", "Jim");

        //2- expected data (burada yok)
        //3- Response kaydet

        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        //4- assertion
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(3));

    }
}

