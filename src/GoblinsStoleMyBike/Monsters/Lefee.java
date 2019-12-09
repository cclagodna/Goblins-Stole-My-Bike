package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;


public final class Lefee extends Abstract_Monster{
    
    
    public Lefee() {
        this.name = "Lefee";
        this.desc = "dispite the name he is quite rich but he is not french.";
        this.img = new Image(getClass().getResourceAsStream("Icons/Lefee.png"));
        this.type = new Element("Grass");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new LeafStab();
        this.att2 = new Restore();
        this.att3 = new Shake();
        this.att4 = new AcidBite();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(20 + 7.5 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(15 + 10 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(12 + 2 * level) );
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
                levelUpAttack = new WaterRocket();
                return levelUpAttack;
            case 3:
                levelUpAttack = new EarthCrush();
                return levelUpAttack;
            case 4:
                levelUpAttack = new Hypnotic();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Heal();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
