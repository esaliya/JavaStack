import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Saliya
 * Date: 2/8/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegExTester {
    public static void main(String[] args) {
//        String str = "hellooú how are you ífine";
        String str = "helloú";
        Pattern p = Pattern.compile("hello");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        System.out.println(b);
    }
}
