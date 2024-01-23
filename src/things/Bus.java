package things;



import place.Places;
import things.actinios.Drive;

public class Bus implements Drive {
   private Places busplace = Places.UNKNOWN;
   public Places getBusplace()  {
       return busplace;
   }
    public Places drive(Places place){
    if(place == Places.TRIP || place == Places.AIRPORT){
        busplace = Places.UNKNOWN;
    }
    if(place == Places.UNKNOWN){
        busplace = Places.BUS_STATION;
    }
    return busplace;
   }
}
