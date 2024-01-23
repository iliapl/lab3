package people.actions;

import people.Controller;
import people.Rachel;
import place.time.Time;

public interface Take {
    public boolean take(Rachel rachel, Controller controller, Time time);
}
