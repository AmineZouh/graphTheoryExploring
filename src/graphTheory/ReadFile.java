package graphTheory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void readFile(String path){
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                String[] parameters = line.split(" ");
                if(parameters.length>2){
                    System.out.print("the number of cities is : "+Integer.parseInt(parameters[0])+"     ");
                    System.out.print("the number of roads is : "+Integer.parseInt(parameters[1])+"     ");
                    System.out.print("the cost od building a lib is : "+Integer.parseInt(parameters[2])+"     ");
                    System.out.print("the cost of building a roads is : "+Integer.parseInt(parameters[3]));
                    System.out.println();
                }
           }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }catch (Exception e){
            System.out.println("there was an error while trying reading the file");
        }
    }

    public static void main(String args[]){
        String path1 = "D:\\Projets\\java\\MinimumLibraryCostTestCases1.txt";
        String path2 = "D:\\Projets\\java\\MinimumLibraryCostTestCases2.txt";
        System.out.println("************************Sample teste 1*************************************");
        readFile(path1);
        System.out.println("************************Sample teste 1 end*************************************");
        System.out.println("************************Sample teste 2*************************************");
        readFile(path2);
        System.out.println("************************Sample teste 2 end*************************************");

    }
}
