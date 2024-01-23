package place;

public class Field extends Place{
    private int length;
    private int high;
    private int width;
    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public Field(Busstation busstation, Airport airport, int z) {
        setX(busstation.getX()+1);
        setY(busstation.getY()+1);
        setZ(z);
        setLength(airport.getX()-busstation.getX());
        setWidth(airport.getY() - busstation.getY());
    }

}
