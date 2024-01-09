package place;

import java.util.Objects;

public class Transition extends Place{
    private int length;
    private int high;
    private int width;
public Transition(Airportcheckpoint airportcheckpoint, Exit exit){
    setY(airportcheckpoint.getWidth());
    setX(airportcheckpoint.getLength());
    setZ(airportcheckpoint.getZ());
    length = exit.getX() - airportcheckpoint.getLength();
}
}
