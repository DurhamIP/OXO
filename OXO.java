import java.util.*;

public class OXO
{
    private Set<Integer> xs;
    private Set<Integer> os;
    private Set<Integer> free;
    private List<Integer> magic;

    public OXO(){
        xs = new HashSet<Integer>();
        os = new HashSet<Integer>();
        free = new HashSet<Integer>();
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
        free.remove(pos);
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
        for(int pos: magic){
            ret.append(posToString(pos));
        }
        return ret.toString();
    }
}
