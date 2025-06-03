class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans=0;
        Queue<Integer> queue = new LinkedList<>();
        int n = status.length;
        int[] boxesFound = new int[n];
        int[] usedBoxes = new int[n];

        for(int initialBox: initialBoxes){
            if(status[initialBox] == 1){
                queue.add(initialBox);
            }
            boxesFound[initialBox] = 1;
        }

        while(queue.size() > 0){
            int currBox = queue.poll();
            if(usedBoxes[currBox] == 0){
                usedBoxes[currBox] = 1;
                ans+=candies[currBox];

                for(int key: keys[currBox]){
                    status[key] = 1;
                    if(boxesFound[key] == 1){
                        queue.add(key);
                    }
                }

                for(int containedBox: containedBoxes[currBox]){
                    boxesFound[containedBox] = 1;
                    if(status[containedBox] == 1){
                        queue.add(containedBox);
                    }
                }
            }
        }

        return ans;
    }
}