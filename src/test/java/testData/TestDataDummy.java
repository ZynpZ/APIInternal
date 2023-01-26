package testData;

import org.json.JSONObject;

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
}
