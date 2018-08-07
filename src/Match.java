import java.util.HashMap;
import java.util.Map;

public class Match {

    private final String [ ] score= {"love","15","30","40","deuce","advantage"};

    public Map<String,Integer> playerName= new HashMap<>();
    private int set_score[ ]={0,0};
    private int game_score[ ]={0,0};
    private int points[ ]={0,0};

    Match(){
        this.playerName.put("A",0);
        this.playerName.put("B",1);
    }

    private boolean checkPoints(int playerId){
        return true;
    }

    private boolean checkGame(int playerId){
        return (game_score[playerId] >= 6 && game_score[playerId] - game_score[(playerId + 1) % 2] >= 2);
    }

    public void updateScore(String point){

        int playerId=playerName.get(point);
        points[playerId]++;

        if(checkPoints(playerId)){
            game_score[playerId]++;
            //reset point
            points[0] = points[1] = 0;

            if(checkGame(playerId)){
                set_score[playerId]++;
                //reset game
                game_score[0] = game_score[1] = 0;
            }
        }

    }

    public void printScoreCard(){

        System.out.print("Player:\t");
        for(Map.Entry<String, Integer> entry : playerName.entrySet())
        {
            System.out.print(entry.getKey()+"\t");
        }

        System.out.println("Sets:\t"+set_score[0]+"\t"+set_score[1]);
        System.out.println("Games:\t"+game_score[0]+"\t"+game_score[1]);
        System.out.println("Point:\t"+points[0]+"\t"+points[1]);

    }
}


