class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        Arrays.sort(folder);

        int high=-1;
        String prev="-";

        while(++high < folder.length){
            if(!folder[high].startsWith(prev)){
                ans.add(folder[high]);
                prev = folder[high]+"/";
            }
        }

        // for(String s: folder){
        //     set.add(s);
        // }

        // for(String s: folder){
        //     if(s.split("/").length == 2){
        //         ans.add(s);
        //     }

        //     else{
        //         int index = s.length()-1;
        //         while(index > 0){
        //             while(s.charAt(index) != '/'){
        //                 index--;
        //             }
        //             if(set.contains(s.substring(0,index))){
        //                 break;
        //             }
        //             index--;
        //         }
        //         if(index <= 0){
        //             ans.add(s);
        //         }
        //     }
        // }

        return ans;
    }
}