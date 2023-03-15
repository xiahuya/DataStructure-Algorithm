package algorithm.leetcode.string;

/**
 * @author Xiahu
 * @create 2023/3/14 0014
 */
public class StringDemo {
    public static void main(String[] args) {

        System.out.println(replaceSpace("We are happy."));
        System.out.println(reverseLeftWords("abcdefg", 2));

    }


    //把字符串 s 中的每个空格替换成"%20"。
    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ((int) aChar == 32) {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }


    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    //输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    public static String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }

        for (int i = n; i < chars.length; i++) {
            sb2.append(chars[i]);
        }

        sb2.append(sb);
        return sb2.toString();
    }
}
