class Solution {
    public int candy(int[] ratings) {
        int ans=0;
        int n = ratings.length;
        int[] candiesarr = new int[n];

        for(int i=0;i<n;i++){
            if(candiesarr[i] == 0){
                candyworker(ratings,candiesarr,i);
            }
            ans+=candiesarr[i];
        }

        return ans;
    }

    public int candyworker(int[] ratings, int[] candiesarr, int index){
        int leftans = -1, rightans = -1;

        if(candiesarr[index] != 0){
            return candiesarr[index];
        }

        if(index-1 >= 0 && ratings[index] > ratings[index-1]){
            leftans = candyworker(ratings,candiesarr,index-1);
        }

        if(index+1 < ratings.length && ratings[index] > ratings[index+1]){
            rightans = candyworker(ratings,candiesarr,index+1);
        }

        if(leftans == -1 && rightans == -1){
            return candiesarr[index] = 1;
        }

        return candiesarr[index] = 1+Math.max(leftans,rightans);
    }   
}