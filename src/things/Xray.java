package things;

import exception.TimelostException;
import people.Controller;
import people.Rachel;
import place.time.Time;
import things.actinios.Scan;

public class Xray implements Scan {
    private boolean xrayprov;

    public void setXrayprov(boolean xrayprov) {
        this.xrayprov = xrayprov;
    }
    public boolean getProv(){
        return xrayprov;
    }

    public void scan(Controller controller, Rachel rachel, Time time){
        if(controller.put(rachel,controller, time)){
            class Display{
                public boolean check(Rachel rachel){
                    return rachel.getRechhandbag().getVolume()[0]==null;
                }
            }
            Display display = new Display();
            time.setTick(1);//fast
            setXrayprov(display.check(rachel));
        }
    }
}
