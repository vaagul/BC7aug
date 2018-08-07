public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String inputString= new String("2x^2 + 3x^3 + 10x - 4x^4 + 1");
        String inputString2= new String("3x^2 + 2x + 4x^4 -3 + 6x^5");
        Polynomial p1=new Polynomial(inputString);
        Polynomial p2=new Polynomial(inputString2);
        Polynomial result= p1.addPoly(p2);
    }
}
