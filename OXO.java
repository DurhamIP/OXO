import java.util.*;

public class OXO
{
    private List<Integer> xs;
    private List<Integer> os;
    private List<Integer> free;
    private static List<Integer> magic;

    public OXO(){
        xs = new ArrayList<Integer>();
        os = new ArrayList<Integer>();
        free = new ArrayList<Integer>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int [] mi = {2,7,6,9,5,1,4,3,8};
	for(int num: nums){
	    free.add(num);
        }
        magic = new ArrayList<Integer>();
	for(int m: mi){
	    magic.add(m);
        }
    }

    public void makeMove(int pos) throws InvalidMoveException{
        if(!free.contains(pos)){
            throw new InvalidMoveException("Too big");
        }
        if((xs.size() + os.size())%2 == 0){
            xs.add(pos);
        }
        else{
            os.add(pos);
        }
        free.remove(new Integer(pos));
    }
    
    public String posToString(int pos){

        if(xs.contains(pos)){
            return "X";
        }
        if(os.contains(pos)){
            return "O";
        }
        return " ";
    }
    
    public String toString(){
        StringBuffer ret = new StringBuffer();
	int count = 1;
        for(int pos: magic){
            ret.append(posToString(pos));
	    if(count%3 ==0){
		ret.append("\n");
	    }
	    count++;
        }
        return ret.toString();
    }

    public static String magicLocations(){
        StringBuffer ret = new StringBuffer();
	int count = 1;
        for(int pos: magic){
            ret.append(pos);
	    if(count%3 ==0){
		ret.append("\n");
	    }
	    count++;
        }
        return ret.toString();

    }

    /**
     * @return 1 if player 1 wins, 2 if player 2 wins, 0 if no winner
     */
    
    public int winner(){
	if(sumTotalfromN(15, 3, xs)){
	    return 1;
	}
	if(sumTotalfromN(15, 3, os)){
	    return 2;
	}
	return 0;
    }

    public boolean sumTotalfromN(int total, int n, List<Integer> nums){
	if(n<=0){
	    return false;
	}
	if(nums.size() < n){
	    return false;
	}
	int first = nums.get(0);
	if(n==1){
	    return total==first;
	}
	List<Integer> withoutFirst = new ArrayList<Integer>();
	for(int num: nums){
	    if(num!= first){
		withoutFirst.add(num);
	    }
	}

	boolean workWithFirst = sumTotalfromN(total - first, n-1, withoutFirst);
	if(workWithFirst){
	    return true;
	}
	else{
	    return sumTotalfromN(total, n, withoutFirst);
	}
    }
    
    public static void main (String[] args){
	OXO game = new OXO();

	Player p1 = new Player("Steven");
	Player p2 = new Player("Somemody else");

	List<Player> players = new ArrayList<Player>();
	players.add(p1);
	players.add(p2);

	int playerNum = 0;

	while(game.winner() == 0){
	    try{
		System.out.println("Game state:\n");
		System.out.println(game + "\n");
		int move = players.get(playerNum).getMove();
		game.makeMove(move);
		playerNum++;
		if(playerNum >= players.size()){
		    playerNum = 0;
		}
	    }
	    catch(InvalidMoveException e){
		System.out.println("Invalid move, please try again");
	    }
	}
	System.out.println("The winner is " + players.get(1-playerNum));
    }
}
