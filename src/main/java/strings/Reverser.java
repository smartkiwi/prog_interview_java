package strings;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/8/13
 * Time: 11:18 AM
 * Implements reversing string and reversing words in string inplace
 */
@SuppressWarnings("WeakerAccess")
public class Reverser {
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

    @SuppressWarnings("WeakerAccess")
    public static void reverseCharArray(char[] s) {
        reversePartOfCharArray(s, 0, s.length-1);
    }


    public static void reversePartOfCharArray(char[] s, int start, int end) {
        if (start>end || start<0 || end>=s.length)
            throw new IllegalArgumentException("start<end and withing array: start:" + start + " end: "+end+" length:"+s.length);
        int length = end-start+1;
        int pos = length/2;
        for(int i=0;i<pos;i++) {
            char tmp = s[start+i];
            s[start+i] = s[end-i];
            s[end-i] = tmp;
        }
    }

    public static void reverseWordsOrder(char [] s) {
        if (!hasSpaces(s))
            return;
        reverseCharArray(s);
        //System.out.println(convertCharArrayToString(s));
        int start = 0;
        int lastSpacePos = 0;
        for (int i=0;i<s.length;i++) {
            if (s[i]==' ') {
                reversePartOfCharArray(s, start, i-1);
                lastSpacePos = i;
                start = i+1;
            }
            //System.out.println(i+" " +convertCharArrayToString(s));
        }
        if (lastSpacePos>0)
            reversePartOfCharArray(s, lastSpacePos+1, s.length-1);
    }

    private static boolean hasSpaces(char[] s) {
        for(char c : s)
            if (c==' ')
                return true;
        return false;
    }
}
