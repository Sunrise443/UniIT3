package lab2;

public class Point3d extends Point2d {
    private double zCoord;

    public Point3d (double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }

    public double getZ() {
        return zCoord;
    }

    public void setZ (double val) {
        zCoord = val;
    }
}
