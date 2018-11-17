package set;

import java.util.TreeSet; //底层平衡二叉树 红黑树

public class LeetcodeIssue {

    public static void main(String[] args){
        int i = uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(i);
    }


    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                builder.append(codes[word.charAt(i) - 'a']);
            }
            set.add(builder.toString());
        }

        return set.size();


    }
}
