package people.actions;

import place.Airportcheckpoint;
import place.sound.Noise;
import place.time.Time;

public interface Openexitdoor {
    public void opendoor(Airportcheckpoint.Exitdoor exitdoor, Noise noise, Time time);
}
