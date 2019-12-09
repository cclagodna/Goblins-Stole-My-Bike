package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class Melt extends Abstract_Attack{
    
    public Melt() {
        this.name = "Melt";
        this.desc = "Gotta practice my stabbin'.";
        this.img = null;
        this.type = new Element("corrosive");
        this.power = 17.5;
    }
    
}
