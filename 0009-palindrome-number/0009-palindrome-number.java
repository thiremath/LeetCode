class Solution {
    public boolean isPalindrome(int x) {
        /**

        z = 0

        x=121
        12
        1
        0

        y = x%10 = 1
        2
        1

        z = z*10+y = 1
        12
        121
        


         */

        int z=0;
        int originalX = x;

        while(x>0){
            int y = x % 10;
            x = x / 10;
            z = z*10 + y;
        }

        // System.out.println(z);


        return z==originalX;


    }
}