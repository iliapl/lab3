package things.title;

import things.Aircraft;
import java.util.Objects;

public class Bigtitle extends Title {

    public Bigtitle(int reisname, String citynaznachenia, String cityotpravlenia, int chas, int  minut, int nomer, Aircraft aircraft){
        super(reisname, citynaznachenia, cityotpravlenia,chas,minut, nomer, aircraft);
    }
    @Override
    public String toString(){
        return "Рейс" + reisname + "." + citynaznachenia + "." + "Отправление" + chas + ":" + minut + "." + "Выход" + nomervix + "." + sostair;
    }
    @Override
    public int hashCode(){
        return Objects.hash(chas,citynaznachenia, cityotpravlenia, reisname, minut, nomervix);
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
