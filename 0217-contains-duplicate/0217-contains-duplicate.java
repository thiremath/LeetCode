class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>() ;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i] ;
            int occ = 0 ;
            if(h.containsKey(curr))
                occ = h.get(curr) ;
            occ++ ;
            h.put(curr,occ) ;
            if(h.get(curr) >= 2)
                return true ;
        }
    return false ;
    }
}