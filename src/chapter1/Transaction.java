package chapter1;

public class Transaction implements Comparable<Transaction>{
    private String who;
    private Date date;
    private double amount;

    public Transaction(String who, Date date, double amount) {
        this.who = who;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String s) {
        String[] parts=s.split("\\s+");
        String timeParts[]=parts[1].split("/");
        this.date=new Date(Integer.parseInt(timeParts[0]),Integer.parseInt(timeParts[1]),Integer.parseInt(timeParts[2]));

        this.who=parts[0];
        this.amount=Double.parseDouble(parts[2]);
    }

    public String getWho() {
        return who;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + date.hashCode();
        hash = 31*hash +((Double)amount).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Transaction that = (Transaction) other;
        return this.compareTo(that)==0;
    }

    @Override
    public int compareTo(Transaction that) {
        int compareWho=who.compareTo(that.who);
        if(compareWho!=0) {
            return compareWho;
        }
        if(this.date.compareTo(that.date)!=0){
            return this.date.compareTo(that.date);
        }
        if(this.amount!=that.amount){
            return this.amount>that.amount?1:-1;
        }
        return 0;

    }
}
