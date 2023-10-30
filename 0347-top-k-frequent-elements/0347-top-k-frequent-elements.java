class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        ArrayList<Integer>[] occ = new ArrayList[nums.length+1];
        ArrayList<Integer> resTemp = new ArrayList<>();

        for(int i: nums){
            map.putIfAbsent(i,0) ;
            map.put(i,(map.get(i)+1)) ;
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(occ[m.getValue()] == null){
                occ[m.getValue()] = new ArrayList<>() ;
            }
            occ[m.getValue()].add(m.getKey()) ;
        }

        for(int i=occ.length-1,z=k; i>0 && z>0; i--){
            if(occ[i] != null){
                System.out.println(occ[i]) ;
                if(resTemp.size()+occ[i].size() > k){
                    break ;
                }
                resTemp.addAll(occ[i]) ;
                z-- ;
            }
        }

        int[] res = resTemp.stream().mapToInt(i -> i).toArray();

        return res ;

    }
}