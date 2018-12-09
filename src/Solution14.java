public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder result=new StringBuilder();
        for(int i=0;;i++){
            if(strs[0].length()<=result.length()) return result.toString();
            char temp=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=result.length()) return result.toString();
                if(strs[j].charAt(i)!=temp) return result.toString();
            }
            result.append(temp);
        }
    }
}
