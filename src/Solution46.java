import java.util.LinkedList;
import java.util.List;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result= new LinkedList<>();
        //initalize the list;
        for(int i=0;i<nums.length;i++){
            List<Integer> temp=new LinkedList<>();
            temp.add(nums[i]);
            result.add(temp);
        }
        LinkedList<List<Integer>> result1= new LinkedList<>();
        for(int i=1;i<nums.length;i++){
            while(!result.isEmpty()){
                List temp =result.pop();
                for(int j=0;j<nums.length;j++){
                    if(!temp.contains(nums[j])) {
                        List<Integer> one = new LinkedList<>(temp);
                        one.add(nums[j]);
                        result1.add(one);
                    }
                }
            }
            LinkedList temp=result;
            result=result1;
            result1=temp;
        }
        return result;
    }
}
