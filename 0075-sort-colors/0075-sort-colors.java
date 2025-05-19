class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;    
        int red=0,white=0,blue=n-1;

        while(white <= blue && red <= blue){
            int numWhite = nums[white];
            if(numWhite == 2){
                swap(nums,white,blue);
                blue--;
            }
            else if(numWhite == 0){
                swap(nums,white,red);
                red++;
                white = red;
            }
            else{  
                white++;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}