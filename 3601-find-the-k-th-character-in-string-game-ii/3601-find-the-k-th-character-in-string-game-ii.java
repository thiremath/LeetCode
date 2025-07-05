class Solution {
    public char kthCharacter(long k, int[] operations) {
        return (char)((long) 'a' + (kthCharacterWorker(k,operations) % 26));
    }

    public long kthCharacterWorker(long k, int[] operations) {
        if(k == 1){
            return 0;
        }

        int index = (int) (Math.ceil(Math.log(k)/Math.log(2))) - 1;

        long ans = kthCharacterWorker(k-(long)Math.pow(2,index),operations);

        if(operations[index] == 1){
            ans++;
        }

        return ans;

    }
}

/**

a 0

ab 01

abbc 0112

abbcbccd 01121223

abbcbccdbccdcdde 0112122312212334

abbcbccdbccdcddebccdcddecddedeef

 */