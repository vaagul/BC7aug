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

    private boolean checkPoints(int currentPlayer){
        int opponentPlayer=(currentPlayer+1)%2;
        if(points[currentPlayer] > 3 && points[opponentPlayer] < 3 ){
            return true;
        }
        else if(points[currentPlayer]>5){
            return true;
        }

        return false;
    }

    private boolean checkGame(int playerId){
        return true;
    }

    public void updateScore(String point){

        int playerId=playerName.get(point);
        points[playerId]++;
        if( (points[playerId]==points[(playerId+1)%2] ) && points[playerId]==5)
            points[0]=points[1]=4;
        if(checkPoints(playerId)){
            game_score[playerId]++;
            //reset point

            if(checkGame(playerId)){
                set_score[playerId]++;
                //reset game

            }
        }

    }

    public void printScoreCard(){

    }
}


