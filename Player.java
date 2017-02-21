import java.io.*;

public class Player {
    private String name;

    public Player(String name){
	this.name = name;
    }

    public int getMove() throws InvalidMoveException{
	try{
	    System.out.println("Hey " + name + ", which square would you like?\n");
	    System.out.println(OXO.magicLocations());
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    return new Integer(input);
	}
	catch(IOException e){
	    throw new InvalidMoveException(e.toString());
	}
    }
}
