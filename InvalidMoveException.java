
public class InvalidMoveException extends Exception
{
    // instance variables - replace the example below with your own
    private String err;

    /**
     * Constructor for objects of class InvalidMoveException
     */
    public InvalidMoveException(String err)
    {
        this.err =err;
    }

    @Override
   public String toString(){
       return err;
    }
}
