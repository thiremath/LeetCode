class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        partitionWorker(s,0,new ArrayList<>());
        return ans;
    }

    public void partitionWorker(String s,int index, List<String> curr) {
        // System.out.println(curr);
        // System.out.println("ans "+ ans);

        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
                curr.add(sub);
                partitionWorker(s,i+1,curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int low=0;
        int high = s.length()-1;

        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    
}