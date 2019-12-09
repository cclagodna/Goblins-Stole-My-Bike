package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;
import java.util.concurrent.ThreadLocalRandom;

public class Heal extends Abstract_Attack{
    
    public Heal() {
        this.name = "Heal";
        this.desc = "Heals 10% - 20% HP.";
        this.img = null;
        this.type = new Element("magic");
        this.power = 0.0;
    }
    
    @Override
    public double calcDamage(Abstract_Monster source, Abstract_Monster target) {
        
        double amount = Math.floor( ThreadLocalRandom.current().nextInt(10, 21) * 0.01 * source.getBaseHealth() );
        
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
