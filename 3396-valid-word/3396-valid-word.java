class Solution {
    public boolean isValid(String word) {

        boolean onevowel = false;
        boolean oneconsonant = false;

        if(word.length() < 3){
            return false;
        }

        word = word.toLowerCase();


        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if((c-'0' <= 9 && c-'0' >= 0) || (c-'a' <= 25 && c-'a' >= 0)){
                if(!onevowel && (c == 'a' || c=='e' || c=='i' || c=='o' || c=='u')){
                    onevowel = true;
                }
                if(!oneconsonant && (c-'a' <= 25 && c-'a' >= 0) && !(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u')){
                    oneconsonant = true;
                }
            }
            else{
                return false;
            }
        }

        return onevowel && oneconsonant;
    }
}