package GoblinsStoleMyBike.Attacks;

import GoblinsStoleMyBike.*;
import java.util.concurrent.ThreadLocalRandom;

public class MeteorBash extends Abstract_Attack{
    
    public MeteorBash() {
        this.name = "MeteorBash";
        this.img = null;
        this.type = new Element("space");
        this.power = 20;
    }
    
    @Override
    public double calcDamage(Abstract_Monster source, Abstract_Monster target) {
        //1 or 2 (heads / tails)
        double coinFlip = ThreadLocalRandom.current().nextInt(1, 3);
        
        if (coinFlip == 1) {
            double elementMultiplier = 1;
        
            if (target.isWeak(this.getElement())) {
                elementMultiplier = 1.50;
            }
            else if (target.isResist(this.getElement())) {
                elementMultiplier = 0.7;
            }

            double damage = Math.floor( elementMultiplier * (source.getCurrStrength() * this.getPower()) / (source.getCurrStrength() + target.getCurrDefense()) );
            if (damage <= 1) damage = 1;
            return damage;
        }
        
        //Must return 0 as the source monster is dealing 0 damage
        return 0;
    }
    
}
