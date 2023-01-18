package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    /*
    http://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request
        gonderdigimizde donen response body'sinin aşağıda verilen ile aynı olduğunu test ediniz
        Reponse body:

        {"userId":3,
        "id":22,
        "title": "dolar sint quo a velit explicabo quia nam",
        "body": "eos qui et ipsam suscipit aut\nsed omnis non odio\nexpedita ear
        um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }

     */
    @Test
    public void get01(){
        //1- Request URL ve body hazırla
        String url=" http://jsonplaceholder.typicode.com/posts/22";

        //2- Expected body hazırla
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolar sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita earum mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        //3- Reponse  kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        //4- assertion

        //öncelikle yapılması gereken şey Response'u JsonPath objesine çevirmek

        JsonPath respJSPath=response.jsonPath();
        assertEquals(expBody.get("userId"),respJSPath.getInt("userId"));

    }
}
