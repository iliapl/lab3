package place.time;

import exception.TimelostException;
import people.Rachel;

public class Time {
   private int tick;

   public int getTick() {
      return tick;
   }


   public void setTick(int tick) throws TimelostException{
      this.tick = this.tick + tick;
      if(this.tick > 1000){
         throw new TimelostException("Рейчал осознала что точно не успеет на самолёт");
      }
   }

}
