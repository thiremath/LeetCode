class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Integer> q = new LinkedList<>();
        int[][] mut = new int[wordList.size()+1][wordList.size()+1];
        int endindex=-1,ans=1;

        for(int s=0;s<wordList.size();s++){

            if(wordList.get(s).equals(endWord)){
                endindex = s+1;
            }

            if(diff(beginWord,wordList.get(s))){

                mut[0][s+1] = 1;
                mut[s+1][0] = 1;
            }
        }

        if(endindex == -1){
            return 0;
        }

        for(int i=0;i<wordList.size()-1;i++){

            for(int j=i+1;j<wordList.size();j++){

                if(diff(wordList.get(i),wordList.get(j))){

                    mut[i+1][j+1] = 1;
                    mut[j+1][i+1] = 1;
                }
            }
        }

        q.add(endindex);

        while(!q.isEmpty()){
            
            int size=q.size();

            while(size-- != 0){
                int curr = q.remove();
                for(int i=0;i<mut[curr].length;i++){

                    if(mut[curr][i] == 1){
                        if(i == 0){
                            return ans+1;
                        }
                        q.add(i);
                        mut[curr][i]=0;
                        mut[i][curr]=0;
                    }
                }
            }
            
            ans++;
        }   


        return 0;
    }

    public boolean diff(String a, String b){

        int flag = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                if(flag == 1){
                    return false;
                }
                flag=1;
            }
        }

        return true;
    }

}