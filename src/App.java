import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class App {

    public static void main(String[] args) {
        MyPolygons list = readFile(args[0]);
        System.out.println("Hello, World!");
        System.out.println("Unsorted List \n" + outputList(list));
        MyPolygons orderedList = createOrderedList(list);
        System.out.println("Unsorted List \n" + outputList(list));
        System.out.println("Sorted List \n" + outputList(orderedList));
        System.out.println("DONE");

    }


	//Pre conditions
	//None
	//Post conditions
	//Returns a circular linked list of type MyPolygons containing data from a given input file
    public static MyPolygons readFile(String filePath) {
        double[] numbers = new double[1000];
        int i = 0;
        int arraySize = 0;
        MyPolygons test = new MyPolygons();
        
        //open given input file
        try {

            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {

                //save all values of type double into an array 'numbers'
                try {
                    while (myReader.hasNext()) {

                        numbers[i] = myReader.nextDouble();
                        i++;
                        arraySize++;

                    }

                } catch (java.util.InputMismatchException e) {
                    System.out.println(myReader.next());
                    e.printStackTrace();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        i = 0;
        
        //Create each polygon object using the data inside the created array 'numbers' then add each polygon to the MyPolygons Circular LinkedList
        do {
            int amntPoints = 0;
            double xOrigin = 0;
            double yOrigin = 0;
            double xInput = 0;
            double yInput = 0;
            //Each do loop will have the index point to the element that has the value of the amount of points for the next polygon.
            amntPoints = (int) numbers[i];
            Polygon temp = new Polygon(amntPoints + 1);
            for (int j = 0; j < amntPoints; j++) {
                i++;
                xInput = numbers[i];
                i++;
                yInput = numbers[i];
                temp.addPoint(xInput, yInput);

                if (j == 0) {
                    xOrigin = xInput;
                    yOrigin = yInput;
                }

            }
            temp.addPoint(xOrigin, yOrigin);
            test.append(temp);
            i++;

        } while (i < arraySize);
        return test;
    }

	//Pre conditions
	//Recieves an object of type MyPolygons to have its stored polygons sorted by descending order
	//Post conditions
	//Returns an object of type MyPolygons that has its stored polygons sorted by descending order
    public static MyPolygons createOrderedList(MyPolygons list) {
        MyPolygons orderedList = new MyPolygons();
        Polygon temp;
        list.reset();
        int sizeOfList = list.getSize();
        for (int i = 0; i < sizeOfList; i++) {
            temp = list.take();
            orderedList.orderedInsert(temp);
            list.append(temp);
        }
        return orderedList;
    }


	//Pre conditions
	//Recieves an object of type MyPolygons
	//Post conditions
	//Returns a String containing information of each polygon inside MyPolygons
    public static String outputList(MyPolygons list) {
        String str = "";
        Polygon temp;
        for (int i = 0; i < list.getSize(); i++) {
            temp = list.take();
            str += temp.toString();
            list.append(temp);

        }
        return str;
    }

}