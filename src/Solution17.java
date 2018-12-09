/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

import java.util.*;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        char[] digit=digits.toCharArray();
        List<List<String>> number= new ArrayList<>();
        if(digit.length==0) return new ArrayList<String>();
        for(int i=0;i<digit.length;i++){
            switch (digit[i]){
                case '2':
                    number.add(Arrays.asList("a","b","c"));
                    break;
                case '3':
                    number.add(Arrays.asList("d","e","f"));
                    break;
                case '4':
                    number.add(Arrays.asList("g","h","i"));
                    break;
                case '5':
                    number.add(Arrays.asList("j","k","l"));
                    break;
                case '6':
                    number.add(Arrays.asList("m","n","o"));
                    break;
                case '7':
                    number.add(Arrays.asList("p","q","r","s"));
                    break;
                case '8':
                    number.add(Arrays.asList("t","u","v"));
                    break;
                case '9':
                    number.add(Arrays.asList("w","x","y","z"));
                    break;
                default:
                    return null;
            }
        }
        Set<StringBuilder> temp1=new HashSet<>();
        Set<StringBuilder> temp2=new HashSet<>();
        for(String j :number.get(0)){
            temp1.add(new StringBuilder(j));
        }
        for(int i =1;i<digit.length;i++){
            if(i%2==1){
                for(StringBuilder j:temp1){
                    for(String h:number.get(i)) {
                        temp2.add(new StringBuilder(j.toString()).append(h));
                    }
                }
                temp1.removeAll(temp1);
            }
            else{
                for(StringBuilder j:temp2){
                    for(String h:number.get(i)) {
                        temp1.add(new StringBuilder(j.toString()).append(h));
                    }
                }
                temp2.removeAll(temp2);
            }
        }
        List<String> result=new ArrayList<>();
        if(digit.length%2==1) {
            for(StringBuilder u:temp1){
                result.add(u.toString());
            }
        }
        else{
            for(StringBuilder u:temp2){
                result.add(u.toString());
            }
        }
        return result;
    }
}
