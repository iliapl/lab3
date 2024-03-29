package people;


import exception.InthewrongplaceException;
import exception.Rechlostenergy;
import people.actions.*;
import people.feelings.Moralfeelings;
import people.feelings.Physicalfeelings;
import place.*;
import place.sound.Noise;
import place.sound.Sound;
import place.speed.Runspeed;
import place.speed.Speeds;
import place.time.Time;
import things.*;
import things.title.Title;
import people.consciene.Formatcontact;

public class Rachel extends Human implements Heartbeat,Redresslegs,Brokein, Waiting, Opendoor, Shakehair, Openexitdoor, Takeoff, Ttakehandbag, Hold, Clumsy, Screame {
    private Places rachelplace;
    private Clothe[] dress;
    private Moralfeelings moralfeelings = super.moralfeelings;
    private int patience;
    private int panic;
    private int painlegs;
    private int painside;
    private Shoe rechshoeright;
    private Shoe rechshoeleft;
    private Handbag rechhandbag;
    public Place rechplace;
    Conscience consciencerachel;
    Human.Head head;
    Human.Hand[] hands;
    public Rachel(int x, int y, int z, Busstation busstation){
        super(x,y,z);
        this.rechshoeright = new Shoe(225);
        this.rechshoeleft = new Shoe(225);
        this.rechhandbag = new Handbag(134);
        setRechplace(busstation);
        rachelplace= Places.BUS_STATION;
        this.dress = new Clothe[5];
        dress[0] = rechshoeright;
        dress[1] = rechshoeleft;
        dress[2] = rechhandbag;
        setEnergy(100);
        patience = 3;
        panic = 0;
        painside = 0;
        consciencerachel = new Conscience();
        head = new Head();
        hands = new Hand[2];
        hands[0] = new Hand();
        hands[1] = new Hand();
    }
    public void waitingbus(Time time, Bus bus) {

        if( bus.getBusplace()  == Places.UNKNOWN)  {

                while (patience>0){
                    time.setTick(2);//normal
                    patience = patience - 1;
                    panic = panic + 1;
                    painlegs = painlegs + 1;
                    if(painlegs == 2){
                        redressdlegs(time);
                    }
                }
                if (panic == 3){
                    moralfeelings = Moralfeelings.PANIC;
                }
            }
    }
    @Override
    public void brokein(Airport airport, Airport.Door door, Noise noise, Time time) throws InthewrongplaceException {
        if(getX() == airport.getX() && getY() == airport.getY()){
            door.setRadius(90);
            door.setSpeed(2);
            noise.setVolume(door);
            noise.setSound(Sound.ANOTHERSOUND);
            rechplace = airport;
            clumsy();
            grab();
            time.setTick(1);//fast

        }
        else {
            throw new InthewrongplaceException("Наша Рейчал в другом замке");
        }
    }
    @Override
    public void opendoor(Airportcheckpoint airportcheckpoint, Airportcheckpoint.Door door, Noise noise, Time time) throws InthewrongplaceException {
        if(x == airportcheckpoint.getX() && y == airportcheckpoint.getY() && z == airportcheckpoint.getZ()){
            door.setRadius(60);
            door.setSpeed(1);
            noise.setVolume(door);
            noise.setSound(Sound.ANOTHERSOUND);
            time.setTick(2);//normal
        }
        else {
            throw new InthewrongplaceException("Рейчал не может открыть дверь, она слишком далеко");
        }
    }
    @Override
    public void opendoor(Airportcheckpoint.Exitdoor exitdoor, Noise noise, Time time) throws InthewrongplaceException {
        if (getY() == exitdoor.getY() && getX() == exitdoor.getX()) {
            exitdoor.setRadius(60);
            exitdoor.setSpeed(1);
            noise.setVolume(exitdoor);
            time.setTick(2);//normal
        }
        else{
            throw new InthewrongplaceException("Рейчал не может открыть дверь, она слишком далеко");
        }
    }

