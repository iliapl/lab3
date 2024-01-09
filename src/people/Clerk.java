package people;

import exception.TimelostException;
import people.actions.Speak;
import place.Airport;
import place.Place;
import place.Places;
import place.sound.Noise;
import people.consciene.Formatcontact;
import place.sound.Sound;
import place.time.Time;

public class Clerk extends Human{

    Human.Conscience conscience;
    public Clerk(int x, int y, int z){
        super(x, y, z);
        conscience = new Conscience();
    }
    private boolean busy;

    public void look(Head head, Airport.Door door, Noise noise, Rachel rachel, Time time) {
        if (!busy) {
            if (noise.getVolume() >= 180) {
                head.turnonthedoor(door);
                conscience.contact(rachel, Formatcontact.WAIT);
                System.out.println("Posmotrel");
                time.setTick(1);//fast
            }
        }
    }

    public void look(Rachel rachel, Head head, Time time) {
        if(rachel.getNois().getVolume()== 180){
            if(rachel.getNois().getSound()== Sound.SPEECH) {
                if (conscience.getHumancontact() == rachel.hashCode()) {
                    if(rachel.consciencerachel.getFormatcontact() == Formatcontact.MESSAGE) {
                        head.setTurningradius(0);
                        System.out.println("Posmotrel");
                        time.setTick(1);//fast
                    }
                }
            }
        }
    }
    public void speak(Rachel rachel, Head head, Time time) {
        if (rachel.getNois().getVolume() == 180) {
            if (rachel.getNois().getSound() == Sound.SPEECH) {
                if(conscience.getHumancontact() == rachel.hashCode()) {
                    if (head.getTurningradius() == 0) {//monitor
                        if (rachel.consciencerachel.getFormatcontact() == Formatcontact.MESSAGE) {
                            System.out.println("— Еще на земле, но посадка закончилась пять минут назад. Я запрошу их. Багаж есть?");
                            getNois().setVolume(180);
                            getNois().setSound(Sound.SPEECH);
                            conscience.setFormatcontact(Formatcontact.MESSAGE);
                            time.setTick(2);//fast
                        }
                        if(rachel.consciencerachel.getFormatcontact() == Formatcontact.RESPONSE){
                            System.out.println("— Тогда лучше не ждите. Бегите скорей.");
                            time.setTick(1);//fast
                        }
                    }
                }
            }
        }
    }

    public class Head extends Human.Head{
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
    }
}
