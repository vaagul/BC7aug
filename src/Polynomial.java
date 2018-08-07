import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Polynomial {
    public static  String rawPoly = new String();
    private static int degree =0;
    public Map<Integer,Integer> mapPoly= new HashMap<>();

    public Polynomial(String rawPoly) {
        this.rawPoly = rawPoly.replace(" ","");
        convert2map(this.rawPoly);
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

    public Map<Integer,Integer> multPoly(Polynomial p1){
        return new HashMap<>();
    }

    public Map<Integer,Integer> divPoly(Polynomial p1){
        return new HashMap<>();
    }
}