    public void speak(Airport airport, Clerk.Head head, Clerk clerk, Time time) {
        if(rechplace.equals(airport)){
            if (head.getTurningradius() == (90 - Math.asin( ((Math.abs(y) - Math.abs(clerk.y)) /
                    (Math.sqrt(Math.pow(Math.abs(y) - Math.abs(clerk.y),2)+ Math.pow(Math.abs(x) - Math.abs(clerk.x),2))))))){
                consciencerachel.contact(clerk, Formatcontact.MESSAGE);
                System.out.println("— Рейс 104, — выпалила она. — В Портленд. Улетел?");
                getNois().setSound(Sound.SPEECH);
                getNois().setVolume(180);
                time.setTick(1);//fast
            }
            if(head.getTurningradius() == 0 && clerk.getNois().getVolume() == 180 && clerk.getNois().getSound() == Sound.SPEECH){
                if (consciencerachel.getHumancontact() == clerk.hashCode()){
                    if(clerk.conscience.getFormatcontact()== Formatcontact.MESSAGE) {
                        System.out.printf("'%20s' %n","Н_е_т— проговорила Рэчел хрипло");
                        consciencerachel.setFormatcontact(Formatcontact.RESPONSE);
                        getNois().setSound(Sound.SPEECH);
                        getNois().setVolume(180);
                        time.setTick(1);//fast
                    }
                }
            }
        }
        else {
            getNois().setSound(Sound.NOSOUND);
            getNois().setVolume(0);
        }
    }
    public void run(Place busstation, Airport airport, Field field, Airport.Door door, Noise noise, Runspeed runspeed, Time time) {
           try {
               runspeed.speedcalculation(getEnergy(time));
           }catch (Rechlostenergy e){
               System.out.println("переводит дух");
           }
           if (panic == 3){
               setY(getY() + 1);
               setX(getX() + 1);
               painside = 3;
               if(getX() <= field.getX() && getX()>= busstation.getX()) {
                   if(getY() <= field.getY() && getY() >= field.getY()) {
                       while (getX() < door.getX() && getX()> busstation.getX() && getY() < door.getY() && getY() >= field.getY()) {
                           setX(getX()+1);
                           setY(getY()+1);
                           head.reducinghaircarelessness();
                           try {
                               setEnergy(getEnergy(time) - 5);//iskluchbaxnut
                           }catch (Rechlostenergy e){
                               System.out.println("передохнула");
                           }
                           time.setTick(3);//normal
                          try {
                              if (getEnergy(time) == 50 ) {
                                  setPhysicalfeelings(Physicalfeelings.USTAL);
                              }
                          }catch (Rechlostenergy e){
                              System.out.println("передохнула");
                          }
                       }
                   }
               }
           }

        if(getX() == airport.getX() && getY() == airport.getX()){
            setRechplace(airport);
            brokein(airport, door, noise, time);

        }
    }
    public void run(Place airport, Runspeed runspeed, Time time,Airportcheckpoint airportcheckpoint) throws InthewrongplaceException {
        if (getX() <= airport.getLength() && getX() < (airportcheckpoint.getX() -1) && airport.getY() == getY() && airport.getX()==getX()) {//akkuratno s gety
            try {
                runspeed.speedcalculation(getEnergy(time));
            }catch (Rechlostenergy e){
                System.out.println("переводит дух");
            }
            if (runspeed.getSpeed() == Speeds.SLOW) {
                while(getX() <= (airportcheckpoint.getX() -2) ) {
                    head.reducinghaircarelessness();
                    setX(getX() + 1);
                    time.setTick(5);//slow
                    try {
                        setEnergy(getEnergy(time) - 5);//iskluchbaxnut
                    }catch (Rechlostenergy e){
                        System.out.println("передохнула");
                    }
                    System.out.println();
                }

            }
            else {
                    while(getX() <= (airportcheckpoint.getX() -2) ) {
                        head.reducinghaircarelessness();
                        setX(getX() + 1);
                        time.setTick(3);
                        try {
                            setEnergy(getEnergy(time) - 10);//iskluchbaxnut
                        }catch (Rechlostenergy e){
                            System.out.println("передохнула");
                        }
                    }
            }
            setPhysicalfeelings(Physicalfeelings.METMOUF);
        }
        else {
            throw new InthewrongplaceException("Рейчал не в том месте");
        }
    }
    public void climb(Airport airport, Runspeed runspeed, Time time, Airportcheckpoint airportcheckpoint, Airportcheckpoint.Door door, Noise noise) throws InthewrongplaceException  {
        if(getX() == (airportcheckpoint.getX()-1)  && getZ() != airportcheckpoint.getZ() && getY() == airport.getY()) {
            try {
                runspeed.speedcalculation(getEnergy(time));
            }catch (Rechlostenergy e){
                System.out.println("переводит дух");
            }
            if(runspeed.getSpeed() == Speeds.SLOW){
                setX(airportcheckpoint.getX());
                setZ(airportcheckpoint.getZ());
                time.setTick((airportcheckpoint.getZ()-getZ()) * 5);//slow
            }
            else{
                setX(airportcheckpoint.getX());
                setZ(airportcheckpoint.getZ());
                time.setTick((airportcheckpoint.getZ() - getZ()) * 3);//normal
            }
        }
        else {
            throw new InthewrongplaceException("Лестница далековато");
        }
        if(getX() == airportcheckpoint.getX() && getZ() == airportcheckpoint.getZ() && airportcheckpoint.getY() == getY()) {
            opendoor(airportcheckpoint,door,noise, time);
            setRechplace(airportcheckpoint);
        }
        else {
            throw new InthewrongplaceException("Не в том месте");
        }
    }

