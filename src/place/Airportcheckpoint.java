package place;

import java.util.Objects;

public class Airportcheckpoint extends Place {
    private int length;
    private int high;
    private int width;
    private int volume;
    public Airportcheckpoint(Airport airport){
        setX(airport.getLength() - 6 );
        setY(airport.getWidth() - 10 );
        setZ(airport.getHigh() - 8 );
        this.length = 1 + getX();
        this.high = 1 + getZ();
        this.width = 1 + getY();
        this.volume = length * high * width;
    }
    public void setHigh(int high) {
        this.high = high;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public class Door extends Place.Door{

    }
    public class Exitdoor extends Place.Door{
        private int radius;
        private int speed;
        private int x = super.getX() + 1;
        private int y = super.getY() + 1;

        public void setRadius(int radius) {
            if (0 <= radius && radius <= 90) {
                this.radius = radius;
            }
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }


        public int getRadius() {
            return radius;
        }

        public int getSpeed() {
            return speed;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

    }
    @Override
    public int hashCode(){
        return Objects.hash(getX(),getY(),getZ());
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Place place = (Place) obj;
        return this.hashCode() == place.hashCode();
    }
}
