class Solution {

    public static void sortbyColumn(int a[][], int c){      
        Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c]));  
    }  

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

        sortbyColumn(res,0);

        return res;
        
    }
}