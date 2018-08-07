import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String inputString= new String("2x^2 + 3x^3 +10x - 4x^4 + 1");
        String inputString2= new String("3x^2 + 2x + 4x^4 -3 + 6x^5");
        Polynomial p1=new Polynomial(inputString);
        Polynomial p2=new Polynomial(inputString2);

        System.out.println("Polynomial 1:"+ inputString);
        System.out.println("Polynomial 1:"+ inputString2);

        System.out.println();

        Polynomial result1= p1.addPoly(p2);
        System.out.print("Addition: ");
        result1.printPoly();

        Polynomial result2= p1.subPoly(p2);
        System.out.print("Subtraction: ");
        result2.printPoly();

        Polynomial result3= p1.multPoly(p2);
        System.out.print("Multiplication: ");
        result3.printPoly();
    }
}
