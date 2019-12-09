package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class LeafStab extends Abstract_Attack{
    
    public LeafStab() {
        this.name = "LeafStab";
        this.img = null;
        this.type = new Element("grass");
        this.power = 10.2;
    }
    
}
