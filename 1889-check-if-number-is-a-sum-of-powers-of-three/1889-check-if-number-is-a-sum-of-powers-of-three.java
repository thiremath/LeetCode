class Solution {
    public boolean checkPowersOfThree(int n) {
        int i=-1;

        while((int)Math.pow(3,++i) < n){}

        if((int)Math.pow(3,i) == n){
            return true;
        }

        // System.out.println("Initial i = "+i);

        while(--i >= 0 && n>0){
            // System.out.println("i and n = "+i+" "+n);
            while(i >= 0 && (int)Math.pow(3,i) > n){
                i--;
            }
            if(i >= 0){
                n -= (int)(Math.pow(3,i));
            }
        }

        return (n == 0) ? true:false;
    }
}