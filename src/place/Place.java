package place;

import java.util.Objects;

public abstract class Place {
    private int x;
    private int y;
    private int z;
    public Place(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z =z;
    }
    public Place(){

    }

    public int getX() {
        return  x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    public class Door {
        private int radius;
        private int speed;
        private int x = Place.this.getX();
        private int y = Place.this.getY();

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
        return Objects.hash(x,y,z);
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
