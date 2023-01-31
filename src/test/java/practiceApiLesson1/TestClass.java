package practiceApiLesson1;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    RestApiUtils restApiUtils=new RestApiUtils();

    @Test
    public void verifyUserWithID(){
        //JSONPATH ile doğrulama yapalım

        JsonPath json=restApiUtils.checkUserWithIDGet(114351).jsonPath();

        Assert.assertEquals("Dellawq",json.get("firstName"));
        Assert.assertEquals("Heaney",json.get("lastName"));
        Assert.assertEquals("ricardo.larkin@yahoo.com",json.get("email"));

    }

    @Test
    public void createUserTest(){
        restApiUtils.postUserApiCall("Zeynep","3500","37");

    }
}
