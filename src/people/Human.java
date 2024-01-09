package people;

import java.util.Objects;

import exception.Rechlostenergy;
import people.consciene.Formatcontact;
import place.Place;
import place.sound.Noise;
import place.time.Time;

public abstract class Human{
    private int energy;
    @Override
    public int hashCode(){
      return  Objects.hash(physicalfeelings, moralfeelings, clothes);
    }
    protected  things.Clothes clothes;
    protected people.feelings.Physicalfeelings physicalfeelings;
    protected people.feelings.Moralfeelings moralfeelings;
    public void look(Human human, Human.Head head, Time time){}
    protected int x;
    protected int y;
    protected int z;
    private Noise noise;
    public Human(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z =z;
        noise = new Noise();
    }
    public Noise getNois() {
        return noise;
    }

    public void setNois(Noise noise) {
        this.noise = noise;
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
    public Human(){}
    public class Head {
        private double turningradius=0;

        public void setTurningradius(double turningradius) {
            this.turningradius = turningradius;
        }

        public double getTurningradius() {
            return turningradius;
        }

        public void turnonthedoor(Place.Door door){
            setTurningradius( (90 - Math.asin((Math.abs(door.getY()) - Math.abs(y)) /
                    (Math.sqrt(Math.pow(Math.abs(door.getY()) - Math.abs(y),2)+ Math.pow(Math.abs(door.getX()) - Math.abs(x),2))))));
        }
        public void turnonthehuman(Human human){
            setTurningradius( (90 - Math.asin((Math.abs(human.getY()) - Math.abs(y)) /
                    (Math.sqrt(Math.pow(Math.abs(human.getY()) - Math.abs(y),2)+ Math.pow(Math.abs(human.getX()) - Math.abs(x),2))))));
        }
    }
    class Conscience{
        private int hair;
        private int humancontact;
        private Formatcontact formatcontact;
        public void contact(Human human, Formatcontact formatcontact){//gпосмотреть про наследуемсоть вложенных классов
            humancontact = human.hashCode();
            this.formatcontact =formatcontact;
        }

        public int getHumancontact() {
            return humancontact;
        }

        public Formatcontact getFormatcontact() {
            return formatcontact;
        }

        public void setFormatcontact(Formatcontact formatcontact) {
            this.formatcontact = formatcontact;
        }
    }

    public int getEnergy() throws Rechlostenergy{
        if (energy<=0){
            System.out.println("Кончилась энергия");
            energy = 5;
        }
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    private Head head;
}
