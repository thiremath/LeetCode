class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>() ;

        for (String s : strs) {
            char c[] = s.toCharArray() ;
            Arrays.sort(c) ;
            String sortedString = String.valueOf(c);
            map.putIfAbsent(sortedString, new ArrayList<>()) ;
            map.get(sortedString).add(s) ;
        }
        
        return new ArrayList<>(map.values()) ;      
    }
}