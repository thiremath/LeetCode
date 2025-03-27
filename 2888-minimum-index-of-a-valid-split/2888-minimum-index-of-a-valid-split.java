class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();

        // create a full hashmap
        HashMap<Integer,Integer> mainMap = new HashMap<>();
        HashMap<Integer,Integer> currMap = new HashMap<>();

        // traverse nums
        for(Integer num: nums){
            mainMap.put(num,1+mainMap.getOrDefault(num,0));
            // System.out.println(mainMap.get(num));
        }

         /**
            remove curr from main map
            add curr in currmap
            check if any dominant in curr and check split dominant for curr
          */

        for(int i=0;i<n-1;i++){

            int curr = nums.get(i);

            mainMap.put(curr,mainMap.get(curr)-1);

            currMap.put(curr,1+currMap.getOrDefault(curr,0));

            if(currMap.get(curr) * 2 > i+1){
            // System.out.println("mainMap.get(num)");
                // System.out.println("i =  "+i+" "+mainMap.get(curr));
                if(mainMap.get(curr) * 2 > n-i-1){
                    // System.out.println("mainMap.get(num)");
                    return i;
                }
            }
        }


        return -1;

    }

}