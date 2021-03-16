public class Point {
    private double x;
    private double y;
    //Constructor
    Point(double xInput, double yInput) {
        x = xInput;
        y = yInput;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns a string containing the co-ordinates of the point
    public String toString() {

        String str;
        String strX = String.format("%3.2f", x);
        String strY = String.format("%3.2f", y);

        str = "(" + strX + " , " + strY + ")";
        return str;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns the double x
    public double getX() {
        return x;
    }
    //Preconditions
    //None
    //Postconditions
    //Returns the double y
    public double getY() {
        return y;
    }

}