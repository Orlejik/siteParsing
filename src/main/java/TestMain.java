import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        Map<String, String> name = new HashMap<>();

        name.put("Father", "Vladimir");
        name.put("Mother", "Nellia");
        name.put("Brother", "Andrei");
        name.put("Me", "Artiom");

        System.out.printf("Mother - %s\n", name.get("Mother"));
        System.out.printf("Brother - %s\n", name.get("Brother"));
        System.out.printf("Father - %s\n", name.get("Father"));
        System.out.printf("Me - %s\n", name.get("Me"));


    }
}
