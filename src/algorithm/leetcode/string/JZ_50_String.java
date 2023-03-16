package algorithm.leetcode.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * 输入：s = ""
 * 输出：' '
 */
public class JZ_50_String {
    Map<Character, Integer> map = null;


    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return " ".charAt(0);
        }
        map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                Integer integer = map.get(aChar);
                integer++;
                map.put(aChar, integer);
            } else {
                map.put(aChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() == 1) {
                return characterIntegerEntry.getKey();
            }
        }

        return " ".charAt(0);
    }

    public static void main(String[] args) {
        JZ_50_String string = new JZ_50_String();
        String line = "loveleetcode";
        System.out.println(string.firstUniqChar(line));
    }
}
