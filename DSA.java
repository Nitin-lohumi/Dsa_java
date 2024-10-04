public class DSA {
    int val;
    DSA next;

    DSA() {
    }
    DSA(int val) {
        this.val = val;
    }
    DSA(int val, DSA next) {
        this.val = val;
        this.next = next;
    }
}
class Solution{
    public DSA removeNthFromEnd(DSA head, int n) {
        DSA DummyNode =new DSA(0,head);
        DSA result =DummyNode;
        for (int i = 0; i<n; i++) {
            head = head.next;
        }
        while(head!=null){
            head = head.next;
            DummyNode = DummyNode.next;
        }
        DummyNode.next= DummyNode.next.next;
        return result.next;
    }
}
