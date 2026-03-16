class Node{
    Node children[] = new Node[26];
    boolean eow = false;
    
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String word){
        return helper(word,0,root);
    }

    private boolean helper(String word,int i,Node node){

        if(node == null) return false;

        if(i == word.length()){
            return node.eow;
        }

        char ch = word.charAt(i);

        if(ch == '.'){
            for(int j=0;j<26;j++){
                if(helper(word,i+1,node.children[j])){
                    return true;
                }
            }
            return false;
        }

        int idx = ch - 'a';

        return helper(word,i+1,node.children[idx]);
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */