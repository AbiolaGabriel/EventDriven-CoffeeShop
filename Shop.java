import java.util.*;
import java.io.*;
/**
 * Write a description of class Shop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop{
    ArrayList<Event> list;
    ArrayList<Customer> c;
    //PriorityQueue<Event> queue;
    int open;
    int event;
    int close;
    int cashiers;
    double profitLower;
    double profitUpper;
    double paycheck;
    int waitLower;
    int waitUpper;
    double totalProfit;
    double avgWaitTime = 0;
    double avgMaxWait = 0;
    double overflow = 0;
    String file;
    public Shop(int open, int close, int cashiers, String filename){
        this.list = new ArrayList<Event>();
        this.c = new ArrayList<Customer>();
        //this.queue = new PriorityQueue<Event>();
        this.open = open;
        this.close = close;
        this.cashiers = cashiers;
        this.file = filename;
    }

    public void runFileReader(){
        Scanner s1 = null;
        Scanner s2 = null;
        Customer cust = null;
        String line = "";
        try{
            s1 = new Scanner(new FileReader(this.file));
            int count = 1;
            while(s1.hasNextLine()){
                int hours = 0;
                int minutes = 0;
                int seconds = 0;
                if(count == 1){
                    line = s1.nextLine();
                    s2 = new Scanner(line);
                    while(s2.hasNextDouble()){
                        this.profitLower = s2.nextDouble();
                        this.profitUpper = s2.nextDouble();
                    }
                }

                else if(count == 2){
                    line = s1.nextLine();
                    s2 = new Scanner(line);
                    while(s2.hasNextDouble()){
                        this.paycheck = s2.nextDouble();;
                    }
                }
                else if(count == 3){
                    line = s1.nextLine();
                    s2 = new Scanner(line);
                    while(s2.hasNextInt()){
                        this.waitLower = s2.nextInt();
                        this.waitUpper = s2.nextInt();
                    }
                }
                else{
                    line = s1.nextLine();
                    line = line.replaceAll(":", " ");
                    s2 = new Scanner(line);
                    hours = s2.nextInt();
                    minutes = s2.nextInt();
                    seconds = s2.nextInt();
                    cust = new Customer(hours,minutes,seconds);
                    this.c.add(cust);
                }
                count++;
            }
        }
        catch(Exception e){
            System.err.println(e);
            System.out.println("Error");
        }
        this.createEvents();
    }

    public void createEvents(){
        int current = this.open;
        int end = this.close;
        Event e = null;
        while(current < end){
            e = new Event(current);
            for(Customer c: this.c){
                if(c.hours == current){
                    e.add(c);
                }
            }
            this.list.add(e);
            current++;
        }
        this.runEvents();
    }

    public void runEvents(){
        int i = 0;
        double profit = 0;
        while(i<this.list.size()){
            if(this.cashiers == 0){
                profit = 0;
                avgWaitTime = 0;
                avgMaxWait = 0; 
                overflow = 0;
                i++;
            }
            else{
                profit += this.list.get(i).run(this.cashiers, this.waitLower, this.waitUpper, this.profitLower, this.profitUpper);
                avgWaitTime += this.list.get(i).waitingTime;
                avgMaxWait += this.list.get(i).maxTime; 
                overflow += this.list.get(i).overflow;
                i++;
            }
        }
        this.totalProfit = profit - (this.cashiers * this.paycheck);
        this.avgWaitTime = this.avgWaitTime/this.list.size();
        this.avgMaxWait = this.avgMaxWait/this.list.size();
        this.overflow = this.overflow/this.list.size();
    }

    public String toString(){
        String x = "";
        x = "In this shop with "+this.cashiers+" total cashiers, the total profit is $"+this.totalProfit+", the average waiting time for customers is "+this.avgWaitTime+" seconds, the average maximum waiting time is "+this.avgMaxWait+" seconds, and the average overall overflow rate is "+this.overflow+" overflow per cashier";
        return x;
    }

}
