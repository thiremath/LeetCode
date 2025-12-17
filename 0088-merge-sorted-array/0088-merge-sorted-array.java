class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1, index2 = n-1, k = m+n-1;

        while(index1 >= 0 || index2 >= 0){

            if(index1 >= 0 && index2 >= 0){

                if(nums1[index1] >= nums2[index2]){
                    nums1[k] = nums1[index1];
                    index1--;
                    k--;
                }

                else{
                    nums1[k] = nums2[index2];
                    index2--;
                    k--;
                }
            }

            else if(index1 >= 0){
                nums1[k] = nums1[index1];
                index1--;
                k--;
            }

            else{
                nums1[k] = nums2[index2];
                index2--;
                k--;
            }
        }

    }
}