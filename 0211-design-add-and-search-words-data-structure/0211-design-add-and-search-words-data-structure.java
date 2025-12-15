class WordDictionary {

    TrieNode head;

    class TrieNode{
        TrieNode[] arr;
        boolean isEndOfWord;

        public TrieNode(){
            arr = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = head;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            // System.out.println(idx);

            if(curr.arr[idx] == null){
                curr.arr[idx] = new TrieNode();
            }

            curr = curr.arr[idx];
        }

        curr.isEndOfWord = true;
    }   
    
    public boolean search(String word) {
        TrieNode curr = head;
        return searchHelper(word,0,curr);
    }

    public boolean searchHelper(String word, int idx, TrieNode curr){

        if(curr == null) return false;

        if(idx == word.length()){
            if(curr.isEndOfWord == true) return true;
            return false;
        }

        char currChar = word.charAt(idx);
        int indexOfCurrChar = currChar - 'a';

        if(currChar != '.'){
            return searchHelper(word,idx+1,curr.arr[indexOfCurrChar]);
        }

        for(int i=0;i<26;i++){
            if(curr.arr[i] != null){
                if(searchHelper(word,idx+1,curr.arr[i])) return true;
            }
        }

        return false;
    }
}

/**

[-,0,-,-,-,-,-]
[3,-,-,-,-,-,]

 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */