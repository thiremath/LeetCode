class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> Hash = new HashMap<Character,Integer>() ;
        if(s.length() != t.length()){
            return false ;
        }
        for(int i=0;i<s.length();i++){
            Hash.put(s.charAt(i), Hash.getOrDefault(s.charAt(i), 0) + 1);
            Hash.put(t.charAt(i), Hash.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int val: Hash.values()){
            if(val != 0){
                return false ;
            }
        }
        
        return true ;
    }
}