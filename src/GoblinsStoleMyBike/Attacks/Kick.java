package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class Kick extends Abstract_Attack{
    
    public Kick() {
        this.name = "Kick";
        this.desc = "";
        this.img = null;
        this.type = new Element("basic");
        this.power = 11.0;
    }
}
