package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class WaterRocket extends Abstract_Attack{
    
    public WaterRocket() {
        this.name = "WaterRocket";
        this.desc = "Gotta practice my stabbin'.";
        this.img = null;
        this.type = new Element("water");
        this.power = 12.0;
    }
    
}
