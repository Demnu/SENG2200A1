import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class App {
    
    public static void main(String[] args){
        System.out.println("Hello, World!");
        int amountPolygons = 0;
        double[] numbers = new double[1000];
        int i = 0;
        int arraySize=0;
        MyPolygons<Polygon> test = new MyPolygons<Polygon>();
        try{
        
            File myObj = new File("sample_in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext())
            {
                try{
                    while(myReader.hasNext())
                    {
            
                        numbers[i] = myReader.nextDouble();
                        i++;
                        arraySize++;
        
         
                    }
                    
                }catch(java.util.InputMismatchException e){
                    System.out.println(myReader.next());
                    e.printStackTrace();
    
                }
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();

        }
        boolean polygon = true;
        i = 0;
        do{
            int amntPoints = 0;
            double xOrigin = 0 ;
            double yOrigin = 0;
            double xInput = 0;
            double yInput = 0;
            amntPoints = (int)numbers[i];
            Polygon temp = new Polygon(amntPoints+1);

            for (int j=0 ; j< amntPoints ; j++)
            {
                i++;
                xInput = numbers[i];
                i++;
                yInput = numbers[i];
                temp.addPoint(xInput, yInput);

                if (j==0)
                {
                    xOrigin = xInput;
                    yOrigin = yInput;
                }

                
            }
            temp.addPoint(xOrigin, yOrigin);
            test.addNext(temp);
            i++;
            System.out.println(temp.toString());



        }while(i<arraySize);


        



        // try{
        
        //     File myObj = new File("sample_in.txt");
        //     Scanner myReader = new Scanner(myObj);
        //     while(myReader.hasNextLine())
        //     {
        //         String data = myReader.nextLine();
        //         char [] line = new char[30];
        //         int length = 0;
        //         for (int i = 0 ; i<data.length(); i++)
        //         {
        //             if (data.charAt(i) == 'P')
        //             {
        //                 amountPolygons++;
        //             }
        //         }
        //     }
        //     myReader.close();
        // }catch(FileNotFoundException e){
        //     System.out.println("An error occured.");
        //     e.printStackTrace();

        // }

        
        // Integer[] temp = new Integer[1000];
        // int i = 0;
        // try{
        //     File myObj = new File("sample_in.txt");
        //     Scanner myReader = new Scanner(myObj);
        //     while(myReader.hasNext())
        //     {
        //         try {
        //             temp[i] = myReader.nextInt();
        //             i++;
        //           } catch (InputMismatchException e) {
        //             myReader.next();
        //           }
        //     }
        //     myReader.close();
        // }catch(FileNotFoundException e){
        //     System.out.println("An error occured.");
        //     e.printStackTrace();

        // }
        System.out.println("DONE");

    }



}