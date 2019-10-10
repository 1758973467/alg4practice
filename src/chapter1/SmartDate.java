package chapter1;

import com.sun.jdi.connect.Connector;

//alg4 1.2.11
public class SmartDate {
    private int day;
    private int month;
    private int year;

    public SmartDate(int year,int month,int day){
        if(year<0){
            throw new IllegalArgumentException(""+year);
        }
        if(month<1||month>12){
            throw new IllegalArgumentException(""+month);
        }
        if(day<1){
            throw new IllegalArgumentException(""+day);
        }
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(day>31){
                throw new IllegalArgumentException(""+day);
            }
        }else if(month==2){
            if(isLeapYear(year)){
                if(day>29){
                    throw new IllegalArgumentException(""+day);
                }
            }else{
                if(day>28){
                    throw new IllegalArgumentException(""+day);
                }
            }
        }
        this.month=month;
        this.year=year;
        this.day=day;
    }
    public static boolean isLeapYear(int year){
        if(year%400==0)return true;
        if(year%4==0&&year%100!=0)return true;
        return false;
    }

    public String dayOfWeek(){
        //获得天数

        int y=year;
        int m=month;
        if(month==1||month==2){
            m+=12;
            y--;
        }
        int w=(day+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
        if(w==0){
            return "Monday";
        }else if(w==1){
            return "Tuesday";
        }else if(w==2){
            return "Wednesday";
        }else if(w==3){
            return "Thursday";
        }else if(w==4){
            return "Friday";
        }else if(w==5){
            return "Saturday";
        }else{
            return "Sunday";
        }

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "SmartDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
