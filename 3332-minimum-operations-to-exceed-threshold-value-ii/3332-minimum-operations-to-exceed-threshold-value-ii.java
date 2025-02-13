class Solution {
    public int minOperations(int[] nums, int k) {
        // heapify
        int n = nums.length;
        int ans=0;

        for(int i=n/2-1;i>=0;i--){

            heapify(nums,n,i);
        }

        // for(int i: nums){
        //     System.out.println(i);
        // }

        while(n>=2 && nums[0] < k){
            // System.out.println(n);
            // for(int i: nums){
            //     System.out.print(i+" ");
            // }
            // System.out.println("");
            
            int temp=0;
            ans++;

            temp = nums[0]; 
            nums[0] = nums[n-1];
            nums[n-1] = temp;

            heapify(nums,n-1,0);
            n--;

            nums[0] = (Math.min(temp,nums[0])*2) + Math.max(temp,nums[0]) ;
            if(nums[0] < 0){
                nums[0] = Integer.MAX_VALUE;
            }
            heapify(nums,n,0);
                    
        }

        return ans;
    }

    static void heapify(int arr[], int n, int i) {

        // Initialize largest as root
        int smallest = i; 

        // left index = 2*i + 1
        int l = 2 * i + 1; 

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }

        // If largest is not root
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
        }    
    }
}