package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;
import java.util.concurrent.ThreadLocalRandom;

public class Restore extends Abstract_Attack{
    
    public Restore() {
        this.name = "Restore";
        this.img = null;
        this.type = new Element("grass");
        this.power = 0.0;
    }
    
     @Override
    public double calcDamage(Abstract_Monster source, Abstract_Monster target) {
        
        //Level 1: 2 - 9 -> Level 5: 2 - 13
        double amount = ThreadLocalRandom.current().nextInt( 2, 9 + source.getLevel());
        
        if (source.getCurrHealth() < source.getBaseHealth() - amount) {
            source.setCurrHealth(source.getCurrHealth() + amount);
        }
        else {
            source.setCurrHealth(source.getCurrHealth());
        }
        
        //Must return 0 as the source monster is dealing 0 damage
        return 0;
    }
    
}
