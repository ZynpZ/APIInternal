package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {


   /* https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye
    sahip bir POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin

    Request body {
    "firstname" : "Ahmet",
    "lastname" : “Bulut",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" :
          "checkin" : "2021-06-01",
          "checkout" : "2021-06-10"
          },
    "additionalneeds" : "wi-fi"
          }

    Response Body{
    "bookingid":24,
    "booking": {
        "firstname":"Ahmet",
        "lastname":"Bulut",
        "totalprice":500,
        "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
        },
        "additionalneeds":"wi-fi"
}
}
    */
    @Test
    public void post01() {
        // 1- request URL ve body hazırla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();
        JSONObject reqbody = new JSONObject();

        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        reqbody.put("firstname", "Ahmet");
        reqbody.put("lastname", "Bulut");
        reqbody.put("totalprice", 500);
        reqbody.put("depositpaid", false);
        reqbody.put("bookingdates", innerBody);
        reqbody.put("additionalneeds", "wi-fi");

        //2- expected body hazırla

        JSONObject bookingdates = new JSONObject();
        JSONObject booking = new JSONObject();
        JSONObject expBody = new JSONObject();

        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        booking.put("firstname", "Ahmet");
        booking.put("lastname", "Bulut");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("bookingdates", innerBody);
        booking.put("additionalneeds", "wi-fi");

        expBody.put("bookingid", 24);
        expBody.put("booking", booking);

        //3- Response'u kaydet
        // burada post request olduğu için contentType belirtilir given'dan sonra

        Response response = (Response) given().contentType(ContentType.JSON).when().body(reqbody.toString()).post(url);

        response.prettyPrint();

        // 4- Assertion

        JsonPath resJS=response.jsonPath();

        assertEquals("Booking firstname calısmadı",expBody.getJSONObject("booking").get("firstname"), resJS.get("booking.firstname"));
        assertEquals("Booking lastname calısmadı",expBody.getJSONObject("booking").get("lastname"),resJS.get("booking.lastname"));
        assertEquals("Booking totalpriice calısmadı",expBody.getJSONObject("booking").get("totalprice"),resJS.get("booking.totalprice"));
        assertEquals("Booking depositpaid calısmadı",expBody.getJSONObject("booking").get("depositpaid"),resJS.get("booking.depositpaid"));
        assertEquals("Booking bookingdates-checkin calısmadı",expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJS.get("booking.bookingdates.checkin"));
        assertEquals("Booking bookingdates-checkout calısmadı",expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJS.get("booking.bookingdates.checkout"));
        assertEquals("Booking additionalneeds calısmadı",expBody.getJSONObject("booking").get("additionalneeds"),resJS.get("booking.additionalneeds"));
    }
}

