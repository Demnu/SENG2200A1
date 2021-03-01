public class Polygon {
    Point[] vertices;
    int pointsIndex = 0;
    Polygon(int numPoints){

        vertices = new Point[numPoints];

    }

    public void addPoint(double xInput, double yInput)
    {
        vertices[pointsIndex] = new Point(xInput,yInput);
        pointsIndex++;
    }

    public String toString()
    {
        double area;
        String s = "[";
        for (int i = 0 ; i<vertices.length - 1 ; i++)
        {
            s+=vertices[i].toString();
        }
        s +="]: " + String.format("%5.2f",calculateArea());
        
        return s;
    }

    public double calculateArea()
    {
        int i = 0;
        double sum = 0;
        for (i = 0 ;i < pointsIndex-1 ; i++){
            sum+= (vertices[i+1].getX()+vertices[i].getX())
                * (vertices[i+1].getY()-vertices[i].getY());
        }
        sum = 0.5 * Math.abs(sum);
        
        return sum;
    }

    public double distance(){
        double distance = 0;
        double closestDistance = 0;
        for (int i =1 ; i < vertices.length-2 ; i++)
        {
            distance = Math.sqrt(Math.pow(vertices[0].getX()-vertices[i].getX(), 2) - Math.pow(vertices[0].getY()-vertices[i].getY(),2));
            if (distance<closestDistance)
            {
                closestDistance=distance;
            }
        }
        return closestDistance;
    }
}
