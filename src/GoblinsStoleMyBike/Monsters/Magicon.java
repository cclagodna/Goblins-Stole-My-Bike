package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Magicon extends Abstract_Monster{
    
    
    public Magicon() {

        this.name = "Magicon";
        this.desc = "Tis not luck, but skill!";
        this.img = new Image(getClass().getResourceAsStream("Icons/Magicon.png"));
        this.type = new Element("Magic");

        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new WaterRocket();
        this.att2 = new Kick();
        this.att3 = new Shake();
        this.att4 = new Hypnotic();
    }

    public void scaleHealth() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseHealth( Math.floor(30 + 4 * level) );
    }
    
    public void scaleStrength() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseStrength( Math.floor(15 + 6 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(8 + 5.5 * level) );
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
                levelUpAttack = new Lick();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Restore();
                return levelUpAttack;
            case 4:
                levelUpAttack = new LightBeam();
                return levelUpAttack;
            case 5:
                levelUpAttack = new Melt();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
