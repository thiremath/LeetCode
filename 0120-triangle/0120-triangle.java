class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> prev = triangle.get(n-1);
        List<Integer> curr = new ArrayList<>();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                curr = triangle.get(i);
                curr.set(j,curr.get(j)+Math.min(prev.get(j),prev.get(j+1)));
            }
            prev = curr;
        }
        return prev.get(0);
    }
}