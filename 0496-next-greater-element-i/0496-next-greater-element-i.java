class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> increasingSt = new Stack<>();

        Map<Integer,Integer> mapAns = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){

            while(!increasingSt.isEmpty() && increasingSt.peek() <= nums2[i]){
                increasingSt.pop();
            }

            if(increasingSt.isEmpty()){
                mapAns.put(nums2[i],-1);
            }

            else{
                mapAns.put(nums2[i],increasingSt.peek());
            }

            increasingSt.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for(int i=0;i<res.length;i++){
            if(!mapAns.containsKey(nums1[i])){
                res[i] = -1;
            }
            else{
                res[i] = mapAns.get(nums1[i]);
            }
        }

        return res;
    }
}