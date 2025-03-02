class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int[] inner: nums1){
            if(map.containsKey(inner[0])){
                map.put(inner[0],inner[1]+map.get(inner[0]));
            }
            else{
                map.put(inner[0],inner[1]);
            }
        }

        for(int[] inner: nums2){
            if(map.containsKey(inner[0])){
                map.put(inner[0],inner[1]+map.get(inner[0]));
            }
            else{
                map.put(inner[0],inner[1]);
            }
        }

        int[][] res = new int[map.size()][2];
        int index=-1;

        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {

            res[++index][0] = mapElement.getKey();
            res[index][1] = mapElement.getValue();
        }

        Arrays.sort(res, (x, y) -> Integer.compare(x[0],y[0]));

        return res;
        
    }
}