class Solution {
    public int punishmentNumber(int n) {

        int ans=0;
        for(int i=1;i<=n;i++){
            char[] arr = Integer.toString(i*i).toCharArray();
            if(func(arr,0,i,0)){
                System.out.println(i);
                ans += i*i;
            }
            // System.out.println( func(Integer.toString(36*36).toCharArray(),0,36,0) );
        }
        return ans;
    }

    public boolean func(char[] arr, int index, int n, int curr) {

        // System.out.println("curr= "+ curr);

        if(index == arr.length){
            return (curr == n) ? true : false ;
        }

        int temp = 0;

        for(int i=index;i<arr.length;i++){
            temp = temp * 10 + Integer.valueOf( String.valueOf(arr[i]) ) ;
            if(func(arr,i+1,n,curr+temp)){
                return true;
            }
        }

        return false;

    }
    
}