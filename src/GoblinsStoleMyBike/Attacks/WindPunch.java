package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class WindPunch extends Abstract_Attack{
    
    public WindPunch() {
        this.name = "WindPunch";
        this.img = null;
        this.type = new Element("wind");
        this.power = 10.0;
    }
    
}
