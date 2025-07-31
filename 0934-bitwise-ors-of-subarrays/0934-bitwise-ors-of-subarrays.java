class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int i: arr){
            Set<Integer> curr = new HashSet<>();
            for(Integer p: prev){
                curr.add(p|i);
            }
            curr.add(i);
            prev = curr;
            res.addAll(curr);
        }

        return res.size();
    }
}