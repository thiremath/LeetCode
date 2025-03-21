class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String,Integer> recipeMap = new HashMap<>();
        HashSet<String> supplySet = new HashSet<>();
        int[][] edges = new int[recipes.length][recipes.length];
        int[] isPossible = new int[recipes.length];
        List<String> res = new ArrayList<>();

        for(int i=0;i<recipes.length;i++){
            recipeMap.put(recipes[i],i);
        }

        for(String supply: supplies){
            supplySet.add(supply);
        }

        for(int i=0;i<recipes.length;i++){
            if(isPossible[i] == 0){
                findAllRecipesWorker(recipes,i,recipeMap,ingredients,supplySet,edges,isPossible);
            }
            if(isPossible[i] == 1){
                res.add(recipes[i]);
            }
        }

        return res;
    }

    public boolean findAllRecipesWorker(String[] recipes, int index, HashMap<String,Integer> recipeMap, List<List<String>> ingredients, HashSet<String> supplySet, int[][] edges, int[] isPossible) {

        if(isPossible[index] == 1){
            return true;
        }

        else if(isPossible[index] == -1){
            return false;
        }

        isPossible[index] = -1;

        for(String currIn: ingredients.get(index)){

            if(!supplySet.contains(currIn)){
                
                if(!recipeMap.containsKey(currIn)){
                    return false;
                }

                int temp = recipeMap.get(currIn);

                if(isPossible[temp] == -1){
                    return false;
                }

                if(isPossible[temp] == 0){
                    findAllRecipesWorker(recipes,temp,recipeMap,ingredients,supplySet,edges,isPossible);
                    if(isPossible[temp] == -1){
                        return false;
                    }
                }
            }
        }

        isPossible[index] = 1;

        return true;
    }
}
