class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Queue<Integer> q = new LinkedList<>();
        int[][] mut = new int[bank.length+1][bank.length+1];
        int endindex=-1,ans=1;

        for(int s=0;s<bank.length;s++){

            if(bank[s].equals(endGene)){
                endindex = s+1;
            }

            if(diff(startGene,bank[s])){

                mut[0][s+1] = 1;
                mut[s+1][0] = 1;
            }
        }

        if(endindex == -1){
            return -1;
        }

        for(int i=0;i<bank.length-1;i++){

            for(int j=i+1;j<bank.length;j++){

                if(diff(bank[i],bank[j])){

                    mut[i+1][j+1] = 1;
                    mut[j+1][i+1] = 1;
                }
            }
        }

        q.add(endindex);

        while(!q.isEmpty()){

            // for(int[] a: mut){
            //     for(int k: a){
            //         System.out.print(k+" ");
            //     }
            //     System.out.println("");
            // }
            
            int size=q.size();

            while(size-- != 0){
                int curr = q.remove();
                // System.out.println("queue"+curr);
                for(int i=0;i<mut[curr].length;i++){

                    if(mut[curr][i] == 1){
                        if(i == 0){
                            return ans;
                        }
                        q.add(i);
                        mut[curr][i]=0;
                        mut[i][curr]=0;
                    }
                }
            }

            // for(int[] a: mut){
            //     for(int k: a){
            //         System.out.print(k+" ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("");
            
            ans++;
        }   


        return -1;
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