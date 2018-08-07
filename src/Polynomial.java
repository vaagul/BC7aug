import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Polynomial {

    private final static int minDegree = -1;
    public static  String rawPoly = new String();
    public Map<Integer,Integer> mapPoly= new HashMap<>();

    public Polynomial(String rawPoly) {
        this.rawPoly = rawPoly;
    }
    public Polynomial(Map<Integer, Integer> poly, int degree)
    {
        this.mapPoly = poly;
        this.degree = degree;
    }

    public Map<Integer,Integer> convert2map(String rawPoly){
        return new HashMap<>();
    }

    public String convert2string(Map<Integer,Integer> mapPoly){
        return new String();
    }


    public Map<Integer,Integer> addPoly(Polynomial p1){
        return new HashMap<>();
    }

    public Map<Integer,Integer> subPoly(Polynomial p1){
        return new HashMap<>();
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