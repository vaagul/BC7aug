import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void PolynomialCode(){
        String inputString1 = new String("2x^2 + 4x^3");
        String inputString2 = new String("3x");

        Polynomial p1 = new Polynomial(inputString1);
        Polynomial p2 = new Polynomial(inputString2);

        //p1.printPoly();
        //p2.printPoly();
        //p1.subPoly(p2).printPoly();
        Pair<Polynomial, Polynomial> result = p1.divPoly(p2);
        System.out.print("Dividend: ");
        p1.printPoly();
        System.out.print("Divisor: ");
        p2.printPoly();
        System.out.print("Quotient: ");
        result.getKey().printPoly();
        System.out.print("Remainder: ");
        result.getValue().printPoly();
        //p1.addPoly(p2).printPoly();
        // Polynomial result = p1.divPoly(p2);
        // result.printPoly();
    }

    public static void TennisScore(){

        Scanner sc=new Scanner(System.in);

        String sequence=sc.nextLine();
        int len=sequence.length();
        Match m=new Match();

        for(int i=0;i<len;i++)
        {
            char c=sequence.charAt(i);
            m.updateScore(c+"");
        }

        m.printScoreCard();

    }

    public static void main(String[] args) {

        PolynomialCode();
        // TennisScore();
    }
}
