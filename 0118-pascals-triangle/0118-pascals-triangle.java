class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp;

        res.add(new ArrayList<>(Arrays.asList(1)));

        if(numRows>1){

            res.add(new ArrayList<>(Arrays.asList(1,1)));

            for(int i=2;i<numRows;i++){
                temp = new ArrayList<>();
                temp.add(1);
                List<Integer> prev = res.get(res.size()-1);
                for(int j=0;j<prev.size()-1;j++){
                    temp.add(prev.get(j)+prev.get(j+1));
                }
                temp.add(1);
                res.add(temp);
            }

        }

        return res;
    }
}