package algorithm.leetcode.array;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * <p>
 * 统计一个数字在排序数组中出现的次数
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class JZ_53_ArraySearch {

    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
