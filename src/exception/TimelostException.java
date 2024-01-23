package exception;

import people.Rachel;
import things.Aircraft;
import things.Sostair;

public class TimelostException extends  RuntimeException{
    public TimelostException(String message){
        super(message);
    }
}
