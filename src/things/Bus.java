package things;



import place.Places;

public class Bus {
   private Places busplace = Places.UNKNOWN;
   public Places getBusplace()  {
       return busplace;
   }

    public void setBusplace(Places busplace) {
        this.busplace = busplace;
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
