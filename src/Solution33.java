/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int result = 0;
        if (nums.length == 0) return -1;
        return searchBetween(nums, 0, nums.length - 1, target);
    }

    private static int searchBetween(int[] nums, int i, int j, int target) {
        int result;
        if (i > j || i == j && target != nums[i]) return -1;
        if (target == nums[i]) return i;
        if (target == nums[j]) return j;
        if (target < nums[i] && target > nums[j]) return -1;
        if (nums[i] < nums[(i + j) / 2]) {
            if (target == nums[(i + j) / 2]) return (i + j) / 2;
            if (target > nums[i] && target < nums[(i + j) / 2])
                return searchBetween(nums, i + 1, (i + j) / 2 - 1, target);
            else return searchBetween(nums, (i + j) / 2 + 1, j - 1, target);
        } else {
            if (target == nums[(i + j) / 2]) return (i + j) / 2;
            if (target > nums[(i + j) / 2] && target < nums[j]) return searchBetween(nums, (i + j) / 2, j - 1, target);
            else return searchBetween(nums, i + 1, (i + j) / 2 - 1, target);
        }
    }
}
