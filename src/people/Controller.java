package people;

import people.actions.Put;
import people.actions.Take;
import people.consciene.Formatcontact;
import place.Airportcheckpoint;
import things.Clothe;
import place.time.Time;

public class Controller extends Human implements Put, Take {
    private int x;
    private int y;
    private int z;
    private Clothe[] clothes = new Clothe[1];

   public Controller(Airportcheckpoint airportcheckpoint){
       this.x = airportcheckpoint.getX() + 1;
       this.y = airportcheckpoint.getY() + 1;
       this.z =airportcheckpoint.getZ() + 1;
       consciencecontroller = new Conscience();
   }
@Override
    public boolean take(Rachel rachel, Controller controller, Time time){
        if(rachel.consciencerachel.getHumancontact() == controller.hashCode()){
            consciencecontroller.contact(rachel, Formatcontact.WAIT);
        }
        clothes[0] = rachel.getRechhandbag();
        time.setTick(1);//fast
        return Formatcontact.WAIT == consciencecontroller.getFormatcontact();
    }
    @Override
    public boolean put(Rachel rachel, Controller controller, Time time)  {
        if(take(rachel, controller, time)){
            clothes[0] = null;
        }
        time.setTick(1);//fast
        return clothes[0] == null;
    }
    private Conscience consciencecontroller;

}
