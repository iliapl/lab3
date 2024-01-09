package people;

import people.consciene.Formatcontact;
import place.Exit;
import place.sound.Sound;
import things.Sostair;
import things.title.Smalltitle;
public class Duty extends Human {
    public Duty(Exit exit){
        super(exit.getX(), exit.getY(), exit.getZ());
        conscienceduty = new Conscienceduty();
        dutyhead = new Dutyhead();
    }

    public void look(Rachel rachel) {
        if (rachel.getNois().getVolume() == 180) {
            if (rachel.getNois().getSound() == Sound.SPEECH) {
                if(rachel.consciencerachel.getHumancontact() == hashCode()){
                    dutyhead.turnonthehuman(rachel);
                    conscienceduty.contact(rachel, Formatcontact.RESPONSE);
                    System.out.println("Дежурный сочувственно посмотрел на нее.");
                }
            }
        }
    }

    public Smalltitle deletenadpis(Smalltitle smallnadpis) {
        String c = smallnadpis.toString();
        if (smallnadpis.getSostair() == Sostair.OTPRAVLENIE) {
            System.out.println(" дежурный убирает надпись. " + c);
            smallnadpis = null;
        }
        return  smallnadpis;
    }
   public class Conscienceduty extends Conscience{

   }
   Conscienceduty conscienceduty;
    public class Dutyhead extends Head{

    }
    Dutyhead dutyhead;
}