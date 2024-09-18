class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] arr = new double[queries.size()];
        HashMap<String,Integer> map = new HashMap<>();
        double[][] weight = new double[40][40];
        List<List<Integer>> adjlist = new ArrayList<>();
        int indexcounter = -1;

        for(double[] row: weight){
            Arrays.fill(row,-1);
        }


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

        }


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
                }

            }

        }

        return arr;
    }

    public double calcWeight(int index0, int index1, List<List<Integer>> adjList, double[][] weight, List<Integer> recPath){

        recPath.add(index0);

        if(weight[index0][index1] == -1){

            for(Integer adj : adjList.get(index0)){

                if(! recPath.contains(adj) ){

                    weight[adj][index1] = calcWeight(adj,index1,adjList,weight,recPath);
                    weight[index1][adj] = 1 / weight[adj][index1];

                    if(weight[adj][index1] != -1){

                        weight[index0][index1] = weight[index0][adj] * weight[adj][index1];
                        weight[index1][index0] = 1 / weight[index0][index1];

                        break;
                    }

                }

            }
            
        }

        return weight[index0][index1];

    }    

}