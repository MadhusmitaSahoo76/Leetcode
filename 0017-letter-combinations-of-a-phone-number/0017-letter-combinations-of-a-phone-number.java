class Solution {
    public List<String> letterCombinations(String digits){  
        List<String> ans = new ArrayList<>();

        if(digits.length()==0){
            return ans;
        }   

        Map<Character, char[]> map = new HashMap<>();
    
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        StringBuilder sb = new StringBuilder();
        helper(digits, 0, map, sb, ans);

        return ans;

    }
    private void helper(String digits,int i, Map<Character,char[]> map, StringBuilder sb ,List<String> ans){

        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }

        for(char c:map.get(digits.charAt(i))){
            sb.append(c);
            helper(digits,i+1,map,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}