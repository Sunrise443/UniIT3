package tasks;

public class TasksOne {
    public static void main(String[] args) {
        System.out.println(convert(3));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(0, 0, 2));
        System.out.println(triangleType(3, 3, 5));
        System.out.println(ternaryEvaluation(55, 55));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(factorial(3));
        System.out.println(gcd(52, 8));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(tables(8, 2));
        
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

    public static int howManyItems (double n, double w, double h) {
        return (n<w || n<h) ? 0 : (int)((n*2)/(w*h*2));
    }

    public static int factorial(int n) {
        int k = 1;
        for (int i=1; i<=n; i++) {
            k = k*i;
        }
        return k;
    }

    public static int gcd (int a, int b) {
        int g = 1;
        for (int i = 1; i<=a; i++) {
            if (a%i==0 & b%i==0) {
                g=i;
            }
        }
        return g;
    }

    public static int ticketSaler (int amount, int cost) {
        //28% от билета - комиссия
        return amount*cost*72/100;
    }

    public static int tables (int students, int desks) {
        double need = students/2 - desks;
        if (need<0) {
            return 0;
        } else {
            return (students%2 == 0) ? (int)need : (int)need + 1;
            }
        }
}
