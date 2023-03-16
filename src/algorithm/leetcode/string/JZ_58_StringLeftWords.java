package algorithm.leetcode.string;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class JZ_58_StringLeftWords {

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
