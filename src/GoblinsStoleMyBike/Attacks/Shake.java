package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class Shake extends Abstract_Attack{
    
    public Shake() {
        this.name = "Shake";
        this.desc = "";
        this.img = null;
        this.type = new Element("earth");
        this.power = 15.0;
    }
    
}
