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

    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //PolynomialCode();
        TennisScore();
    }
}
