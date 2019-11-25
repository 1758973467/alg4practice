package Chapter5;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

/**
 * 基于单词查找树的符号表
 * @param <Value>
 */
public class TrieST<Value> implements IStringST<Value> {
    private static int R=256;
    private Node root;
    private class Node{
        private Node[] next;
        private Value val;
    }

    @Override
    public void put(String key, Value val) {
        if (val==null) delete(key);
        else root=put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if(x==null)x=new Node();
        if(d==key.length()){
            x.val=val;
            return x;
        }
        char c=key.charAt(d);
        x.next[c]=put(x.next[c],key,val,d+1);
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
        if(d==key.length())return x;
        char c=key.charAt(d);
        return get(x.next[c],key,d+1);
    }

    @Override
    public void delete(String key) {
        root=delete(root,key,0);
    }

    private Node delete(Node x, String key, int d) {
        if(x==null)return null;
        if(d==key.length()){
            x.val=null;
        }else {
            char c=key.charAt(d);
            x.next[c]=delete(x.next[c],key,d+1);
        }
        if(x.val!=null)return x;
        for(char c=0;c<R;c++){
            if(x.next[c]!=null)return x;
        }
        return null;
    }

    @Override
    public String longestPrefixOf(String s) {
        int len=search(root,s,0,0);
        return s.substring(0,len);
    }

    private int search(Node node, String s, int d, int len) {
        if(node==null)return len;
        if(node.val!=null)len=d;
        if(d==s.length())return len;
        char c=s.charAt(d);
        return search(node.next[c],s,d+1,len);
    }

    @Override
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String>q=new LinkedListQueue<>();
        collect(get(root,pre,0),pre,q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if(x==null)return;
        if(x.val!=null)q.enqueue(pre);
        for (char c=0;c<R;c++){
            collect(x.next[c],pre+c,q);
        }
    }

    @Override
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String>q=new LinkedListQueue<>();
        collect(root,"",pat,q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d=pre.length();
        if(x==null)return;
        if(d==pat.length()&&x.val!=null)q.enqueue(pre);
        if(d==pat.length())return;
        char next=pat.charAt(d);
        for(char c=0;c<R;c++){
            if(next=='.'||next==c){
                collect(x.next[c],pre+c,pat,q);
            }
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x==null)return 0;
        int cnt=0;
        if(x.val!=null)cnt++;
        for (char c = 0; c < R; c++) {
            cnt+=size(x.next[c]);
        }
        return cnt;
    }

    @Override
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }
}
