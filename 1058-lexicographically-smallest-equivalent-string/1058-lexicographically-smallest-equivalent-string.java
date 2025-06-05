class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        int n = s1.length();

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        for(int i=0;i<n;i++){
            union(s1arr[i]-'a',s2arr[i]-'a',parent);
        }

        StringBuilder ans = new StringBuilder("");

        char[] baseStrarr = baseStr.toCharArray();

        for(char c: baseStrarr){
            ans.append((char)(find(c-'a',parent)+'a'));
        }

        return String.valueOf(ans);
    }

    public void union(int a, int b, int[] parent){
        int aP = find(a,parent);
        int bP = find(b,parent);

        if(aP > bP){
            parent[aP] = bP;
        }

        else{
            parent[bP] = aP;
        }
    }

    public int find(int a, int[] parent){
        if(parent[a] == a){
            return a;
        }
        return find(parent[a],parent);
    }
}