class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        for(List<Integer> x1 : triangle){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<x1.size();i++){
                temp.add(-1);
            }
            dp.add(temp);
        }

        return minimumTotalWorker(triangle, dp, 0, 0);
    }

    public int minimumTotalWorker(List<List<Integer>> triangle, List<List<Integer>> dp, int index, int innerindex) {

        if(index == triangle.size() || innerindex == triangle.get(index).size()){
            return 0;
        }

        if(dp.get(index).get(innerindex) == -1){
            dp.get(index).add(innerindex, triangle.get(index).get(innerindex) + Math.min(minimumTotalWorker(triangle, dp, index+1, innerindex), minimumTotalWorker(triangle, dp, index+1, innerindex+1) ));
        }
        
        return dp.get(index).get(innerindex);
    }
}