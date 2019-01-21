import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class Solution39 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates== null|| candidates.length ==0) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(result,new LinkedList<>(),candidates,target,0);
        return result;
    }
    private void backTracking(List<List<Integer>> result,LinkedList<Integer> current,int [] candidates,int target ,int start){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(candidates[i]>target) continue;
            current.push(candidates[i]);
            backTracking(result,current,candidates,target-candidates[i],i+1);
            current.pop();
            while(i+1<candidates.length){
                if(candidates[i+1]==candidates[i]) i++;
                else break;
            }
        }
    }
}
