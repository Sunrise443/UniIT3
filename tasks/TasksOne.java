package tasks;

public class TasksOne {
    public static void main(String[] args) {
        System.out.println(convert(3));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(0, 0, 2));
        System.out.println(triangleType(3, 3, 5));
        System.out.println(ternaryEvaluation(55, 55));
    }

    public static double convert(int gallones) {
        return (gallones*3.785);
    }

    public static int fitCalc(int minutes, int intensity) {
        return (minutes*intensity);
    }

    public static int containers(int boxes, int bags, int barrel) {
        return (20*boxes + 50*bags + 100*barrel);
    }

    public static String triangleType (int x, int y, int z) {
        if ((x+z>y) & (x+y>z) & (y+z>x)) {
            if ((x!=y) & (y!=z) & (z!=x)) {
                return ("different-sided");
            } else {
                if ((x==y) & (y==z)) {
                    return ("isosceles");
                } else {
                    return ("equilateral");
                }
            }
        } else {
            return ("not a triangle");
        }
    }

    public static int ternaryEvaluation (int a, int b) {
        return a>b ? a : b;
    }
}
