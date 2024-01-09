package place.speed;

import people.Human;

public class Runspeed extends Speed{

    public Speeds speedcalculation(int x) {
        if (x <= 50){
            setSpeed(Speeds.SLOW);
        }
        if(x >=50){
            setSpeed(Speeds.FAST);
        }
        return getSpeed();
    }
}
