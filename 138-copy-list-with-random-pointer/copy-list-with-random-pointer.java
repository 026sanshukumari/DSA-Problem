/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        
        Node oldTemp = head;
        
        while(oldTemp != null){
           map.put(oldTemp,new Node(oldTemp.val));
           oldTemp = oldTemp.next;
        }
        oldTemp = head;
        while(oldTemp != null){
            Node copyNode = map.get(oldTemp);
            copyNode.next = map.get(oldTemp.next);
            copyNode.random = map.get(oldTemp.random);
            oldTemp = oldTemp.next;
        }
        return map.get(head);
    }
}