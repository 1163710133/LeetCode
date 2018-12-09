import java.util.*;

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    public void backtrack(List<String> result,String current,int open,int close,int max){
        if(current.length()==max*2){
            result.add(current);
            return;
        }
        if(open<max){
            backtrack(result,current+"(",open+1,close,max);
        }
        if(close<open){
            backtrack(result,current+")",open,close+1,max);
        }
    }
}
