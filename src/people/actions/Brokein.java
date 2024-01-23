package people.actions;

import place.Airport;
import place.sound.Noise;
import place.time.Time;

public interface Brokein {
    public void brokein(Airport airport, Airport.Door door, Noise noise, Time time);
}
