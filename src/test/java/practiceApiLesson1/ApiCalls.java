package practiceApiLesson1;

public class ApiCalls {

    // bu class BaseUrl'deki class'lar gibi ve spec methodu gibi kullanacağız

    public static String GET_USER_WITH_ID = "https://www.gmibank.com/api/tp-customers/";
    public static String POST_USER = "http://dummy.restapiexample.com/api/v1/create";

    // Endpoint'in sonuna id eklemek istiyoruz cunku, user'ı id ile getirmeliyiz,
    // bu sebepten dolayi dinamik bir method create ettik
    public static String createGetUserApiCall(int id) {
        return GET_USER_WITH_ID + id;
    }

    public static String createPostUserApiCall() {
        return POST_USER;
    }
}
