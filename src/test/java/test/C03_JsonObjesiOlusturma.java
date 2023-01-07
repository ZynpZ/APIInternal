package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    @Test
    public void jsonObje(){

         /*
    Aiağıdaki JSON objesini oluşturup konsolda yazdırın
    {"title": "Ahmet",
    "body": "Merhaba",
    "userId":1}

     */

        JSONObject ilkJSONObject=new JSONObject();

        ilkJSONObject.put("title","Ahmet");
        ilkJSONObject.put("body","Merhaba");
        ilkJSONObject.put("userId",1);


        System.out.println(ilkJSONObject);
    }

    @Test
    public void jsonObje2(){
        /*
        {
        "firstname" : "jim",
        "additionalneeds": "Breakfast",
        "bookingdates": {
            "checkin": "2008-01-01",
            "checkout":2019-01-01"
         },
         "totalprice": 111,
         "depositpaid": true,
         "lastname": brown"
         }
         */

        JSONObject innerJson=new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject body=new JSONObject();
        body.put("additionalneeds", "Breakfast");
        body.put("totalprice", 111);
        body.put("depositpaid", true);
        body.put("lastname", "Brown");
        body.put("bookingdates", innerJson);

        System.out.println(body);



        }

    }






