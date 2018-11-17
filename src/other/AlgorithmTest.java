//package other;
//
//public class AlgorithmTest {
//
//    public static void main(String[] args) {
//        System.out.println(findLongestAroundStr("abcdeffedha"));
//    }
//
//    private static String combine(String str1, String str2) {
//        return findLongestAroundStr(str1 + str2)；
//    }
//
//    private static String findLongestAroundStrOut(String s) {
//        if (s == null || s.length() < 1)
//            return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(0, start) + s.substring(end + 1, s.length());
//    }
//
//    private static int expandAroundCenter(String s, int left, int right) {
//        int l = left, r = right;
//        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//            l--;
//            r++;
//        }
//        return r - l - 1;
//    }
//
//
//}
