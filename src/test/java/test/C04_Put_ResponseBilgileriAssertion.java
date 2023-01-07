package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C04_Put_ResponseBilgileriAssertion {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'sine
    aşağıdaki Json formatındaki body ile bir PUT request gönderdiğimizde
    {
    "id": 1,
    "title": "foolly",
    "body": "barrrel",
    "userId": 1
    }
    dönen Response'un,
    status cosu'nun 200,
    ve content type'nın application/json; charset=utf-8,
    ve Server isimli Header'ın değerinin cloudflare,
    ve Status Line'ın HTTP/1.1 200 OK

     */

    @Test
    public void put01(){
        // 1-Request için Url ve Body hazırla

        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "foolly");
        reqBody.put("body", "barrrel");
        reqBody.put("userId",1);
        reqBody.put("id",1);

        System.out.println(reqBody);

        //2- Expected Data hazırla
        //3- Response kaydet

        Response response=given().
                                contentType(ContentType.JSON).
                          when().
                                body(reqBody.toString()).
                                put(url);

        response.prettyPrint();

        //4- Assertion

        response.then().assertThat();


        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }
}
