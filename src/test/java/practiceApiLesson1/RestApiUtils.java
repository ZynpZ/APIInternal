package practiceApiLesson1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class RestApiUtils extends Authentication{

    //ApiCalls'daki methodları kullanmak için obje create ettik

    static ApiCalls apiCalls=new ApiCalls();

    static Response checkUserWithIDGet(int id){
        Response response=null;

        try {
            response = (Response) RestAssured.given().
                    headers("Content-Type", ContentType.JSON).
                    header("Authorization","Bearer "+generateToken()).when().get(apiCalls.createGetUserApiCall(id));
        }catch (Exception e){
            Assert.fail(e.getMessage());

        }
        return response;
    }

    static Response postUserApiCall(String name, String salary, String age){

        Response response=null;

        try {
            response = (Response) RestAssured.given().
                    headers("Content-Type", ContentType.JSON).
                    when().post(apiCalls.createPostUserApiCall());

           Assert.assertEquals(response.getStatusCode(),200);
        }catch (Exception e){
            Assert.fail(e.getMessage());

        }
        return response;

    }


}
