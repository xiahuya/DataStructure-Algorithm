package algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class JZ_03_ArrayQuery {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> list = new HashSet<>();
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            if (list.contains(num)) {
                return num;
            } else {
                list.add(num);
            }
        }

        return -1;
    }

}
