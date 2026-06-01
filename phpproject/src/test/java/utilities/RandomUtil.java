package utilities;

public class RandomUtil {

    public static String generateEmail() {

        return "test"
                +System.currentTimeMillis()
                +"@gmail.com";
    }
}