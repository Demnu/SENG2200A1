public class Point{
    private double x;
    private double y;

    Point(double xInput, double yInput){
        x = xInput;
        y = yInput;
    }
    public double distance(){
        return 0;
    }

    public String toString(){

        String str;  
        String strX = String.format("%3.2f", x);
        String strY = String.format("%3.2f", y); 

        str = "(" + strX + " , " + strY + ")";
        return str;
    }
    
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

}