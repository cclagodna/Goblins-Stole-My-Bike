package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Firemon extends Abstract_Monster{
    
    
    public Firemon() {
        this.name = "Firemon";
        this.desc = "Firemon has a part time job at Pizzahut he wants to quit.";
        this.img = new Image(getClass().getResourceAsStream("Icons/Firemon.png"));
        this.type = new Element("Fire");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Lick();
        this.att2 = new Kick();
        this.att3 = new Explosion();
        this.att4 = new AcidBite();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(23 + 2 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(22 + 10 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(10 + 5 * level) );
    }
    
    public void levelUp() {
        //Monsters cap out at level 5. no need to do anything here.
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
                levelUpAttack = new Restore();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Strangle();
                return levelUpAttack;
            case 4:
                levelUpAttack = new LightBeam();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Shake();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
