import java.lang.*;
import java.io.*;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==0) return result;
        if(nums.length==1){
            if(nums[0]==target){
                result[0]=result[1]=0;
                return result;
            }
            else return result;
        }
        if(target<nums[0]||target>nums[nums.length-1]){
            result[0]=-1;result[1]=-1;
        }
        else if(target==nums[0]){
            result[0]=0;
            result[1]=findMax(nums,1,nums.length-1,target);
        }
        else if(target==nums[nums.length-1]){
            result[0]=findMin(nums,0,nums.length-2,target);
            result[1]=nums.length-1;
        }
        else{
            result[0]=findMin(nums,0,nums.length-1,target);
            result[1]=findMax(nums,0,nums.length-1,target);
        }
        return result;
    }
    private static int findMax(int[] nums,int i,int j,int target){
        if(target>nums[j]) return -1;
        if(target<nums[i]) {
            if(nums[i-1]==target){
                return i-1;
            }
            else return -1;
        }
        if(target==nums[j]) return j;
        if(target<nums[(i+j)/2]){
            return findMax(nums,i,(i+j)/2-1,target);
        }
        else return findMax(nums,(i+j)/2+1,j,target);
    }
    private static int findMin(int[] nums,int i,int j,int target){
        if(target<nums[i]) return -1;
        if(target>nums[j]) {
            if(nums[j+1]==target){
                return j+1;
            }
            else return -1;
        }

        if(target==nums[i]) return i;
        if(target<=nums[(i+j)/2]){
            return findMin(nums,i,(i+j)/2-1,target);
        }
        else return findMin(nums,(i+j)/2+1,j,target);
    }
}
