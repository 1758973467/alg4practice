package Chapter5.ST;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

/**
 * 基于三向单词查找树的符号表
 * @param <Value>
 */
public class TriangleST<Value>implements IStringST<Value> {
    private int n;//size
    private Node root;
    private class Node{
        char c;
        Node left,mid,right;
        Value val;
    }

    @Override
    public void put(String key, Value val) {
        if(key==null){
            throw new IllegalArgumentException();
        }
        if(!contains(key))n++;
        else if(val==null)n--;
        root=put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c=key.charAt(d);

        if(x==null){
            x=new Node();
            x.c=c;
        }
        if(c<x.c){
            x.left=put(x.left,key,val,d);
        }else if(c>x.c){
            x.right=put(x.right,key,val,d);
        }else if(d<key.length()-1){
            x.mid=put(x.mid,key,val,d+1);
        }else {
            x.val=val;
        }
        return x;
    }
    @Override
    public Value get(String key) {
        Node x=get(root,key,0);
        if(x==null)return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if(x==null)return null;
        char c=key.charAt(d);
        if(c<x.c){
            return get(x.left,key,d);
        }else if(c>x.c){
            return get(x.right,key,d);
        }else if(d<key.length()-1){
            return get(x.mid,key,d+1);
        }else {
            return x;
        }
    }

    @Override
    public void delete(String key) {
        //Not Impl
        throw new RuntimeException();
    }

    @Override
    public String longestPrefixOf(String query) {
        if(query==null||query.length()==0)return null;
        int len=0;
        Node x=root;
        int i=0;
        while (x!=null&&i<query.length()){
            char c=query.charAt(i);
            if(c<x.c){
                x=x.left;
            }else if(c>x.c){
                x= x.right;
            }else {
                i++;
                if(x.val!=null)len=i;
                x=x.mid;
            }
        }
        return query.substring(0,len);
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String>queue=new LinkedListQueue<>();
        Node x=get(root,prefix,0);
        if(x==null){
            return queue;
        }
        if(x.val!=null){
            queue.enqueue(prefix);
        }
        collect(x.mid,new StringBuilder(prefix),queue);
        return queue;
    }

    @Override
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String>queue=new LinkedListQueue<>();
        collect(root,new StringBuilder(),0,pattern,queue);
        return queue;
    }

    private void collect(Node x, StringBuilder prefix,
                         int i, String pattern,
                         Queue<String> queue) {
        if(x==null)return;
        char c=pattern.charAt(i);
        if(c=='.'||c<x.c)collect(x.left,prefix,i,pattern,queue);
        if(c=='.'||c==x.c){
            if(i==pattern.length()-1
            &&x.val!=null){
                queue.enqueue(prefix.toString()+x.c);
            }
            if(i<pattern.length()-1){
                collect(x.mid,prefix.append(x.c),i+1,pattern,queue);
                prefix.deleteCharAt(prefix.length()-1);
            }
            if(c=='.'||c>x.c){
                collect(x.right,prefix,i,pattern,queue);
            }
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String>queue=new LinkedListQueue<>();
        collect(root,new StringBuilder(),queue);
        return queue;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> queue) {
        if(x==null)return;
        collect(x.left,prefix,queue);
        if(x.val!=null){
            queue.enqueue(prefix.toString()+x.c);
        }
        collect(x.mid,prefix.append(x.c),queue);
        prefix.deleteCharAt(prefix.length()-1);
        collect(x.right,prefix,queue);
    }
}
