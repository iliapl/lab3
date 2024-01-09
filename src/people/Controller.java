package people;

import exception.TimelostException;
import people.actions.Speak;
import people.consciene.Formatcontact;
import place.Airportcheckpoint;
import things.Clothe;
import things.Clothes;
import place.time.Time;

public class Controller extends Human implements Speak {
    private int x;
    private int y;
    private int z;
    private Clothe[] clothes = new Clothe[1];

   public Controller(Airportcheckpoint airportcheckpoint){
       this.x = airportcheckpoint.getX() + 1;
       this.y = airportcheckpoint.getY() + 1;
       this.z =airportcheckpoint.getZ() + 1;
       consciencecontroller = new Consciencecontroller();
   }
    @Override
    public void speak(){}
    public void look(){}

    public boolean take(Rachel rachel, Controller controller, Time time){
        if(rachel.consciencerachel.getHumancontact() == controller.hashCode()){
            consciencecontroller.contact(rachel, Formatcontact.WAIT);
        }
        clothes[0] = rachel.getRechhandbag();
        time.setTick(1);//fast
        return Formatcontact.WAIT == consciencecontroller.getFormatcontact();
    }
    public boolean postav(Rachel rachel, Controller controller, Time time)  {
        if(take(rachel, controller, time)){
            clothes[0] = null;
        }
        time.setTick(1);//fast
        return clothes[0] == null;
    }
    class Consciencecontroller extends Conscience{

    }
    private Consciencecontroller consciencecontroller;

}
