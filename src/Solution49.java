import java.util.*;


/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return null;
        List<List<String>> result= new ArrayList<>();
        Map<String,List<String>> answer= new HashMap<String,List<String>>();
        List<String> temp;
        for(int i=0;i<strs.length;i++) {
            char[] a = strs[i].toCharArray();
            char[] atemp = a.clone();
            Arrays.sort(atemp);
            String b = String.valueOf(atemp);
//            System.out.println(b+"");
            if(answer.get(b)!=null) {
                temp = answer.get(b);
                temp.add(String.valueOf(a));
            }else
//            int flag=0;
//            for (String string : answer.keySet()) {
//                //System.out.println(string);
//                if (string.equals(b)){
//
//                    temp = answer.get(string);
//                    temp.add(String.valueOf(a));
//                    flag=1;
//                    break;
//                }
//            }
//            if(flag==0)
            {
//                temp=new ArrayList<>();
//                temp.add(String.valueOf(a));
//                answer.put(b,temp);
                answer.put(b, new ArrayList<String>() {{
                    add(String.valueOf(a));
                }});
            }
        }
        for(String i:answer.keySet()){
            //System.out.println(a);
            //System.out.println(answer.get(a).toString());
            result.add(answer.get(i));
        }
        return result;
    }
}
