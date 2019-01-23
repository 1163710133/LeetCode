/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

import java.util.*;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int h = 0; ; h++) {
            for (int i = 0; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int t1 = target - (nums[i] + nums[j]) - h;
                    int t2 = target - (nums[i] + nums[j]) + h;
                    if (map.containsKey(t1) && map.get(t1) > j) {
                        return target - h;
                    }
                    if (map.containsKey(t2) && map.get(t2) > j) {
                        return target + h;
                    }
                }
            }
        }

    }
}