import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    public static  String rawPoly = new String();
    public Map<Integer,Integer> mapPoly= new HashMap<>();

    public Polynomial(String rawPoly) {
        this.rawPoly = rawPoly;
    }

    public Map<Integer,Integer> convert2map(String rawPoly){
        return new HashMap<>();
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
