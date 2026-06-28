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
        if(head == null ){
            return null;
        }
        Node temp = head;
        //insert copy node in between
        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            Node copy = temp.next;
            if(temp.random == null){
                copy.random =null;
            } else {
                copy.random = temp.random.next;
            }
            temp = temp.next.next; 
        }
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
