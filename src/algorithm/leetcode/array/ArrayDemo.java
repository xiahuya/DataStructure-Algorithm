package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xiahu
 * @create 2023/3/14 0014
 */
public class ArrayDemo {

    public static void main(String[] args) {

    }


    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    // 请找出数组中任意一个重复的数字。
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


    // 统计一个数字在排序数组中出现的次数
    // 输入: nums = [5,7,7,8,8,10], target = 8
    // 输出: 2
    // 输入: nums = [5,7,7,8,8,10], target = 6
    // 输出: 0
    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * <p>
     * 输入: [0,1,3]
     * 输出: 2
     * <p>
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     */
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
