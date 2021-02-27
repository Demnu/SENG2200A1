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
}
