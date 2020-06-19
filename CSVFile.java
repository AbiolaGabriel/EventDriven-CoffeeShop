import java.util.*;
import java.io.*;
/**
 * Write a description of class ExperimentController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSVFile{
    public CSVFile(){
        this.createCSV();
    }
    
    public void createCSV(){
        double avgDailyProfit = 0;
        try{
            PrintWriter results = new PrintWriter("Project2.csv");
            for(int j = 0; j<10; j++){
                Shop one = new Shop(6,21,0,"input.txt");
                one.runFileReader();
                avgDailyProfit += one.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("0,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int j = 0; j<10; j++){
                Shop two = new Shop(6,21,1,"input.txt");
                two.runFileReader();
                avgDailyProfit += two.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("1,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int k = 0; k<10; k++){
                Shop three = new Shop(6,21,2,"input.txt");
                three.runFileReader();
                avgDailyProfit += three.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("2,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int l = 0; l<10; l++){
                Shop four = new Shop(6,21,3,"input.txt");
                four.runFileReader();
                avgDailyProfit += four.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("3,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int m = 0; m<10; m++){
                Shop five = new Shop(6,21,4,"input.txt");
                five.runFileReader();
                avgDailyProfit += five.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("4,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int n = 0; n<10; n++){
                Shop six = new Shop(6,21,5,"input.txt");
                six.runFileReader();
                avgDailyProfit += six.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("5,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int o = 0; o<10; o++){
                Shop seven = new Shop(6,21,6,"input.txt");
                seven.runFileReader();
                avgDailyProfit += seven.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("6,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int p = 0; p<10; p++){
                Shop eight = new Shop(6,21,7,"input.txt");
                eight.runFileReader();
                avgDailyProfit += eight.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("7,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int q = 0; q<10; q++){
                Shop nine = new Shop(6,21,8,"input.txt");
                nine.runFileReader();
                avgDailyProfit += nine.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("8,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int r = 0; r<10; r++){
                Shop ten = new Shop(6,21,9,"input.txt");
                ten.runFileReader();
                avgDailyProfit += ten.totalProfit;
                //System.out.println(one.toString());
            }
            results.println("9,"+(avgDailyProfit/10));
            avgDailyProfit = 0;
            for(int s = 0; s<10; s++){
                Shop eleven = new Shop(6,21,10,"input.txt");
                eleven.runFileReader();
                avgDailyProfit += eleven.totalProfit;
            }
            results.println("10,"+(avgDailyProfit/10));
            results.close();
        }
        catch(Exception e){
            System.err.println(e + " "+"Could not be printed");
        }
    }
}
