package things;

public class Handbag  extends Clothe{
    private Item[] volume = new Item[1];
    public Handbag(int series){
        super(series);
        name = Clothes.HANDBAG;
        volume[0] = null;
    }

    public Item[] getVolume() {
        return volume;
    }
    public void setItem(Item item){
        volume[0] = item;
    }
}
