class Solution {

    private Map<String,Integer> dpMap = new HashMap<>();

    public int minDistance(String word1, String word2) {

        // insertion
        if(word1.length()==0 || word2.length()==0){
            if(word1.length()==0) return word2.length();
            return word1.length();
        }

        String st = String.valueOf(new StringBuilder(word1).append(" ").append(word2));

        if(dpMap.containsKey(st)) return dpMap.get(st);        

        int res = Integer.MAX_VALUE;

        // if first char same call rec
        if(word1.charAt(0) == word2.charAt(0)){
            res = minDistance(word1.substring(1,word1.length()),word2.substring(1,word2.length()));
        }

        // diff first chars
        else{
            // delete first char of word1
            res = Math.min(res,1+minDistance(word1.substring(1,word1.length()),word2));

            // delete first char of word2
            res = Math.min(res,1+minDistance(word1,word2.substring(1,word2.length())));

            // perform replace

            res = Math.min(res,1+minDistance(word1.substring(1,word1.length()),word2.substring(1,word2.length())));
        }

        dpMap.put(st,res);

        return res;
    }
}


/**

abc , kbc

 */