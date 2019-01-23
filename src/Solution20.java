import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        char[] temp = s.toCharArray();
        Stack<String> a = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            if (!a.empty()) {
                String b = a.pop();
                if (b.equals("(") && temp[i] == ')' || b.equals("{") && temp[i] == '}' || b.equals("[") && temp[i] == ']') {
                } else {
                    a.push(b);
                    a.push(String.valueOf(temp[i]));
                }
            } else a.push(String.valueOf(temp[i]));
        }
        if (a.empty()) {
            return true;
        } else return false;
    }
}
