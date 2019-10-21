package Chapter3;

public class KeyValuePair<Key extends Comparable<Key>,Value> {
    private Key key;
    private Value value;

    public KeyValuePair() {
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
