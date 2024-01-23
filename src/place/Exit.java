package place;

public class Exit extends Place {
    public Exit(Airport airport){
        setX(airport.getLength());
        setY(airport.getWidth());
        setZ(airport.getHigh());
    }
}
