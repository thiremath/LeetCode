class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
        
        [1],[2,3,4]
        1,2,3,4

        res = nums[n/2]+nums[n/2-1]/2

         */

         int m=0,n=0;
         int midEleIdx2 = (nums1.length+nums2.length)/2;
         int midEleIdx1 = midEleIdx2-1;
         double midEle1 = 0;
         double midEle2 = 0;
         int index=0;

         if(nums1.length==0 && nums2.length==0) return 0;

         while(m<nums1.length && n<nums2.length){

            if(index==midEleIdx1){
                midEle1 = Math.min(nums1[m],nums2[n]);
            }

            if(index==midEleIdx2){
                midEle2 = Math.min(nums1[m],nums2[n]);
            }

            if(nums1[m] <= nums2[n]){
                m++;
            }

            else{
                n++;
            }

            index++;
        }

        while(m<nums1.length){
            if(index==midEleIdx1){
                midEle1 = nums1[m];
            }

            if(index==midEleIdx2){
                midEle2 =nums1[m];
            }

            m++;
            index++;
        }

        while(n<nums2.length){
            if(index==midEleIdx1){
                midEle1 = nums2[n];
            }

            if(index==midEleIdx2){
                midEle2 =nums2[n];
            }

            n++;
            index++;
        }

        if((nums1.length+nums2.length)%2==0){
            return (midEle1+midEle2)/2.0;
        }

        return midEle2;
    }
}