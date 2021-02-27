public class Polygon {
    Point[] vertices;

    Polygon(int numPoints){

        vertices = new Point[numPoints];
        for (int i = 0 ; i<vertices.length ; i++)
        {
            vertices[i] = new Point();
        }
    }
}
