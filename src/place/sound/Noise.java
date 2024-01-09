package place.sound;

import place.Airport;
import place.Airportcheckpoint;

public class Noise {
    private int volume;
    private Sound sound;
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setVolume(Airport.Door door){
        this.volume = door.getRadius()*door.getSpeed();
    }
    public void setVolume(Airportcheckpoint.Door door){
        this.volume = door.getRadius()*door.getSpeed();
    }
    public void setVolume(Airportcheckpoint.Exitdoor door){
        this.volume = door.getRadius()*door.getSpeed();
    }

    public int getVolume() {
        return volume;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public Sound getSound() {
        return sound;
    }
}
