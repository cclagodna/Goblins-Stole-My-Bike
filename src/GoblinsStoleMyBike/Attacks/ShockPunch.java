package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class ShockPunch extends Abstract_Attack{
    
    public ShockPunch() {
        this.name = "ShockPunch";
        this.img = null;
        this.type = new Element("shock");
        this.power = 17.0;
    }
    
}
