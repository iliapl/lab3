package exception;


import place.time.Time;

public class Rechlostenergy extends Exception {
    public Rechlostenergy(String massage, Time time){
        super(massage);
        time.setTick(1);
    }
}
