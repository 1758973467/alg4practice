import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLinkedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
    @Test
    public void test(){
       //con
        int[]array={3,2,0,-4};
        ListNode head=new ListNode(3);
        for (int i = 1; i < array.length; i++) {
            ListNode tmp=new ListNode(array[i]);
            addAtTail(head,tmp);
        }
        ListNode current=head;
        for(;current.next!=null;current=current.next){}
        ListNode oldLast=current;
        assert oldLast.next==null;
        oldLast.next=head.next;
        Assert.assertEquals(detectCycle(head).val,2);

    }
    public void addAtTail(ListNode head,ListNode tailNode) {
        ListNode current=head;
        for(;current.next!=null;current=current.next){}
        ListNode oldLast=current;
        oldLast.next=tailNode;
    }
    public ListNode detectCycle(ListNode head) {
        //empty list
        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode quick=head;
        do{
            if(quick.next==null||quick.next.next==null){
                return null;
            }
            quick=quick.next.next;
            slow=slow.next;
        }while(slow!=quick);

        for(ListNode cycleNode=head;;cycleNode=cycleNode.next){
            //use quick ,slow pointer to find cycleNode
            do{
                if(slow==cycleNode){
                    return cycleNode;
                }

                quick=quick.next.next;
                slow=slow.next;
            }while(slow!=quick);
        }

    }
}
