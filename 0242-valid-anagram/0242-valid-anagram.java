class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sHash = new HashMap<Character,Integer>() ;
        HashMap<Character,Integer> tHash = new HashMap<Character,Integer>() ;
        int s_occ = 0 ;
        int t_occ = 0 ;
        int slength = s.length() ;
        int tlength = t.length() ;
        if(slength != tlength){
            return false ;
        }
        for(int i=0;i<s.length();i++){
            sHash.put(s.charAt(i), sHash.getOrDefault(s.charAt(i), 0) + 1);
            tHash.put(t.charAt(i), tHash.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(sHash.equals(tHash)){
            return true ;
        }
        return false ;
    }
}