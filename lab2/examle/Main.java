package lab2.examle;

public class Main {
    public static void main(String[] args) {
        Point2d newPoing = new Point2d(1,2);
        Point3d point3D = new Point3d(2, 2, 8);
        point3D.setX(34);
        newPoing.setY(11);
        System.out.println(point3D.getX());
    }
}
