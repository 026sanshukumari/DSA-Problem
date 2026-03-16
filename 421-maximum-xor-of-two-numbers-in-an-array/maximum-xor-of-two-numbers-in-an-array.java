class Node{
    Node children[] = new Node[2];
}
class Solution {
    Node root = new Node();
    public void insert(int num){
        Node curr = root;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(curr.children[bit] == null){
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
        }
    }
    public int getMax(int num){
        Node curr = root;
        int maxXor = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            int opp = 1 - bit;
            if(curr.children[opp] != null){
                maxXor |= (1 << i);
                curr = curr.children[opp];
            }else{
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }
    public int findMaximumXOR(int[] nums) {
        for(int num : nums){
            insert(num);
        }
        int max = 0;
        for(int num : nums){
            max = Math.max(max, getMax(num));
        }
        return max;
    }
}