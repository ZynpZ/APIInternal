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

    }




}

