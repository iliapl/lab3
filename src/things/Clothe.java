package things;

import things.title.Title;

import java.util.Objects;

public class Clothe {
    private final int series;
    protected Clothes name;
    public Clothe(int series){
        this.series = series;
    }
    @Override
    public int hashCode() {
        return Objects.hash(series);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothe that = (Clothe) obj;
        return series == that.series && name == that.name;
    }
}
