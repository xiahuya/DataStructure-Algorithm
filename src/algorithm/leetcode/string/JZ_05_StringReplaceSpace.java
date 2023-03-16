package algorithm.leetcode.string;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class JZ_05_StringReplaceSpace {
    //
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
}
