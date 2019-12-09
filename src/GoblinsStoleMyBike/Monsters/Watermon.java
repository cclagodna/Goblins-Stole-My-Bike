package GoblinsStoleMyBike.Monsters;

import GoblinsStoleMyBike.*;
import GoblinsStoleMyBike.Attacks.*;
import GoblinsStoleMyBike.Element;
import javafx.scene.image.Image;

public final class Watermon extends Abstract_Monster{
    
    
    public Watermon() {

        this.name = "Watermon";
        this.desc = "Water are you looking at?";
        this.img = new Image(getClass().getResourceAsStream("Icons/Watermon.png"));
        this.type = new Element("Water");
        scaleHealth();
        scaleStrength();
        scaleDefense();

        this.currHealth = this.baseHealth;
        this.currStrength = this.baseStrength;
        this.currDefense = this.baseDefense;
        
        this.att1 = new Kick();
        this.att2 = new WaterRocket();
        this.att3 = new EarthCrush();
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
        setBaseStrength( Math.floor(25 + 1 * level) );
    }
    
    public void scaleDefense() {
        //Note stats as they level up
        //Lvl 1 - 5: 2, 3, 4, 5, 6
        setBaseDefense( Math.floor(8 + 8 * level) );
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
                levelUpAttack = new Heal();
                return levelUpAttack;
            case 3:
                levelUpAttack = new Melt();
                return levelUpAttack;
            case 4:
                levelUpAttack = new MeteorBash();
                return levelUpAttack;
            case 5:
                levelUpAttack = new AirBlast();
                return levelUpAttack;
            default:
                return null;
        }
    }
    
}
