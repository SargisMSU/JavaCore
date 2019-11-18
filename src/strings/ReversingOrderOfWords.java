package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversingOrderOfWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("111 222 333"));
    }

    public static String reverseWords(String sentence) {
        List< String> words = Arrays.asList(sentence.split("\\s"));
        //Collections.reverse(words);
        StringBuilder sb = new StringBuilder(sentence.length());

        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            sb.append(' ');
        }

        return sb.toString().trim();
    }
}
