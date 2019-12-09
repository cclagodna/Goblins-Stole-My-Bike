package GoblinsStoleMyBike.Attacks;
import GoblinsStoleMyBike.*;

public class AcidBite extends Abstract_Attack{
    
    public AcidBite() {
        this.name = "AcidBite";
        this.desc = "Bite 'em in the face.";
        this.img = null;
        this.type = new Element("corrosive");
        this.power = 14.0;
        
    }
}
