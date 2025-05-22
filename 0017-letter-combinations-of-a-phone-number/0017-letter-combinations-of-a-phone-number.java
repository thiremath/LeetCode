class Solution {
    public List<String> letterCombinations(String digits) {

        HashMap<Integer,String> Charmap = new HashMap<>();
        Charmap.put(2,"abc");
        Charmap.put(3,"def");
        Charmap.put(4,"ghi");
        Charmap.put(5,"jkl");
        Charmap.put(6,"mno");
        Charmap.put(7,"pqrs");
        Charmap.put(8,"tuv");
        Charmap.put(9,"wxyz");

        char[] arr = digits.toCharArray();

        List<String> ans = new ArrayList<>();

        if(digits.length() != 0){
            letterCombinations(arr,0,ans,new StringBuilder(""),Charmap);
        }

        return ans;
    }

    public void letterCombinations(char[] arr, int index, List<String> ans, StringBuilder sb, HashMap<Integer,String> Charmap){

        if(index >= arr.length){
            ans.add(String.valueOf(sb));
            return;
        }

        // System.out.println(Charmap.get(Integer.valueOf(arr[index])));

        char[] comb = Charmap.get(Integer.valueOf(String.valueOf(arr[index]))).toCharArray();

        for(int i=0;i<comb.length;i++){
            sb.append(String.valueOf(comb[i]));
            letterCombinations(arr,index+1,ans,sb,Charmap);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}