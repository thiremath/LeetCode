class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        HashMap<Integer,Integer> map[] = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }
        return changeWorker(amount, coins, 0, map);
    }

    public int changeWorker(int amount, int[] coins, int index, HashMap<Integer,Integer> map[]) {

        // System.out.println(amount+" "+index);

        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (map[index].containsKey(amount)) {
            return map[index].get(amount);
        }

        if(amount < coins[index]){
            map[index].put(amount,0);
            return 0;
        }

        int ans = changeWorker(amount - coins[index], coins, index, map)
                + changeWorker(amount, coins, index + 1, map);

        map[index].put(amount,ans);

        return ans;
    }
}