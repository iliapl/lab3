package people;

import people.actions.Deletetitle;
import people.consciene.Formatcontact;
import place.Exit;
import place.sound.Sound;
import things.Sostair;
import things.title.Smalltitle;
public class Duty extends Human implements Deletetitle {
    public Duty(Exit exit){
        super(exit.getX(), exit.getY(), exit.getZ());
        conscienceduty = new Conscience();
        dutyhead = new Dutyhead();
    }

    public void look(Rachel rachel) {
        if (rachel.getNois().getVolume() == 180) {
            if (rachel.getNois().getSound() == Sound.SPEECH) {
                if(rachel.consciencerachel.getHumancontact() == hashCode()){
                    dutyhead.turnon(rachel);
                    conscienceduty.contact(rachel, Formatcontact.RESPONSE);
                    System.out.println("Дежурный сочувственно посмотрел на нее.");
                }
            }
        }
    }
    @Override
    public Smalltitle deletetitle(Smalltitle smallnadpis) {
        String c = smallnadpis.toString();
        if (smallnadpis.getSostair() == Sostair.OTPRAVLENIE) {
            System.out.println(" дежурный убирает надпись. " + c);
            smallnadpis = null;
        }
        return  smallnadpis;
    }
   Conscience conscienceduty;
    public class Dutyhead extends Head{

    }
    Dutyhead dutyhead;
}