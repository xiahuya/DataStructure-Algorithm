package algorithm.leetcode.array;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class JZ_53_ArrayMissNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            }

            if (nums[0] >= 1) {
                return nums[0] - 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
