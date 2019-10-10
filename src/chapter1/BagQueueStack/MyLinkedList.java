package chapter1.BagQueueStack;

public class MyLinkedList {
    private class Node{
        int val;
        Node next=null;
    }
    Node head=null;//头节点
    int N=0;//count
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(N<index+1||index<0){
            return -1;
        }
        Node current=head;
        for(int i=0;i<index;i++){
            current=current.next;
            assert current!=null;
        }
        return current.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head==null){
            head=new Node();
            head.val=val;
        }else{
            Node oldHead=head;
            head=new Node();
            head.val=val;
            head.next=oldHead;
        }
        N++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head==null){
            head=new Node();
            head.val=val;
        }else{
            Node current=head;
            for(;current.next!=null;current=current.next){}
            Node oldLast=current;
            Node last=new Node();
            last.val=val;
            oldLast.next=last;
        }
        N++;
    }
    //index 索引
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(N<index){
            return;
        }
        if(index<=0){
            addAtHead(val);
        }else if(N==index){
            addAtTail(val);
        }else{
            Node current=head;
            for(int i=0;i<index-1;i++){
                current=current.next;
                assert current!=null;
            }
            Node pre=current;
            Node insertNode=new Node();
            insertNode.val=val;
            insertNode.next=pre.next;
            pre.next=insertNode;
            N++;
        }
    }
    //index 是索引
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //empty list or
        if(N<index+1||index<0||N==0){
           return;
        }
        //delete head
        if(index==0){
            head=head.next;
        }
        //delete tail
        else if(N==index+1){
            assert N>=2;
            Node current=head;
            for(;current.next.next!=null;current=current.next){}
            current.next=null;
        }else{
            assert N>=2;
            Node pre=head;
            int tmpi=0;
            for(;tmpi<index-1;tmpi++){
                pre=pre.next;
            }
            pre.next=pre.next.next;
        }
        N--;
    }


}
