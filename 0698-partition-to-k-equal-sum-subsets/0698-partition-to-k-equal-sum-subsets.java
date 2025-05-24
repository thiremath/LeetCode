class Solution {
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    // public Solution() {
    //     this.sums = new int[k];
    // }

    // Depth First Search function.
    public boolean dfs(int index, int k) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size()) {
            for(int i=1;i<sums.length;i++){
                if(sums[i] != sums[i-1]){
                    return false;
                }
                // return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }
            return true;
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < k; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                int j = i;
                while (--j >= 0) // third
                    if (sums[i] == sums[j]) 
                        break;
                if (j != -1) continue;
                this.sums[i] += element;
                if (this.dfs(index + 1,k)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        sums = new int[k];

        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        this.possibleSquareSide =  perimeter / k;
        if (this.possibleSquareSide * k != perimeter) {
            return false;
        }

        // Convert the array of primitive int to ArrayList (for sorting).
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return this.dfs(0,k);
    }
}