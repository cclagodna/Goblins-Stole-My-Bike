package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Baseon extends Abstract_Monster{
    
    
    public Baseon() {
        this.name = "Baseon";
        this.desc = "The most basic monster to ever live!";
        this.img = new Image(getClass().getResourceAsStream("Icons/Baseon.png"));
        this.type = new Element("Basic");
        
        scaleHealth();
        scaleStrength();
        scaleDefense();
        
        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new GreenSpit();
        this.att2 = new Kick();
        this.att3 = new Heal();
        this.att4 = new Hypnotic();
    }
    
    public void scaleHealth() {
        setBaseHealth( Math.floor(30 + 5 * level) );
    }
    
    public void scaleStrength() {
        setBaseStrength( Math.floor(10 + 7 * level) );
    }
    
    public void scaleDefense() {
        setBaseDefense( Math.floor(10 + 7 * level) );
    }
    
    public void levelUp() {
        if (this.level < 5) {
            this.level++;
            scaleHealth();
            scaleStrength();
            scaleDefense();
            learnNewAttack();
            resetCurrStats();
        }
    }
    
    public Abstract_Attack learnNewAttack() {
        //Since monsters can only know 4 attacks must replace old attack with new
        
        Abstract_Attack levelUpAttack;
        
        switch(level) {
            case 2:
                levelUpAttack = new LeafStab();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Restore();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Explosion();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
