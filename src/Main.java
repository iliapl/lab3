import exception.TimelostException;
import people.Clerk;
import people.Controller;
import people.Duty;
import people.Rachel;
import place.*;
import place.sound.Noise;
import place.speed.Runspeed;
import place.time.Time;
import things.Aircraft;
import things.Bus;
import things.Sostair;
import things.Xray;
import things.title.Bigtitle;
import things.title.Smalltitle;

public class Main {
    public static void main(String[] args) {
        Time time = new Time();
        Noise noise = new Noise();
        Runspeed runspeed = new Runspeed();
        Busstation busstation = new Busstation(1, 1, 1);
        Airport airport = new Airport(3, 3, busstation);
        Airportcheckpoint airportcheckpoint = new Airportcheckpoint(airport);
        Exit exit = new Exit(airport);
        Transition transition = new Transition(airportcheckpoint, exit);
        Field field = new Field(busstation, airport, 100);
        Airport.Door door = airport.new Door();
        Airportcheckpoint.Door door1 = airportcheckpoint.new Door();
        Airportcheckpoint.Exitdoor exitdoor = airportcheckpoint.new Exitdoor();
       Aircraft air = new Aircraft(104);
       air.setSost(Sostair.POSADKA);



       Bus bus = new Bus();
       Xray xray = new Xray();
       Smalltitle small = new Smalltitle(104, "Портленд", "Бостон", 11, 25, 31, air);
       Bigtitle big = new Bigtitle(104, "Портленд", "Бостон", 11, 25, 31, air);
       Clerk clerk = new Clerk(10, 10, 10);
       Controller controller = new Controller(airportcheckpoint);
       Duty duty = new Duty(exit);
       Rachel rachel = new Rachel(1,1,1, busstation);
       Clerk.Head head = clerk.new Head();
       rachel.waitingbus(time,bus);
       rachel.run(busstation, airport, field, door, noise, runspeed, time);
       rachel.vorvolas(airport, door, noise, time);
       clerk.look(head,door,noise, rachel, time);
       rachel.speak(airport, head, clerk, time);
       clerk.look(rachel, head, time);
       clerk.speak(rachel, head, time);
       rachel.speak(airport, head, clerk, time);
       clerk.speak(rachel, head, time);
       rachel.run(airport, runspeed, time, airportcheckpoint);
       rachel.climb(airport, runspeed, time, airportcheckpoint, door1, noise);
       rachel.takeoff(controller);
       controller.take(rachel,controller,time);
       controller.postav(rachel,controller,time);
       xray.scan(controller,rachel,time);
       rachel.takehandbag(xray);
       rachel.run(airportcheckpoint, time, runspeed, exitdoor, noise, transition, exit, big, air);
       air.setSost(Sostair.OTPRAVLENIE);
       big.setSostair(air);
       small.setSostair(air);
       rachel.look(transition, big, time, air);
       duty.deletenadpis(small);
       rachel.speak(duty);
       duty.look(rachel);
    }
}