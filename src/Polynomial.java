import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Polynomial {

    private final static int minDegree = -1;
    public static  String rawPoly = new String();
    private static int degree =0;
    public Map<Integer,Integer> mapPoly= new HashMap<>();

    public Polynomial(String rawPoly) {
        this.rawPoly = rawPoly.replace(" ","");
        convert2map(this.rawPoly);
    }
    public Polynomial(Map<Integer, Integer> poly, int degree)
    {
        this.mapPoly = poly;
        this.degree = degree;
    }

    public Polynomial(Map<Integer,Integer> poly){
        this.mapPoly.putAll(poly);
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
            else{
                this.mapPoly.put(0,Integer.parseInt(poly));
            }

        }

    }

    public String convert2string(Map<Integer,Integer> mapPoly){
        return new String();
    }


    public Map<Integer,Integer> addPoly(Polynomial p1){

        Map<Integer,Integer> result= new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : p1.mapPoly.entrySet()){
            if(this.mapPoly.get(entry.getKey()) != null)
            {
                int z= this.mapPoly.get(entry.getKey());
                int y= entry.getValue();
                result.put(entry.getKey(), z+y);
            }
            else
            {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        for(Map.Entry<Integer,Integer> entry : this.mapPoly.entrySet()){
            if(p1.mapPoly.get(entry.getKey())==null){
                result.put(entry.getKey(),entry.getValue());
            }
        }
        return result;
    }

    public Map<Integer,Integer> subPoly(Polynomial p1){
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

        return result;
    }

    private static int findDegree(Map<Integer, Integer> a)
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
            res = addPolyUtil(res, tmp); // todo: addPoly calls addPolyUtil with maps as args
        }
        return new Polynomial(res, findDegree(res));
    }

    private static boolean isDivisible(Polynomial p1, Polynomial p2)
    {
        int divisorDegree = p1.degree;
        int dividendDegree = p2.degree;


        return (dividendDegree >= divisorDegree && dividendDegree != -1 && divisorDegree != -1);
    }

    public Map<Integer,Integer> divPoly(Polynomial p1) {
        // Map<Integer, Integer> divisor = p1.mapPoly;
        int divisorDegree = p1.getDegree();
        int dividendDegree = this.getDegree();

        while (dividendDegree >= divisorDegree && dividendDegree != -1 && divisorDegree != -1)
        {

        }

        return new HashMap<>();
    }
}