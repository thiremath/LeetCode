class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0) return true;

        int i = 0;

        while(i<flowerbed.length){
            if(flowerbed[i] == 0){
                if(i==0 || flowerbed[i-1]==0){
                    if(i==flowerbed.length-1 || flowerbed[i+1]==0){
                        flowerbed[i] = 1;
                        if(--n == 0){
                            return true;
                        }
                        else{
                            i+=2;
                            continue;
                        }
                    }
                }
            }
            i++;
        }

        return false;       
    }
}