class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(String s: folder){
            set.add(s);

        }

        for(String s: folder){
            String[] arr = s.split("/");
            // for(String scurr:arr){
            //     System.out.println(scurr);
            // }
            // System.out.println("len = "+arr.length);
            // System.out.println("");

            if(arr.length == 2){
                ans.add(s);
            }

            else{
                // String temp = "";
                int index = s.length()-1;
                while(index > 0){
                    while(s.charAt(index) != '/'){
                        index--;
                    }
                    String curr = s.substring(0,index);
                    // System.out.println("curr = "+curr);
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