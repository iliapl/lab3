package things;

import place.time.Time;
import things.actinios.Fly;

import java.util.Objects;
public class Aircraft implements Fly {
    private Sostair sost;
    private int name;
    public Aircraft(int name){
        this.name = name;
    }

    public Sostair getSost() {
        return sost;
    }

    public void setSost(Sostair sost) {
        this.sost = sost;
    }
    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }
    @Override
    public void fly(Time time){
        if(time.getTick() >= 40){
            sost=Sostair.OTPRAVLENIE;
        }
        else{
            System.out.println("Самолёт не может взлететь сейчас, время вылета не настало");
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Aircraft aircraft = (Aircraft) obj;
        return this.hashCode() == aircraft.hashCode();
    }
}
