package things.title;

import things.Aircraft;
import things.Sostair;

import java.util.Objects;

public class Title {
    protected int reisname;
    protected String citynaznachenia;
    protected String cityotpravlenia;
    protected int chas;
    protected int minut;
    protected int nomervix;
    protected Sostair sostair;
    Aircraft air;

    public Title(int reisname, String citynaznachenia, String cityotpravlenia, int chas, int minut, int nomer, Aircraft aircraft) {
        this.reisname = reisname;
        this.citynaznachenia = citynaznachenia;
        this.cityotpravlenia = cityotpravlenia;
        if (0 <= chas) {
            if (chas <= 24) {
                this.chas = chas;
            }
        } else {
            this.chas = 0;
        }
        if (0 <= minut) {
            if (minut <= 60) {
                this.minut = minut;
            }
        } else {
            this.minut = 0;
        }
        this.nomervix = nomer;
        air = new Aircraft(reisname);

    }

    public void setSostair(Aircraft aircraft) {
        if (aircraft.equals(air)) {
            this.sostair = aircraft.getSost();

        }
    }

    public Sostair getSostair() {
        return sostair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chas, citynaznachenia, cityotpravlenia, reisname, minut, nomervix);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Title that = (Title) obj;
        return chas == that.chas && Objects.equals(citynaznachenia, that.citynaznachenia)
                && Objects.equals(cityotpravlenia, that.cityotpravlenia) && reisname == that.reisname
                && minut == that.minut && nomervix == that.nomervix;
    }
}
