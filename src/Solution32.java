/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        char[] parameter=s.toCharArray();
        if(s.length()==0) return 0;
        int i,j,m,n,max=0;
        for(i=0;i<parameter.length;i++){
            if(parameter[i]=='('){
                m=1;n=0;
                for(j=i+1;j<parameter.length;j++){
                    if(parameter[j]=='(') m++;
                    else if(parameter[j]==')'){
                        n++;
                        if(m==n&&2*m>max){
                            max=2*m;
                        }
                        else if(m<n) break;
                    }
                    else return max;
                }
            }
        }
        return max;
    }
}
