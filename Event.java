import java.util.*;
import java.io.*;
/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event{
    int timeStamp;
    ArrayList<Customer> a;
    PriorityQueue<Customer> queue;
    double eventProfit;
    int waitingTime;
    int maxTime = 0;
    double overflow = 0;
    Cashier [] arr;
    public Event(int time){
        this.timeStamp = time;
        this.a = new ArrayList<Customer>();
    }

    public void add(Customer c){
        this.a.add(c);
        //this.q.add(c);
    }

    public double run(int cashiers, int waitL, int waitU, double proL, double proU){
        int start = 0;
        this.queue = new PriorityQueue<Customer>();
        this.arr = new Cashier[cashiers];
        for(int i = 0; i<arr.length;i++){
            arr[i] = new Cashier(cashiers);
        }
        for(int i = 0; i<this.a.size(); i++){
            int x = 0;
            boolean notInsert = true;
            int innercount = 0;
            int lineCap = 8 * cashiers;
            while(notInsert){

                if(x < arr.length){
                    if(arr[x].isEmpty() == true && arr[x].queue.size() < lineCap){
                        this.arr[x].add(a.get(i));
                        this.queue.add(a.get(i));
                        notInsert = false;
                    }
                    else if(arr[x].isEmpty() == false && arr[x].queue.size() < lineCap){
                        this.arr[x].add(a.get(i));
                        this.queue.add(a.get(i));
                        notInsert = false;
                    }

                    if(arr[x].isEmpty() == false && arr[x].queue.size() == lineCap){
                        x++;
                        innercount++;
                    }

                    if(innercount == arr.length){
                        notInsert = false;
                        a.get(i).overflow = true;
                        this.overflow++;
                    }
                }

            }
        }
        for(int k = 0; k<queue.size(); k++){
            double profit = (double)(Math.random()*((proU - proL)+1))+proL;
            int waitTime = (int)(Math.random()*((waitU+1) - waitL))+waitL;
            if(this.maxTime < waitTime){
                this.maxTime = waitTime;
            }
            this.eventProfit += profit;
            this.waitingTime += waitTime;
        }
        this.overflow = this.overflow/(double)queue.size();
        this.waitingTime = this.waitingTime/queue.size();
        return this.eventProfit;
    }

}
