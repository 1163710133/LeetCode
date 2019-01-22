import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution47 {
    private List<List<Integer>> answer = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        perm(nums,0,nums.length-1);
        return answer;
    }
    private void perm(int[] num,int left,int right){
        int[] nums=num.clone();
//        int[] nums=new int[num.length];
//        for(int i=0;i<num.length;i++){
//            nums[i]=num[i];
//        }
        if(left==right) answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        else{
            for (int i = left; i <= right; i++) {
                if (i != left && nums[left] == nums[i]) continue;
//                nums[left]=nums[left]^nums[i];
//                nums[i]=nums[left]^nums[i];
//                nums[left]=nums[left]^nums[i];
                int temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                perm(nums, left + 1, right);
            }
        }
    }
    //检验一下上面的异或为什么不成功；不死很清楚，这个里面确实交换了。
//    public static void main(String[] args){
//        int a=1,b=2;
//        System.out.println(a+""+b);
//        a=a^b;
//        b=a^b;
//        a=a^b;
//        System.out.println(a+""+b);
//    }
}
