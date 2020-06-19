import java.util.*;
import java.io.*;
/**
 * Write a description of class Cashier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cashier{
    PriorityQueue<Customer> queue;
    int numofCashiers;
    
    public Cashier(int num){
        queue = new PriorityQueue<Customer>();
        this.numofCashiers = num;
    }
    
    public boolean isEmpty(){
        return this.queue.size() == 0;
    }
    
    public boolean isOpen(){
        if(this.queue.size() < (8*numofCashiers)){
            return false;
        }
        else {
            return true;
        }
    }
    
    public void add(Customer c){
        if(this.isOpen() == true){
            this.queue.add(c);
        }
    }
}
