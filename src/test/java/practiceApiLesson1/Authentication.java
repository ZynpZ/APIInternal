package practiceApiLesson1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    //Web sitelerinin güvenliği açısından developerlar otomatik olarak belli periyotlarda değişen şifreleme create eder
    //buna Token denilmektedir.
    // Aşağıdaki token'ı otomatik olarak almak ve koda implement etmek için olusturuyoruz

    public static String generateToken(){
        String username="Batch44Api";
        String password="Batch44+";

        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);

        String endPoint="https://www.gmibank.com/api/authenticate";

        Response response=given().contentType(ContentType.JSON).body(map).when().post(endPoint);

        JsonPath token=response.jsonPath();

        return token.getString("id_token");
        // "id_token" endPoint'den gelmektedir. Token'ın head text'i diyebiliriz.


    }

    public static void main(String [] args) {
        System.out.println(generateToken());
    }
}
