package people;

import java.util.Objects;

import exception.Rechlostenergy;
import people.actions.Turnon;
import people.actions.Turnonhuman;
import people.consciene.Formatcontact;
import people.haircondition.Haircondition;
import place.Place;
import place.sound.Noise;
import place.time.Time;

import static people.haircondition.Haircondition.Disheveled;

public abstract class Human{
    private int energy;
    protected  things.Clothes clothes;
    protected people.feelings.Physicalfeelings physicalfeelings;
    protected people.feelings.Moralfeelings moralfeelings;
    public void look(Human human, Human.Head head, Time time){}
    protected int x;
    protected int y;
    protected int z;
    protected int startx;
    protected int starty;
    protected int startz;
    private Noise noise;
    public Human(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z =z;
        startx = x;
       starty = y;
        startz = z;
        noise = new Noise();
    }
    public Noise getNois() {
        return noise;
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
    public class Head implements Turnon, Turnonhuman {
        private double turningradius=0;

        public void setTurningradius(double turningradius) {
            this.turningradius = turningradius;
        }

        public double getTurningradius() {
            return turningradius;
        }
@Override
        public void turnon(Place.Door door){
            setTurningradius( (90 - Math.asin((Math.abs(door.getY()) - Math.abs(y)) /
                    (Math.sqrt(Math.pow(Math.abs(door.getY()) - Math.abs(y),2)+ Math.pow(Math.abs(door.getX()) - Math.abs(x),2))))));
        }
        @Override
        public void turnon(Human human){
            setTurningradius( (90 - Math.asin((Math.abs(human.getY()) - Math.abs(y)) /
                    (Math.sqrt(Math.pow(Math.abs(human.getY()) - Math.abs(y),2)+ Math.pow(Math.abs(human.getX()) - Math.abs(x),2))))));
        }
        private Haircondition haircondition = Haircondition.Collected;
        private int haircarelessness = 10;

        public void setHaircarelessness(int haircarelessness) {
            if(haircarelessness > 5){
                haircondition = Haircondition.Collected;
            }
            this.haircarelessness = haircarelessness;
        }

        public void reducinghaircarelessness(){
           haircarelessness=haircarelessness -1;
           if(haircarelessness <= 5){
               haircondition = Disheveled;
           }
       }

        public Haircondition getHaircondition() {
            return haircondition;
        }
    }
    class Conscience {
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
    public int getEnergy(Time time) throws Rechlostenergy{
        if (energy<=0){
            energy = 5;
            throw new Rechlostenergy("Кончилась энергия", time);
        }
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    private Head head;
    class Finger{
        private String name;
        private boolean muscletension = false;
        public Finger(String name){
            this.name = name;
        }

        public void setMuscletension(boolean muscletension) {
            this.muscletension = muscletension;
        }
        public boolean getMuscletension(){
            return muscletension;
        }
            public void musclecontraction(){
            if(getMuscletension()==false){
                setMuscletension(true);
            }
        }
            public void musclerelaxation(){
            if(getMuscletension()){
                setMuscletension(false);
            }
        }
    }
    class Hand{
        Finger[] fingers = new Finger[5];
        public  Hand(){
            for(int i = 0; i < 5; i++){
                fingers[i] = new Finger("Finger" + i+1);
            }
        }
        public void clenchhand(){
            for(int i = 0; i < 5; i++){
                fingers[i].musclecontraction();
            }
        }
        public void relaxhand(){
            for(int i = 0; i < 5; i++){
                fingers[i].musclerelaxation();
            }
        }
    }
}