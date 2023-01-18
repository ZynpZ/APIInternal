package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
    http://dummy.restapiexample.com/api/v1/employee url’ine bir GET request gonderdigimizde donen response’un
    status codu'nun 200, ve content type'nın Application.JSON, ve response body'sindeki employees sayısının 24 ve
    employee'lerden birinin "Ashton Cox"
    ve girilen yaslar içinde 61,40 ve 30 değerlerinin olduğunu test edin
     */

    @Test
    public void get01(){
        //Request URL hazırla
        String url="http://dummy.restapiexample.com/api/v1/employees";

        //2- Expected data
        //3- Responsu kaydet

        Response response=given().when().get(url);
        response.prettyPrint();

        //Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", hasSize(24),"data.employee_name",
                        hasItem("Ashton Cox"),"data.employee_age", hasItems(61,40,30));
    }

}
