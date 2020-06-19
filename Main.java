
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main{
    public static void main(int x){
        int cashiers = x;
        Shop one = new Shop(6,21,cashiers,"input.txt");
        one.runFileReader();
        System.out.println(one.toString());
        //to get data for graph
        CSVFile csv = new CSVFile();
        csv.createCSV();
    }
}
