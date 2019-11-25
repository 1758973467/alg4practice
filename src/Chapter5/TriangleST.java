package Chapter5;

/**
 * 基于三向单词查找树的符号表
 * @param <Value>
 */
public class TriangleST<Value>implements IStringST<Value> {
    private Node root;
    private class Node{
        char c;
        Node left,mid,right;
        Value val;
    }
    @Override
    public void put(String key, Value val) {

    }

    @Override
    public Value get(String key) {
        return null;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public String longestPrefixOf(String s) {
        return null;
    }

    @Override
    public Iterable<String> keysWithPrefix(String s) {
        return null;
    }

    @Override
    public Iterable<String> keysThatMatch(String s) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<String> keys() {
        return null;
    }
}
