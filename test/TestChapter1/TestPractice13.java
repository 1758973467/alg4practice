package TestChapter1;

import chapter1.BagQueueStack.*;
import chapter1.Date;
import chapter1.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.StringReader;
import java.util.Scanner;

public class TestPractice13 {
    private Practice13 practice=new Practice13();
    @Test
    public void Test131(){
        FixedCapacityStackOfString stack=new FixedCapacityStackOfString(5);
        String s="to be or not to - be - - that - - - is";
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(!item.equals("-")){
                if(stack.isFull()){
                    System.out.println("stack is full");
                    break;
                }
                stack.push(item);
            }else{
                System.out.print(stack.pop()+" ");
            }
        }
        System.out.println("size:"+stack.size()+" ");
        scanner.close();
    }

    @Test
    public void Test132(){
        var stack=new FixedCapacityStackOfString(100);
        String s="it was - the best - of times - - - it was - the - -";
        StringBuilder result=new StringBuilder();
        Scanner scanner=new Scanner(new StringReader(s));

        while (scanner.hasNext()){
            String item=scanner.next();
            if(!item.equals("-")){
                stack.push(item);
            }else{
                result.append(stack.pop()+" ");
            }
        }
        scanner.close();
        Assert.assertEquals(result.toString(),"was best times of the was the it ");
        Assert.assertEquals(stack.size(),1);

    }
    @Test
    public void Test134(){
        Assert.assertEquals(practice.Practice134("[ ( ) ] { } { [ ( ) ( ) ] ( ) } "),true);
        Assert.assertEquals(practice.Practice134("[ ( ] } "),false);
    }
    @Test
    public void Test137(){
        Stack<String>stack=new ResizingArrayStack<>();
        stack.push("str");
        Assert.assertEquals(stack.peek(),"str");
        Assert.assertEquals(stack.size(),1);
    }
    @Test
    public void Test138(){
        String s="it was - the best - of times - - - it was - the - -";

        Stack<String>stack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(!item.equals("-")){
                stack.push(item);
                System.out.println(stack);
            }else{
                System.out.println(stack.pop());
                System.out.println(stack);
            }
        }
        scanner.close();
    }
    @Test
    public void Test139(){
        Assert.assertEquals(practice.Dijkstra("1 + 2 + ) * 3 - 4 ) * 5 - 6 ) ) )"),3.0);
        Assert.assertEquals(practice.Practice139("1 + 2 + ) * 3 - 4 ) * 5 - 6 ) ) )"),"((1+2)*((3-4)*(5-6)))");
    };
    @Test
    public void Test1310(){
        String result=practice.Practice1310("1 + 2 + ) * 3 - 4 ) * 5 - 6 ) ) )");
        Assert.assertEquals(result.split(" +"),"1 2 + 3 4 - 5 6 - * *".split(" +"));
    }

    @Test
    public void Test1311(){
        //evaluate Postfix
        String result=practice.Practice1310("1 + 2 + ) * 3 - 4 ) * 5 - 6 ) ) )");
        Assert.assertEquals(practice.Practice1311(result),3.0);
    }
    @Test
    public void Test1312(){
        String s="1 + 2 + ) * 3 - 4 ) * 5 - 6 ) ) )";

        Stack<String>stack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()) {
            String item = scanner.next();
            stack.push(item);
        }
        scanner.close();
        Stack<String>copyStack=practice.Practice1312(stack);
        for (var item:copyStack){
            Assert.assertEquals(item,stack.pop());
        }
    }
    @Test
    public void Test1313(){
        int k=5;
        String s="1 2 3 4 5 6 7 8 9 0";
        Queue<String>queue=new ResizingArrayQueue<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()) {
            String item = scanner.next();
            queue.enqueue(item);
        }
        scanner.close();
        for (int i = 0; i < queue.size()-k; i++) {
            queue.dequeue();
        }
        Assert.assertEquals(queue.dequeue(),"6");
    }
    @Test
    //ReadDates
    public void TestPractice1316(){
        String date_str="5/22/1939\n6/30/2000\n4/3/2012";
        Date[]result_date=new Date[]{
                new Date(5,22,1939),
                new Date(6,30,2000),
                new Date(4,3,2012)
        };
        Assert.assertEquals(practice.Practice1316(date_str),result_date);
    }

    @Test
    //ReadTransactions
    public void TestPractice1317(){
        String tr_str="Turing 5/22/1939 11.99\nWho 6/30/2000 13.99\nTom 4/3/2012 34.09";
        Transaction[]result_tr=new Transaction[]{
                new Transaction("Turing", new Date(5,22,1939),11.99),
                new Transaction("Who", new Date(6,30,2000),13.99),
                new Transaction("Tom", new Date(4,3,2012),34.09)
        };

        Assert.assertEquals(practice.Practice1317(tr_str),result_tr);
    }

    @Test
    public void testLinkList1(){
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        linkedList.deleteAtIndex(1);
        Assert.assertEquals(linkedList.get(0),1);
        Assert.assertEquals(linkedList.get(1),3);
        //Assert.assertEquals(linkedList.get(2),72);
    }
    @Test
    public void testLinkList2(){
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.get(0);
        linkedList.addAtIndex(1,2);
        linkedList.get(0);
        linkedList.get(1);
        linkedList.addAtIndex(0,1);
        Assert.assertEquals(linkedList.get(0),1);
        Assert.assertEquals(linkedList.get(1),-1);
        Assert.assertEquals(linkedList.get(2),-1);
    }
    @Test
    public void testLinkList3(){
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.get(0);
        linkedList.addAtIndex(0,10);
    linkedList.addAtIndex(0,20);
    linkedList.addAtIndex(1,30);
        linkedList.get(0);
        linkedList.get(1);
        //linkedList.addAtIndex(0,1);
        Assert.assertEquals(linkedList.get(0),20);
        Assert.assertEquals(linkedList.get(1),10);
        Assert.assertEquals(linkedList.get(2),30);
    }
}
