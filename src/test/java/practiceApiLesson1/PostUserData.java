package practiceApiLesson1;

public class PostUserData {

    private static String name;
    public static String salary;
    public static String age;

    public PostUserData(){

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        PostUserData.name = name;
    }

    public static String getSalary() {
        return salary;
    }

    public static void setSalary(String salary) {
        PostUserData.salary = salary;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        PostUserData.age = age;
    }

    public PostUserData(String name,String salary,String age) {
        this.name=name;
        this.salary=salary;
        this.age=age;

    }
}
