import java.util.*;

public class Main {

    public static void PolynomialCode(){
        String inputString= new String("2x^2 + 4x^3");
        String inputString2= new String("2x");
        Polynomial p1=new Polynomial(inputString);
        Polynomial p2=new Polynomial(inputString2);
        Polynomial result= p1.addPoly(p2);
        p1.divPoly(p2);
        //result.printPoly();
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
        //System.out.println("Hello World!");
        //PolynomialCode();
        TennisScore();
    }
}
