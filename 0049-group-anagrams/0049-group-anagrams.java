class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans  = new ArrayList<List<String>>();
        HashMap<String,List<String>> h = new HashMap<String,List<String>>() ;
        for(int i=0;i<strs.length;i++){
            List<String> temp = new ArrayList<String>();
            char c[] = strs[i].toCharArray() ;
            Arrays.sort(c) ;
            String s = new String(c) ;
            if(h.containsKey(s)){
                temp = h.get(s) ;
            }
            temp.add(strs[i]) ;
            h.put(s,temp) ;
        }
        for(HashMap.Entry<String,List<String>> m : h.entrySet()){
            ans.add(m.getValue()) ;
        }
        return ans ;      
    }
}