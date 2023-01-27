package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {

    public int statusCode=200;

    public String contentType="application/json";



    public JSONObject innerDataJsonBodyOlustur(){
        JSONObject innerDatabodyJSON=new JSONObject();

        innerDatabodyJSON.put("id",3);
        innerDatabodyJSON.put("employee_name","Ashton Cox");
        innerDatabodyJSON.put("employee_salary",86000);
        innerDatabodyJSON.put("employee_age",66);
        innerDatabodyJSON.put("profile_image","");

        return innerDatabodyJSON;

    }
    public JSONObject expectedDataBodyOlustur(){

        JSONObject expDataJSON=new JSONObject();

        expDataJSON.put("status","success");
        expDataJSON.put("data",innerDataJsonBodyOlustur());
        expDataJSON.put("message","Successfully! Record has been fetched.");

        return expDataJSON;
    }

    public HashMap expectedDataOlusturMap(){
        /*
        Response Body

    	{
        "status":"success",
        "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
        "message":"Successfully! Record has been fetched."
        }
         */

        HashMap<String,Object> innerMap=new HashMap<>();
        HashMap<String,Object> expMap=new HashMap<>();

        innerMap.put("id",3.0);
        innerMap.put("employee_name","Ashton Cox");
        innerMap.put("employee_salary",86000.0);
        innerMap.put("employee_age",66.0);
        innerMap.put("profile_image","");

        expMap.put("status", "success");
        expMap.put("message", "Successfully! Record has been fetched.");
        expMap.put("data", innerMap);

        return expMap;
    }
}
