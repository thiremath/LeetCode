class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(String s: folder){
            set.add(s);
        }

        for(String s: folder){
            if(s.split("/").length == 2){
                ans.add(s);
            }

            else{
                int index = s.length()-1;
                while(index > 0){
                    while(s.charAt(index) != '/'){
                        index--;
                    }
                    String curr = s.substring(0,index);
                    if(set.contains(curr)){
                        break;
                    }
                    index--;
                }
                if(index <= 0){
                    ans.add(s);
                }
            }
        }

        return ans;
    }
}