package people.actions;

import place.Airport;
import place.Airportcheckpoint;
import place.sound.Noise;
import place.time.Time;

public interface Opendoor {
    public void opendoor(Airportcheckpoint airportcheckpoint, Airportcheckpoint.Door door, Noise noise, Time time);
}
