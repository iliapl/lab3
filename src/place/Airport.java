package place;

public class Airport extends Place {
    public Airport(int x, int y, Busstation busstation) {
        super(x, y, busstation.getZ());
    }
    private int length = 10 + getX();
    private int high = 10 + getZ();
    private int width = 10 + getY();
    private int volume = length * high * width;
    public int getHigh() {
        return high;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public class Door extends Place.Door {

    }
}

