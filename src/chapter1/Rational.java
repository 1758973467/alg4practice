package chapter1;

import java.util.Objects;

public class Rational {
    private long numerator;
    private long denominator;

    public Rational(int numerator, int denominator) {
        long ec=Euclid(numerator,denominator);
        this.numerator = (int)(numerator/ec);
        this.denominator = (int)(denominator/ec);
    }

    public Rational plus(Rational other){
        long num=(this.numerator*other.denominator + other.numerator*this.denominator);
        long den=this.denominator *other.denominator;
        long ec=Euclid(num,den);
        assert Integer.MAX_VALUE>num/ec;
        assert Integer.MAX_VALUE>den/ec;
        var rational = new Rational((int)(num/ec), (int)(den/ec));
        return rational;
    }
    public Rational minus(Rational other){
        long num=(this.numerator*other.denominator - other.numerator*this.denominator);
        long den=this.denominator *other.denominator;
        long ec=Euclid(num,den);
        assert Integer.MAX_VALUE>num/ec;
        assert Integer.MAX_VALUE>den/ec;
        var rational = new Rational((int)(num/ec), (int)(den/ec));
        return rational;
    }
    public Rational times(Rational other){
        long num=this.numerator*other.numerator;
        long den=this.denominator *other.denominator;
        long ec=Euclid(num,den);
        assert Integer.MAX_VALUE>num/ec;
        assert Integer.MAX_VALUE>den/ec;
        var rational = new Rational((int)(num/ec), (int)(den/ec));
        return rational;
    }
    public Rational divides(Rational other){
        long num=this.numerator*other.denominator;
        long den=this.denominator *other.numerator;
        long ec=Euclid(num,den);
        assert Integer.MAX_VALUE>num/ec;
        assert Integer.MAX_VALUE>den/ec;
        var rational = new Rational((int)(num/ec), (int)(den/ec));
        return rational;
    }

    /**
     * 最大公约数
     * @param p
     * @param q
     */
    private static long Euclid(long p,long q){
        long max=Math.max(p,q);
        long min=Math.min(p,q);
        while (max%min!=0){
            long temp=max%min;
            max=min;
            min=temp;
            System.out.println("p:"+max+"q:"+min);
        }
        return min;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator &&
                denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
