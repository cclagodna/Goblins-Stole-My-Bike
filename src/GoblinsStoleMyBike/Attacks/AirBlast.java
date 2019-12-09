package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class AirBlast extends Abstract_Attack{
    
    public AirBlast() {
        this.name = "AirBlast";
        this.desc = "Gotta practice my stabbin'.";
        this.img = null;
        this.type = new Element("wind");
        this.power = 13.0;
    }
    
}
