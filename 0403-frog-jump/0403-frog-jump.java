class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> dp = new HashMap<>();
        return canCrossWorker(stones,0,0,dp);
    }

    public boolean canCrossWorker(int[] stones, int index, int prev, Map<Integer,Set<Integer>> dp) {

        if(index == stones.length-1){
            return true;
        }

        if(prev == 0){
            if(stones[1] == 1){
                return canCrossWorker(stones,1,1,dp);
            }
            return false;
        }

        if(dp.containsKey(index) && dp.get(index).contains(prev)){
            return false;            
        }

        int minJump = prev - 1;
        int maxJump = prev + 1;

        for(int i=index+1;i<stones.length;i++){

            int jump = stones[i]-stones[index];

            if(jump > maxJump){
                break;
            }

            if(jump >= minJump && jump <= maxJump){
                if(canCrossWorker(stones,i,stones[i]-stones[index],dp)){
                    return true;
                }
            }
        }

        if(!dp.containsKey(index)){
            dp.put(index,new HashSet<>());
        }

        dp.get(index).add(prev);

        return false;
    }
}