public class Polygon implements ComparePoly {
    private Point[] vertices;
    private int pointsIndex = 0;
    private double area;

    //Constructor
    Polygon(int numPoints) {

        vertices = new Point[numPoints];

    }

    //Preconditions
    //Recieves two double values representing co-ordinates of a point
    //Postconditions
    //Stores a new point into array 'vertices'
    public void addPoint(double xInput, double yInput) {
        vertices[pointsIndex] = new Point(xInput, yInput);
        pointsIndex++;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns a string containing information about the polygon including it's points and area
    public String toString() {
        double area;
        String s = "[";
        for (int i = 0; i < vertices.length - 1; i++) {
            s += vertices[i].toString();
        }
        s += "]: " + String.format("%5.2f", calculateArea()) + "\n";

        return s;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns a double containing the area of the polygon
    public double calculateArea() {
        int i = 0;
        double sum = 0;
        for (i = 0; i < pointsIndex - 1; i++) {
            sum += (vertices[i + 1].getX() + vertices[i].getX()) * (vertices[i + 1].getY() - vertices[i].getY());
        }
        sum = 0.5 * Math.abs(sum);
        area = sum;
        return sum;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns a double containing the distance of the closest point to the origin
    public double distance() {
        double distance = 0;
        double closestDistance = Math.sqrt(Math.pow(vertices[0].getX() - vertices[1].getX(), 2)
                + Math.pow(vertices[0].getY() - vertices[1].getY(), 2));
        for (int i = 2; i < vertices.length - 1; i++) {
            distance = Math.sqrt(Math.pow(vertices[0].getX() - vertices[i].getX(), 2)
                    + Math.pow(vertices[0].getY() - vertices[i].getY(), 2));
            if (distance < closestDistance) {
                closestDistance = distance;
            }
        }
        return closestDistance;
    }

    //Preconditions
    //Two doubles containing polygon areas
    //Postconditions
    //Returns a boolean depending on if the two given areas are the same (depending on assignment specs)
    public boolean isSameArea(double smallestArea, double areaDifference) {

        if (areaDifference <= smallestArea * 0.05) {
            return true;
        }

        return false;

    }

    //Preconditions
    //Recieves object of type Polygon
    //Postconditions
    //Returns a boolean depending on if the recieved Polygon is smaller than or larger than the Polygon that is calling this function
    @Override
    public boolean ComesBefore(Object o) {
        Polygon p2 = (Polygon) o;
        double p2Area = p2.calculateArea();
        double p1Area = calculateArea();
        double areaDifference = Math.abs(p2Area - p1Area);

        if (p2Area > p1Area && !isSameArea(p1Area, areaDifference)) {

            return false;

        } else if (p2Area < p1Area && !isSameArea(p2Area, areaDifference)) {

            return true;

        }

        if (p2.distance() > distance()) {
            return true;
        } else {
            return false;
        }

    }
}
