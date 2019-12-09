package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class LightBeam extends Abstract_Attack{
    
    public LightBeam() {
        this.name = "LightBeam";
        this.img = null;
        this.type = new Element("magic");
        this.power = 14.0;
    }
    
}
