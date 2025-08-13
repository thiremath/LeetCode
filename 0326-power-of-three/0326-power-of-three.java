class Solution {
    public boolean isPowerOfThree(int n) {
        return (n <= 0) ? false : Integer.toString(n, 3).replace("0","").equals("1");
    }
}