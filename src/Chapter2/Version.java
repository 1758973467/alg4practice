package Chapter2;

public class Version implements Comparable<Version>{
    private int[]data;
    public Version(String version){
        String[] strs=version.split("\\.");
        data=new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            data[i]=Integer.parseInt(strs[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
            stringBuilder.append(".");
        }
        if(data.length>0){
            stringBuilder.delete(stringBuilder.length()-1,1);
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Version that) {
        if(this==that)return 0;
        if(this.data.length!=that.data.length)return this.data.length-that.data.length;
        for (int i = 0; i < data.length; i++) {
            if(data[i]!=that.data[i]){
                return data[i]-that.data[i];
            }
        }
        return 0;
    }
}
