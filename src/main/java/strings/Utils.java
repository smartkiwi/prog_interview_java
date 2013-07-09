package strings;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/8/13
 * Time: 1:50 PM
 * String related utils
 */
public class Utils {
    public static char[] convertStringToCharArray(String s) {
        char[] result = new char[s.length()];
        for (int i=0;i<s.length();i++) {
            result[i] = s.charAt(i);
        }
        return result;
    }

    public static String convertCharArrayToString(char[] c) {
        StringBuilder s = new StringBuilder();
        s.append(c);
        return s.toString();
    }
}