    public void setRechplace(Place place) {

            rechplace = place;
    }
    public void setPhysicalfeelings(Physicalfeelings physicalfeelings) {
       this.physicalfeelings = physicalfeelings;
    }
    public Physicalfeelings getPhysicalfeelings() {
        return physicalfeelings;
    }
    @Override
    public void redressdlegs(Time time) {
        if(painlegs == 2){
        dress[0] = null;
        dress[1] = null;
        dress[3] = rechshoeright;
        dress[4] = rechshoeleft;
        time.setTick(2);//normal
        }
    }
    @Override
    public void shakehair(){
        head.setHaircarelessness(10);
        System.out.println("стряхивая с глаз вспотевшие волосы.");
    }
    @Override
    public void hold() {
            if (getPhysicalfeelings() == Physicalfeelings.USTAL) {
                painlegs = painlegs + 5;
            }
    }
   public void run(Place airportcheckpoint, Time time, Runspeed runspeed, Airportcheckpoint.Exitdoor exitdoor, Noise noise, Transition transition, Exit exit, Title title, Aircraft aircraft) throws InthewrongplaceException {
        if(rechplace.equals(airportcheckpoint) && dress[2].equals(rechhandbag)) {//cherez iskl posmotr time
            if (aircraft.getSost() == Sostair.POSADKA) {
                setX(exitdoor.getX());
                setY(exitdoor.getY());
                opendoor(exitdoor, noise, time);
                setX(transition.getX());
                setY(transition.getY());
                setRechplace(transition);
                hold();
                look(transition, title, aircraft);
                try {
                    runspeed.speedcalculation(getEnergy(time));
                } catch (Rechlostenergy e) {
                    System.out.println("переводит дух");
                    runspeed.setSpeed(Speeds.SLOW);
                }
                if (runspeed.getSpeed() == Speeds.SLOW) {
                    try {
                        setEnergy(getEnergy(time) - 5);//iskluchbaxnut
                    } catch (Rechlostenergy e) {
                        System.out.println("передохнула");
                    }
                    time.setTick(2);
                }
                if (runspeed.getSpeed() == Speeds.FAST) {
                    time.setTick(1);
                    try {
                        setEnergy(getEnergy(time) - 10);//iskluchbaxnut
                    } catch (Rechlostenergy e) {
                        System.out.println("передохнула");
                    }
                }
            }
            else{
                System.out.println("Она подбежала к выходу");
            }
        }
        else {
            throw new InthewrongplaceException("Рейчал не в том месте или не взяла сумку");
        }
   }
   public void look(Transition transition, Title title, Aircraft aircraft){
        if(getX() == transition.getX() && getY() == transition.getY() && getZ() == transition.getZ()){
            if(aircraft.getSost() == Sostair.POSADKA) {
                System.out.println("Она смотрела на мелькающие по сторонам надписи. " + title.toString());
            }
            if(aircraft.getSost() == Sostair.OTPRAVLENIE){
                System.out.println(" надпись «посадка» сменилась словом «отправление»");
                scream(title);
            }
        }
   }
   public void speak(Duty duty){
        consciencerachel.contact(duty, Formatcontact.MESSAGE);
       getNois().setSound(Sound.SPEECH);
       getNois().setVolume(180);
       System.out.println(" Он улетел? — спросила она недоверчиво. — Правда улетел?");
   }
@Override
    public void waiting(Airportcheckpoint airportcheckpoint, Time time){//!
        if(rechplace == airportcheckpoint){
            for(int i = 0; i < 2; i++){
               hands[0].clenchhand();
               hands[0].relaxhand();
                hands[1].clenchhand();
                hands[1].relaxhand();
            }
            System.out.println("подождала у конвейера, сжимая и разжимая кулаки.");
        }
    }

@Override
    public void clumsy(){
        dress[3] = null;
    }
    public void grab(){
            if (dress[3] == null) {
                dress[3] = rechshoeright;
            }
            if (dress[4] == null) {
                dress[4] = rechshoeleft;
            }
    }
    @Override
    public void takehandbag(Xray xray){//!
        if(xray.getProv()){
        dress[2] = rechhandbag;
        }
    }
    @Override
    public void scream(Title title){
        if(title.getSostair() == Sostair.OTPRAVLENIE){
            getNois().setVolume(180);
            getNois().setSound(Sound.ANOTHERSOUND);
            System.out.println("У нее вырвался крик отчаяния");
        }
    }
    @Override
    public void heartbeat(Noise noise){
        noise.setVolume(180);
        noise.setSound(Sound.ANOTHERSOUND);
        System.out.println("Сердце в её груди прыгало, как заяц");
    }

    public Handbag getRechhandbag() {
        return rechhandbag;
    }


    @Override
    public void takeoff(Controller controller){//!
        consciencerachel.contact(controller, Formatcontact.MESSAGE);
        dress[2] = null;
        System.out.println("почти швырнула сумку контролерше");
    }
}
