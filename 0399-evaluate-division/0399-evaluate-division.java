class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] arr = new double[queries.size()];
        HashMap<String,Integer> map = new HashMap<>();
        // boolean[] isNode = new boolean[26];
        double[][] weight = new double[40][40];
        List<List<Integer>> adjlist = new ArrayList<>();

        // for(int i=0;i<26;i++){
        //     adjlist.add(new ArrayList<Integer>());
        // }

        for(double[] row: weight){
            Arrays.fill(row,-1);
        }

        // int counter=0;
        int indexcounter = -1;

        for(int i=0;i<equations.size();i++){

            if(! map.containsKey(equations.get(i).get(0)) ){
                map.put(equations.get(i).get(0),++indexcounter);
                adjlist.add(new ArrayList<Integer>());
            }

            if(! map.containsKey(equations.get(i).get(1)) ){
                map.put(equations.get(i).get(1),++indexcounter);
                adjlist.add(new ArrayList<Integer>());
            }

            int index0 = map.get(equations.get(i).get(0)) ;
            int index1 = map.get(equations.get(i).get(1)) ;

            weight[index0][index1] = values[i];
            weight[index1][index0] = 1 / values[i];
            weight[index0][index0] = 1;
            weight[index1][index1] = 1;

            adjlist.get(index0).add(index1);
            adjlist.get(index1).add(index0);

            // if(!isNode[index0]){
            //     isNode[index0] = true;
            // }
            // if(!isNode[index1]){
            //     isNode[index1] = true;
            // }
            // counter++;
        }

        // counter=0;
        // double[][] weight = new double[indexcounter+1][indexcounter+1];

        // for(double[] row: weight){
        //     Arrays.fill(row,-1);
        // }

        for(int i=0;i<queries.size();i++){

            if( (! map.containsKey(queries.get(i).get(0))) || (! map.containsKey(queries.get(i).get(1))) ){
                arr[i] = -1;
            }

            else{

                int index0 = map.get(queries.get(i).get(0)) ;
                int index1 = map.get(queries.get(i).get(1)) ;

                if(weight[index0][index1] != -1){
                    arr[i] = weight[index0][index1];
                }

                else{
                    arr[i] = calcWeight(index0, index1, adjlist, weight, new ArrayList<>());
                    // weight[index0][index1] = arr[i];
                    // weight[index1][index0] = 1 / arr[i];
                }

            }

            // counter++;
        }


        return arr;
    }

    public double calcWeight(int index0, int index1, List<List<Integer>> adjList, double[][] weight, List<Integer> recPath){
        // double ans = -1;

        recPath.add(index0);

        if(weight[index0][index1] != -1){
            return weight[index0][index1];
        }

        for(Integer adj : adjList.get(index0)){
            if(! recPath.contains(adj) ){
                double tempans = calcWeight(adj,index1,adjList,weight,recPath);
                if(tempans != -1){
                    weight[adj][index1] = tempans;
                    weight[index1][adj] = 1 / tempans;

                    weight[index0][index1] = weight[index0][adj] * tempans;
                    weight[index1][index0] = 1 / weight[index0][index1];

                    return weight[index0][index1];
                }
            }
        }

        return -1;

    }    

}