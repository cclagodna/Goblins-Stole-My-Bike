package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class Explosion extends Abstract_Attack{
    
    public Explosion() {
        this.name = "Explosion";
        this.desc = "Gotta practice my stabbin'.";
        this.img = null;
        this.type = new Element("fire");
        this.power = 14.0;
    }
    
}
