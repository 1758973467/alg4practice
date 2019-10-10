package chapter1.BagQueueStack;

import chapter1.Date;
import chapter1.Transaction;

import java.io.StringReader;
import java.util.Scanner;

public class Practice13 {
    public boolean Practice134(String s){
        FixedCapacityStackOfString stack=new FixedCapacityStackOfString(10);
        Scanner scanner=new Scanner(new StringReader(s));
        String [][]parent={
                {"(","[","{"},
                {")","]","}"}
        };
        while (scanner.hasNext()){
            String item=scanner.next();
            for (int i = 0; i < parent[0].length; i++) {
                if(item.equals(parent[0][i])){
                    stack.push(item);
                    break;
                }
            }
            for (int i = 0; i < parent[0].length; i++) {
                if(item.equals(parent[1][i])){
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(!stack.pop().equals(parent[0][i])){
                        return false;
                    }
                }
            }
        }
        scanner.close();
        return stack.isEmpty();
    }

    public double Dijkstra(String s){
        Stack<Double>valStack=new ResizingArrayStack<>();
        Stack<String>opStack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(item.equals("(")){
                //skip
            }else if(item.equals("+")){
                opStack.push(item);
            }else if(item.equals("+")){
                opStack.push(item);
            }else if(item.equals("-")){
                opStack.push(item);
            }else if(item.equals("*")){
                opStack.push(item);
            }else if(item.equals("/")){
                opStack.push(item);
            }else if(item.equals("sqrt")){
                opStack.push(item);
            }else if(item.equals(")")){
                double val=valStack.pop();
                String op=opStack.pop();
                if(op.equals("+")){
                    val=valStack.pop()+val;
                }else if(op.equals("-")){
                    val=valStack.pop()-val;
                }else if(op.equals("*")){
                    val=valStack.pop()*val;
                }else if(op.equals("/")){
                    val=valStack.pop()/val;
                }else if(op.equals("sqrt")){
                    val=Math.sqrt(val);
                }

                valStack.push(val);
            }else{
                valStack.push(Double.parseDouble(item));
            }
        }
        scanner.close();
        assert valStack.size()==1;
        return valStack.pop();
    }

    public String Practice139(String s){
        //将无左括号的算术表达式弥补成宥左括号的
        Stack<String>opStack=new ResizingArrayStack<>();
        //
        Stack<String>commaStack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(item.equals("(")){
                //skip
            }else if(item.equals("+")){
                opStack.push(item);
            }else if(item.equals("-")){
                opStack.push(item);
            }else if(item.equals("*")){
                opStack.push(item);
            }else if(item.equals("/")){
                opStack.push(item);
            }else if(item.equals("sqrt")){
                opStack.push(item);
            }else if(item.equals(")")){
                String op=opStack.pop();
                String opRight=commaStack.pop();
                String opLeft=commaStack.pop();
                commaStack.push("("+opLeft+op+opRight+")");
            }else {
                commaStack.push(item);
            }
        }
        scanner.close();
        assert commaStack.size()==1;
        return commaStack.pop();
    }
    //中序表达式转后序表达式
    public String Practice1310(String s){
        //将无左括号的算术表达式弥补成宥左括号的
        Stack<String>opStack=new ResizingArrayStack<>();
        //
        Stack<String>postfixStack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(s));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(item.equals("(")){
                //skip
            }else if(item.equals("+")){
                opStack.push(item);
            }else if(item.equals("-")){
                opStack.push(item);
            }else if(item.equals("*")){
                opStack.push(item);
            }else if(item.equals("/")){
                opStack.push(item);
            }else if(item.equals("sqrt")){
                opStack.push(item);
            }else if(item.equals(")")){
                String op=opStack.pop();
                String opRight=postfixStack.pop();
                String opLeft=postfixStack.pop();
                postfixStack.push(opLeft+" "+opRight+" "+op+" ");
            }else {
                postfixStack.push(item);
            }
        }
        scanner.close();
        assert postfixStack.size()==1;
        return postfixStack.pop();
    }

    public double Practice1311(String postfixString){
        Stack<Double>valStack=new ResizingArrayStack<>();
        Scanner scanner=new Scanner(new StringReader(postfixString));
        while (scanner.hasNext()){
            String item=scanner.next();
            if(item.equals("+")){
                double opRight=valStack.pop();
                double opLeft=valStack.pop();
                valStack.push(opLeft+opRight);
            }else if(item.equals("-")){
                double opRight=valStack.pop();
                double opLeft=valStack.pop();
                valStack.push(opLeft-opRight);
            }else if(item.equals("*")){
                double opRight=valStack.pop();
                double opLeft=valStack.pop();
                valStack.push(opLeft*opRight);
            }else if(item.equals("/")){
                double opRight=valStack.pop();
                double opLeft=valStack.pop();
                valStack.push(opLeft/opRight);
            }else if(item.equals("sqrt")){
                double opRight=valStack.pop();
                valStack.push(Math.sqrt(opRight));
            } else {
                valStack.push(Double.parseDouble(item));
            }
        }
        scanner.close();
        assert valStack.size()==1;
        return valStack.pop();
    }

    //copy
    public Stack<String> Practice1312(Stack<String> stack){
        Stack<String>copyStack=new ResizingArrayStack<>();
        Stack<String>tempStack=new ResizingArrayStack<>();
        for(String item:stack){
            tempStack.push(item);
        }
        for (String item:tempStack){
            copyStack.push(item);
        }
        return copyStack;
    }

    public Date[] Practice1316(String date_str){
        Queue<Date>q=new ResizingArrayQueue<>();
        Scanner scanner=new Scanner(new StringReader(date_str));
        while (scanner.hasNext()){
            String line=scanner.nextLine();
            q.enqueue(new Date(line));
        }
        int N=q.size();
        Date[]a=new Date[N];
        for (int i = 0; i < N; i++) {
            a[i]=q.dequeue();
        }
        return a;
    }
    public Transaction[] Practice1317(String transaction_str){
        Queue<Transaction>q=new ResizingArrayQueue<>();
        Scanner scanner=new Scanner(new StringReader(transaction_str));
        while (scanner.hasNext()){
            q.enqueue(new Transaction(scanner.nextLine()));
        }
        int N=q.size();
        Transaction[]a=new Transaction[N];
        for (int i = 0; i < N; i++) {
            a[i]=q.dequeue();
        }
        return a;
    }
    //链表练习

}
