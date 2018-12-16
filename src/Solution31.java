/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution31
{
    public void nextPermutation(int[] nums) {
        int i,j,m,n;
        for(i=nums.length-2;i>=0;i--){
            for(j=nums.length-1;j>i;j--){
                if(nums[i]<nums[j]){
                    nums[i]+=nums[j];
                    nums[j]=nums[i]-nums[j];
                    nums[i]-=nums[j];
                    for(m=i+1;m<nums.length;m++){
                        for(n=i+1;n<nums.length-1;n++){
                            if(nums[n]>nums[n+1]){
                                nums[n+1]+=nums[n];
                                nums[n]=nums[n+1]-nums[n];
                                nums[n+1]-=nums[n];
                            }
                        }
                    }
                    return ;
                }
            }
        }
        for(i=nums.length-1,j=0;i>j;i--,j++){
            nums[i]+=nums[j];
            nums[j]=nums[i]-nums[j];
            nums[i]-=nums[j];
        }
    }
}
