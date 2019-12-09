package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;

public class EarthCrush extends Abstract_Attack{
    
    public EarthCrush() {
        this.name = "EarthCrush";
        this.desc = "Deck 'em in the face.";
        this.img = null;
        this.type = new Element("earth");
        this.power = 13.0;
    }
}
