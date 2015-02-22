package Bingjing10262012;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/26/12 Time: 2:15 PM
 */
public class RemoveDuplicatesInString {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abcabeaxya");

        System.out.println(removeDuplicatesWithNoBuffer(str));



    }

    private static String removeDuplicatesWithNoBuffer(StringBuffer buff) {
        /* When no additional space */
        if (buff.length() < 2){
            return buff.toString();
        }
        
        int tail = 1;
        for (int i = 0; i < buff.length(); ++i){
            boolean uniq = true;
            char ci = buff.charAt(i);
            for (int j = 0; j < tail; ++j){
                if (ci == buff.charAt(j)){
                    // char at j is a duplicate
                    uniq = false;
                }
            }
            if (uniq){
                buff.setCharAt(tail, ci);
                ++tail;
            }
        }

        // This actually creates a new string :) but we could have used a char[] instead of
        // the StringBuffer to avoid that.
        return buff.substring(0, tail);

    }
}
