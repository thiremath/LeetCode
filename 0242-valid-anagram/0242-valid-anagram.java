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
            s_occ = 0 ;
            t_occ = 0 ;
            if(sHash.containsKey(s.charAt(i))){
                s_occ = sHash.get(s.charAt(i)) ;
            }
            if(tHash.containsKey(t.charAt(i))){
                t_occ = tHash.get(t.charAt(i)) ;
            }
            s_occ++ ;
            t_occ++ ;
            sHash.put(s.charAt(i),s_occ) ;
            tHash.put(t.charAt(i),t_occ) ;
        }
        if(sHash.equals(tHash)){
            return true ;
        }
        return false ;
    }
}