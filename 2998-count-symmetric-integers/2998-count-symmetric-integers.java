class Solution {

    public int countSymmetricIntegers(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++){
            if(isSymmetric(String.valueOf(i))){
                res++;
            }
        }
        return res;
    }

    public boolean isSymmetric(String s){
        if(s.length() % 2 != 0){
            return false;
        }

        char arr[] = s.toCharArray();

        int left = (arr.length/2) - 1;
        int right = arr.length/2;

        int leftAdd=0,rightAdd=0;

        while(left >= 0){
            leftAdd += arr[left];
            rightAdd += arr[right];
            left--;
            right++;
        }

        return leftAdd == rightAdd;
    }
}