import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Polynomial {

    private final static int minDegree = -1;
    public static  String rawPoly = new String();
    private int degree = minDegree;
    public Map<Integer,Integer> mapPoly= new HashMap<>();

    public Polynomial(String rawPoly) {
        this.rawPoly = rawPoly.replace(" ","");
        convert2map(this.rawPoly);
    }

    public Polynomial(Map<Integer, Integer> poly, int degree)
    {
        this.mapPoly.putAll(poly);
        this.degree = degree;
        this.rawPoly=convert2string(mapPoly);
    }

    public Polynomial(Map<Integer,Integer> poly){
        this.mapPoly.putAll(poly);
        this.rawPoly=convert2string(mapPoly);
    }

    public void printPoly(){

        if(rawPoly.charAt(0)=='+')
        {
            System.out.println(rawPoly.substring(1));
        }
        else
            System.out.println(rawPoly);
    }

    private void convert2map(String rawPoly){
        String modPoly=rawPoly.replace("-", "+-");
        String [ ] arrayPoly = modPoly.split(Pattern.quote("+"));
        for(String poly : arrayPoly){
            if(poly.contains("x^")){
                String [ ] subPoly=poly.split(Pattern.quote("x^"));
                if(Integer.parseInt(subPoly[1])>degree)
                    degree=Integer.parseInt(subPoly[1]);
                this.mapPoly.put(Integer.parseInt(subPoly[1]),Integer.parseInt(subPoly[0]));
            }
            else if(poly.contains("x")){
                String [ ] subPoly=poly.split(Pattern.quote("x"));
                if(degree<1)
                    degree=1;
                if(subPoly[0] == null)
                    this.mapPoly.put(1,1);
                else
                    this.mapPoly.put(1,Integer.parseInt(subPoly[0]));
            }
            else if(!poly.equalsIgnoreCase("")){
                if(degree<0)
                    degree=0;
                this.mapPoly.put(0,Integer.parseInt(poly));
            }
        }

    }

    public String convert2string(Map<Integer,Integer> mapPoly){

        String str=new String();

        for(Map.Entry<Integer,Integer> entry : mapPoly.entrySet()){

            int val=entry.getValue();
            int degree= entry.getKey();
            if(val!=0)
            {
                if(entry.getKey()==0)
                    str=str+ "+"+entry.getValue()+" ";
                else if(entry.getValue()==1 || entry.getKey()==1)
                    str=str+ "+" +entry.getValue() +"x ";
                else
                    str= str + "+" +entry.getValue() + "x^"+entry.getKey()+" ";
            }
        }
        str= str.replace("+-","-");
        return str;
    }

    // todo: remove zero coefficent terms
    private  Map<Integer,Integer> addPolyUtil(Map<Integer,Integer> p1,Map<Integer,Integer> p2){
        Map<Integer,Integer> result= new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : p1.entrySet()){
            if(p2.get(entry.getKey()) != null)
            {
                int z= p2.get(entry.getKey());
                int y= entry.getValue();
                result.put(entry.getKey(), z+y);
            }
            else
            {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Integer, Integer> entry : p2.entrySet()){
            if(p1.get(entry.getKey())==null){
                result.put(entry.getKey(),entry.getValue());
            }
        }
        return result;
    }

    public Polynomial addPoly(Polynomial p1){

        Map<Integer, Integer> tmp = addPolyUtil(this.mapPoly,p1.mapPoly);
        return new Polynomial(tmp,findMaxDegree(tmp));
    }

    public Polynomial subPoly(Polynomial p1){
        Map<Integer,Integer> result= new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : p1.mapPoly.entrySet()){
            if(this.mapPoly.get(entry.getKey()) != null)
            {
                int x= this.mapPoly.get(entry.getKey());
                int y= entry.getValue();
                result.put(entry.getKey(), x-y);
            }
            else{
                result.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Integer,Integer> entry : this.mapPoly.entrySet()){
            if(p1.mapPoly.get(entry.getKey())==null){
                result.put(entry.getKey(), entry.getValue() * (-1));
            }
        }

        return new Polynomial(result,findMaxDegree(result));
    }

    private static int findMaxDegree(Map<Integer, Integer> a)
    {
        int max = minDegree;
        for(Map.Entry<Integer, Integer> entry : a.entrySet())
        {
            if(max < entry.getKey())
                max = (Integer) entry.getKey();
        }
        return max;
    }

    private int getCoefficent(int degree)
    {
        return mapPoly.get(degree);
    }

    private Map<Integer ,Integer> multiplyUtil(Map<Integer, Integer> a, int mag, int deg)
    {
        Map<Integer, Integer> res = new HashMap<>();
        int key, value;
        Iterator mapItr = a.entrySet().iterator();

        while(mapItr.hasNext()) // todo: use for-each
        {
            Map.Entry pair = (Map.Entry)mapItr.next();
            key = (Integer) pair.getKey();
            value = (Integer) pair.getValue();
            key += deg;
            value *= mag;
            res.put(key, value);
        }
        return res;
    }

    public Polynomial multPoly(Polynomial p1)
    {

        Iterator mapItr = this.mapPoly.entrySet().iterator();
        Map<Integer, Integer> b = p1.mapPoly;

        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, Integer> tmp;

        while(mapItr.hasNext()) // todo: use for-each
        {
            Map.Entry pair = (Map.Entry)mapItr.next();
            tmp = multiplyUtil(b, (Integer) pair.getValue(), (Integer) pair.getKey());
            res = addPolyUtil(res, tmp);
        }
        return new Polynomial(res, findMaxDegree(res));
    }

    private static boolean isDivisible(Polynomial p1, Polynomial p2)
    {
        int divisorDegree = p1.degree;
        int dividendDegree = p2.degree;
        return (dividendDegree >= divisorDegree && dividendDegree != -1 && divisorDegree != -1);
    }

    public Map<Integer,Integer> divPoly(Polynomial p1) {
        // Map<Integer, Integer> divisor = p1.mapPoly;
        int divisorDegree = p1.degree;
        int dividendDegree = this.degree;
        while (dividendDegree >= divisorDegree && dividendDegree != -1 && divisorDegree != -1)
        {

        }
        return new HashMap<>();
    }
}