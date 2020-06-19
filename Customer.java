import java.util.*;
import java.io.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer implements Comparable<Customer>{
    int hours;
    int minutes;
    int seconds;
    boolean overflow;
    public Customer(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.overflow = false;
    }
    
    public int compareTo(Customer c){
        if (this.hours > c.hours){
            return 1;
        }
        else if(this.hours < c.hours){
            return -1;
        }
        else{
            if(this.minutes > c.minutes){
                return 1;
            }
            else if(this.minutes < c.minutes){
                return -1;
            }
            else{
                if(this.seconds > c.seconds){
                    return 1;
                }
                else if(this.seconds < c.seconds){
                    return -1;
                }
            }
        }
        return 0;
    }
}
