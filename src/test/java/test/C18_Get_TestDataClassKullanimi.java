package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

     /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
    request yolladigimizda donen response’in status kodunun 200 ve
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    } (bu expected data)
     */

    @Test
    public void get01(){

        //1-request url ve body hazırla (get için body ihtiyacı yok)
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        //2- expected data hazırla (soruda verildiği için bu adım yapılır)

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        // bu classı extend edemediğimiz için nesne oluşturarak yapmaya

        JSONObject expData=testDataJsonPlaceHolder.expectedDataOlustur();

        //3-Response kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}"); //body olmadığı için body ve contentType gerek yok

        response.prettyPrint();

        //4-Assertions
        // Response body test edilirken direkt assertion kullanılır. yani response.then kullanılmaz.
        //aşağıda actual'ı yazarken responsu yazıcaz. ama response'ı assert içerisinde okuyabilmek için JsonPath'e çevirmemiz lazım
        JsonPath resJP=response.jsonPath();

        assertEquals(200, response.getStatusCode());
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("body"),resJP.get("body"));


    }
}
